# day27

## HTML

### 标签分类

- 块级标签：独占一行，可指定高度和宽度。比如：div、p、h1-h6、html、body、列表标签等
- 行级标签：标签同一行显示，宽度和高度由内容决定。比如：span、a、i、em等
- 行级块标签：同时具备行标签和块标签的特点，标签同一行显示，可以设置宽高。比如：img 、input

### 结构标签

- \<html>\</html>

- \<head>\</head>

- \<title>\</title>

- \<body>\</body>

  ```html
  <!DOCTYPE html>
  <html>
      <head>
          <meta charset="UTF-8">
          <title>One Price</title>
      </head>
      <body>
          GG Bond
      </body>
  </html>
  ```

### 排版标签

- 注释标签\<!-\- -\->

- 换行标签\<br>

- 段落标签\<p>

  align：对齐方式，left、center、right

- 水平线标签\<hr>

  width size color align

### 标题标签

\<h1>\</h1> —— \<h6>\</h6>

### 容器标签

- \<div>\</div>

  属于块级标签，独占一行，有高度和宽度

- \<span>\</span>

  属于行级标签，所有内容都在同一行，没有高度和宽度

### 列表标签

- 无序列表\<ul>\</ul>

  | **属性值** | **描述** | **用法举例**             |
  | ---------- | -------- | ------------------------ |
  | circle     | 空心圆   | <ul  type="circle"></ul> |
  | disc       | 实心圆   | <ul  type="disc"></ul>   |
  | square     | 黑色方块 | <ul  type="square"></ul> |

- 有序列表\<ol>\</ol>

  | **属性值** | **描述**     | **用法举例**                                           |
  | ---------- | ------------ | ------------------------------------------------------ |
  | **1**      | **数字类型** | **<****o****l  type="****1****"></****o****l>**        |
  | **A**      | **大写字母** | **<****o****l  type="****A****"></****o****l>**        |
  | **a**      | **小写字母** | **<****o****l  type="****a****"></****o****l>**        |
  | **I**      | **大写罗马** | **<****o****l** **type="****I****"></****o****l****>** |
  | **i**      | **小写罗马** | **<****o****l** **type="****i****"></****o****l****>** |

### 图片标签

\<img>\</img>

| **属性名** | **描述**                               |
| ---------- | -------------------------------------- |
| **src**    | **引入图片的地址、绝对地址或相对地址** |
| **width**  | **图片的宽度**                         |
| **height** | **图片的高度**                         |
| **align**  | **对齐显示方式**                       |
| **alt**    | **替换信息，当图片不显示时**           |
| **title**  | **鼠标悬停显示内容**                   |
| **hspace** | **在图片左右设定空白**                 |
| **vspace** | **在图片上下设定空白**                 |

### 超链接标签

\<a>文本或图片\</a>

- 页面跳转：\<a href=“页面地址” target=“模式”>文本或图片\</a>

  |  模式   |             **描述**             |
  | :-----: | :------------------------------: |
  | _blank  |           新窗口中打开           |
  |  _self  |       自身窗口中打开，默认       |
  | _parent |          在父窗口中打开          |
  |  _top   |         在顶级窗口中打开         |
  | 自定义  | 自定义名称窗口，不会打开多个窗口 |

- 锚链接：跳转指定位置

  定义位置： \<a name="名称">\</a>

  指向：\<a href="#名称">文本或图片\</a>

- 空链接：不做任何操作

  \<a href="###">文本或图片\</a>

### 表格标签

- table: 表示定义表格

- - border: 表格的边框
  - width: 表格的宽度
  - height:表格的高度
  - align: 表格的对齐方式 left center right
  - bgcolor: 表格背景颜色

- tr: 表示定义一行

- td: 表示定义一列

- - align: 单元格中内容水平对齐方式 left center right
  - valign:单元格中内容垂直对齐方式 top middle bottom

- th: 表示定义一列标题，居中，加粗显示

- 列合并：colspan=“1”

- 行合并：rowspan=“1”

### 表单标签

\<form>\</form>

| 属性名  | 代码                                | 描述                                            |                |
| ------- | ----------------------------------- | ----------------------------------------------- | -------------- |
| action  | \<form action="服务器地址">\</form> | 把表单数据提交到该地址                          |                |
| method  | \<form method="提交方式">\</form>   | get：不安全、数据有限；post：安全、没有大小限制 |                |
| enctype | \<form enctype="编码方式">\</form>  | application/x-www  -form-urlencoded             | 默认，普通表单 |
|         |                                     | multipart/form-data                             | 文件上传使用   |

#### 表单元素

|  属性值  |     描述     |                代码                 |
| :------: | :----------: | :---------------------------------: |
|   text   |  单行文本框  |       \<input  type="text" />       |
| password |    密码框    |     \<input  type="password" />     |
|  radio   |   单选按钮   |      \<input  type="radio" />       |
| checkbox |    复选框    |     \<input  type="checkbox" />     |
|  submit  |   提交按钮   |      \<input  type="submit" />      |
|  button  |   普通按钮   |      \<input  type="button" />      |
|  reset   |   重置按钮   |      \<input  type="reset" />       |
|  image   | 图片提交按钮 | \<input  type="image" src="..."  /> |
|   file   |     文件     |       \<input  type="file" />       |
|  hidden  |    隐藏域    |      \<input  type="hidden" />      |
|  email   |     邮箱     |       \<input type="email" />       |
|  number  |     数值     |      \<input  type="number" />      |
|  range   |     滑块     |      \<input  type="range" />       |
|  color   |    取色框    |      \<input  type="color" />       |
|   date   |    日期框    |       \<input  type="date" />       |
|   time   |    时间框    |       \<input type="time" />        |

### 框架标签

\<iframe>\</iframe>

### 其他标签

1. \<!--meta作用1：指定网页的编码-->

   \<meta charset="UTF-8">\</meta>

2. \<!--meta作用2：指定网页的关键字，和搜索引擎有关-->
   \<meta name="keywords" content="IT培训,Java开发,分布式开发">

3. \<!--meta作用3：实现定时跳转-->

   \<!-- \<meta http-equiv="refresh" content="5;url=index.html">-->

| 标签   | 描述                   |
| ------ | ---------------------- |
| meta   | 定义网页元信息         |
| link   | 链接样式表             |
| script | 定义JS代码、关联JS文件 |

### 特殊字符

| 特殊字符 | 描述     |
| -------- | -------- |
| &nbsp;   | 空格     |
| &gt;     | >        |
| &lt;     | <        |
| &reg;    | 注册符号 |
| &quot;   | 双引号   |
| &yen;    | 人民币   |
