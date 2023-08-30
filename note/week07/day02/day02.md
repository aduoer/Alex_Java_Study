# day31

## Servlet状态管理

- 客户端状态管理技术：将状态保存在客户端，代表性的是**Cookie技术**
- 服务器状态管理技术：将状态保存在服务器端，代表性的是**Session技术**

## Cookie

1. 创建Cookie：

   Cookie cookie = new Cookie(“name”,“value”);

2. 设置Cookie的有效路径：

   cookie.setPath(reqeust.getContextPath);

3. 设置Cookie的生命周期：

   cookie.setMaxAge(-1);

   - 取值有三种
   -  0：有效期，单位秒；多少秒之后失效。
   - =0：浏览器删除cookie；
   - -1：浏览器关闭则失效，默认值

4. 设置HttpOnly

   setHttpOnly(true);//脚本不能访问，使用HTTP协议读取

5. 响应给客户端

   response.addCookie(cookie);

6. 服务端获取Cookie

   ```java
   Cookies[] cookie = request.getCookies();
   ```

   

### Cookie的乱码

Cookie的name默认不支持中文，只能包含ASCII字符

#### 编码与解码

- 编码：java.net.URLEncoder类的encode(String str,String encoding)方法
- 解码：java.net.URLDecoder类的decode(String str,String encoding)方法

## Session

- 获取Session

Session是由服务端自动创建的，通过request对象获取：

HttpSession session=request.getSession();

- 输出Session信息

  - sessionId：session.getId()

  - session有效期：session.getMaxInactiveInterval()

  - session创建时间：new Date(session.getCreationTime())

  - session最后一次访问时间：new Date(session.getLastAccessedTime()))

- web.xml配置Session有效期

```xml
<session-config>
    <session-timeout>20</session-timeout>
</session-config>
```

- Session保存数据：以键值对形式存储在session作用域中：

  session.setAttribute("key",value);

- Session获取数据：通过String类型的key访问Object类型的value：

  session.getAttribute("key");

- Session移除数据：通过key移除session作用域中的值：

  session.removeAttribute("key");

## ServletContext(application)

获取ServletContext

- this.getServletContext()方法。【推荐】
- request.getServletContext()方法。【推荐】
- session.getServletContext()方法。

### ServletContext作用1：

作为全局容器【域】：

- 存储数据：

  application.setAttribute("name",value);

- 获取数据：

  application.getAttribute("name");

- 移除数据：

application.removeAttribute("name");

### ServletContext作用2：获取路径

- 获取应用上下文路径：

  System.out.println(application.getContextPath());

  System.out.println(request.getContextPath());//推荐

- 获取项目真实路径：

  String realpath=application.getRealPath("");

- 读取web下面的文件使用application.getRealPath("")

- 读取类路径（从src复制来的）下面的文件使用类加载器读取

## 容器(域对象)

1. request：

   一次请求，请求响应之前有效

2. session：

   一次会话开始，浏览器不关闭或服务器session不超时之前有效

3. ServletContext：

   服务器启动开始，服务器停止之前有效

使用域对象传递数据时，能用作用范围小的容器不要用大的。

