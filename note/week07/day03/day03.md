# day32

## JSP语法

### JSP页面

可以包含脚本、脚本表达式、声明、JSP注释、指令、JSP动作标签、EL表达式、JSTL标签、静态内容等

### 脚本

- 脚本可以编写Java语句、声明局部变量
- 语法：<% Java代码 %>
- 输出脚本中不能加 ; 

### 声明

- 语法：<%! 定义成员变量、方法 %>
- 声明中变量是成员变量

### 注释

JSP注释主要有两个作用：

- 为脚本代码作注释
- 为HTML内容注释

和HTML注释区别 

- \<!--HTML注释-->
- <%--JSP注释--%>
- HTML注释，通过浏览器查看网页源代码时可以看见注释内容
- JSP注释，注释内容不会被发送至浏览器

### JSP与Servlet

#### 关系

- JSP文件在容器中会转换成Servlet。
- JSP是对Servlet的一种高级封装。
- 本质还是Servlet

#### 区别

- JSP可以很方便的编写或者修改HTML网页而不用去面对大量的println语句

## JSP指令

| **指令**                | **描述**                                                  |
| ----------------------- | --------------------------------------------------------- |
| **<%@  page ... %>**    | **定义页面的依赖属性，比如脚本语言、error页面、缓存等等** |
| **<%@  include ... %>** | **包含其他文件**                                          |
| **<%@  taglib ... %>**  | **引入标签库的定义，可以是自定义标签**                    |

### Page指令

为容器提供当前页面的使用说明，一个JSP页面可以包含多个page指令

语法：<%@ page attribute1="value1"attribute2="value2" %>

| 属性         | 描述                                                         |
| ------------ | ------------------------------------------------------------ |
| contentType  | 指定当前JSP页面的MIME类型和字符编码格式                      |
| errorPage    | 指定当JSP页面发生异常时需要转向的错误处理页面                |
| isErrorPage  | 指定当前页面是否可以作为另一个JSP页面的错误处理页面          |
| import       | 导入要使用的Java类                                           |
| language     | 定义JSP页面所用的脚本语言，默认是Java                        |
| session      | 指定JSP页面是否使用session。默认为true立即创建，false为使用时创建 |
| pageEncoding | 指定JSP页面本身的编码                                        |
| buffer       | 页面缓冲区大小，默认8KB                                      |

### include指令

- 通过include指令来包含其他文件
- 被包含的文件可以是JSP文件、HTML文件或文本文件
- 包含的文件就好像是当前JSP文件的一部分，会被同时编译执行
- include指令包含称为静态包含

#### jsp动作标签

动作标签用来简化脚本编写，实现特定的功能，是JSP内置的动作标签。

##### jsp:include

- <jsp:include >动作元素会将外部文件输出结果包含在JSP中。
- <jsp:include >动作元素称为动态包含。
- <jsp:include page="相对 URL 地址" />

##### 和include指令区别

- include指令是将外部文件的输出代码复制到了当前JSP文件中。
- jsp:include则不同，是将外部文件的执行结果引入到了当前JSP文件中。

##### jsp:useBean

- 用来创建一个将在JSP页面中使用的JavaBean。
- \<jsp:useBean id="name" class="package.className" />

##### jsp:setProperty

在jsp:useBean元素之后使用jsp:setProperty进行属性的赋值。

| **属性**     | **描述**                                              |
| ------------ | ----------------------------------------------------- |
| **name**     | **name属性是必需的。它表示要设置属性的是哪个Bean。**  |
| **property** | **property属性是必需的。它表示要设置哪个属性。**      |
| **value**    | **value  属性是可选的。该属性用来指定Bean属性的值。** |

##### jsp:getProperty：

jsp:getProperty动作提取指定Bean属性的值，转换成字符串，然后输出

| 属性     | 描述                                   |
| -------- | -------------------------------------- |
| name     | 要检索的Bean属性名称。Bean必须已定义。 |
| property | 表示要提取Bean属性的值。               |

- <jsp:useBean id="user" class="com.qf.entity.User" />
- <jsp:setProperty name="user" property="name"value="gavin" />
- <jsp:getProperty name="user" property="name" />

##### jsp:forward

- jsp:forward动作把请求转到另外的页面
- <jsp:forward page="相对 URL 地址" />

##### jsp:param

- 在转发动作内部使用，做参数传递
- <jsp:param name="" value=""/>

## JSP内置对象

| **对象名**      | **类型**                                   | **说明**                      |
| --------------- | ------------------------------------------ | ----------------------------- |
| **request**     | **javax.servlet.http.HttpServletRequest**  |                               |
| **response**    | **javax.servlet.http.HttpServletResponse** |                               |
| **session**     | **javax.servlet.http.HttpSession**         | **由session=“true”开关**      |
| **application** | **javax.servlet.ServletContext**           |                               |
| **config**      | **javax.servlet.ServletConfig**            |                               |
| **exception**   | **java.lang.Throwable**                    | **由isErrorPage=“false”开关** |
| **out**         | **javax.servlet.jsp.JspWriter**            |                               |
| **pageContext** | **javax.servlet.jsp.PageContext**          |                               |
| **page**        | **java.lang.Object当前对象this**           | **当前servlet实例**           |

### pageContext

#### 操作当前页面域

- pageContext.setAttribute("name",value);
- pageContext.getAttribute("name");
- pageContext.removeAttribute("name");

#### 操作其他域对象：

pageContext.setAttribute("name",value,域范围)

##### 域范围：

- REQUEST_SCOPE
- SESSION_SCOPE
- APPLICATION_SCOPE
- PAGE_SCOPE

pageContext.findAttribute("name")；

从四个域中依次查找：从pageContext、request、session、application，找到为止、如果都没有则返回null。

## 四大域对象

| 域对象      | 应用场景                                                     |
| ----------- | ------------------------------------------------------------ |
| pageContext | 当前页面中使用。                                             |
| request     | 本次请求之后，数据就不再使用了。  比如：根据学号查询学生，根据新闻id查询新闻。 |
| session     | 同一个会话中共享的数据，使用session。比如：用户登录信息      |
| application | 所有用户共享的数据。                                         |

## EL表达式

- ${XxxScope.name} 获取具体某个作用域中的数据
- ${name} 获取作用域中的数据，四个域逐级查找

### 与JSP脚本的区别

- <%=request.getAttribute(name) %>，没有找到返回null 
- ${name}，没找到返回""

### 隐式对象

| 隐式对象         | 描述                          |
| ---------------- | ----------------------------- |
| pageScope        | page  域                      |
| requestScope     | request  域                   |
| sessionScope     | session  域                   |
| applicationScope | application  域               |
| param            | request对象的参数，字符串     |
| paramValues      | request对象的参数，字符串集合 |
| header           | HTTP  信息头，字符串          |
| headerValues     | HTTP  信息头，字符串集合      |
| initParam        | Servlet上下文初始化参数       |
| cookie           | Cookie值                      |
| pageContext      | 当前页面的pageContext         |

#### 获得应用上下文路径

- <%=request.getContextPath() %>
- ${pageContext.request.contextPath}

##### 路径分类

1. 绝对路径: 带协议的完整路径，用在不同网站之间的跳转。

   比如：http://www.baidu.com/aaa/1.jpg

2. 相对路径: 用在同一个主机或域名中。比如：aaa/1.jpg。

   如果页面比较多，并且在不同的目录下，并且使用框架或模板，会出现混乱

3. 根路径:特殊的相对路径，相对整个网站的根目录（域名或主机名）

- 如果地址在浏览器中使用，/ 表示主机名或域名，比如http://localhost:8080/  
- 如果地址在服务器中使用，/ 表示上下文路径，比如 /myweb、/day21web1

## JSTL

- 设置数据\<c:set>\</c:set>

- 添加数据\<c:out>\</c:out>

- 删除数据\<c:remove>\</c:remove>

- if判断\<c:if test ="条件"> \</c:if>

- 多分支

  ```jsp
  <c:choose >
  	<c:when test="条件1">结果1< /c:when> 
  	<c:when test="条件2">结果2< /c:when> 
  	<c:when test="条件3">结果3< /c:when> 
  	<c:otherwise >结果4< /c:otherwise>
  < /c:choose>
  ```

- 循环

  ```jsp
  <c:foreach 
  	var="变量名" 
  	items="数组或集合" 
  	begin="起始下标" 
  	end="结束下标" 
  	step="步长" 
  	varStatus="变量状态">
  < /c:foreach>
  ```

- url标签、formatDate标签

  \<c:url>标签将URL格式化为一个字符串，然后存储在一个变量中

  自动重写URL，如果有中文自动编码

  var属性用于存储格式化后的URL

  ```jsp
  <c:url value='/xxxController' var="myurl"  />
  ```