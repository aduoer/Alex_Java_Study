# day28

# CSS

## 基本语法

### css规则由两部分组成：选择器以及多条声明

- 选择器：需要改变样式的html元素
- 声明: 由属性名和属性值组成，属性名和属性值之间使用冒号隔开，每个属性分号隔开.
- css注释/* */

## HTML中如何引用CSS文件

- 内联方式: 把样式写在html标签中，类似与属性
- 内部方式：把样式写在head标签中style标签中
- 外部方式：把样式抽成独立的css文件，使用link标签关联或@import导入
- 优先级：内联优先级>内部和外部，内部和外部遵循就近原则

## CSS选择器

### 标签选择器

- 使用html标签作为选择器

### id选择器

- 需要给添加样式的html元素添加id属性标识

### class选择器

- 需要给添加样式的html元素添加class属性标识

优先级：id选择器> class选择器 > 标签选择器 

### 层级选择器

- 后代选择器：父级 子级
- 子代选择器：父级>子级

### 属性选择器

- 使用元素的属性以及属性值选择元素

- \[type]: 选择有type属性的元素

- \[type='text']: 选择type属性值为text的元素

- \[type^='pass']: 选择type属性值以pass开头的元素

- \[type$='word']: 选择type属性值以word结尾的元素

- \[type*='ss']: 选择type属性值包含ss的元素

  ```css
  /*属性选择器 */
  [type*='sub']{
      background-color: skyblue;
  }
  ```

### 伪类选择器

- 使用元素的属性以及属性值选择元素

- a:link 对超链接的初始状态样式设置

- a:visited 对超链接访问之后的状态样式设置

- a:hover 对超链接鼠标经过状态样式设置

- a:active 对超链接激活状态样式设置

  ```css
  /*伪类选择器*/
  /* a:link {
  color: black;
  text-decoration: none;
  }
  a:visited{
  color: black;
  }
  a:hover{
  text-decoration: underline;
  }
  a:active{
  color: blue;
  }*/
  /*对四个状态同一设置*/
  a {
      color: black;
      text-decoration: none;
  }
  /*鼠标经过*/
  a:hover{
      text-decoration: underline;
  }
  ```

## CSS属性

### 文字属性

| 属性名      | 取值                   | 描述               |
| ----------- | ---------------------- | ------------------ |
| font-size   | 数值                   | 设置字体大小       |
| font-family | 字体                   | 设置字体类型       |
| font-style  | normal正常、italic斜体 | 设置字体样式(斜体) |
| font-weight | 100~900数值、bold      | 设置字体粗细       |

简写：font:italic bold 20px '黑体';

​          s   	w    s    f

```html
    <style>
      p {
        /*字体大小，单位px 默认16px*/
       /* font-size: 20px;*/
        /*字体类型，默认微软雅黑*/
        /*font-family: "宋体","黑体","楷体";*/
        /*文字样式 , 正常，斜体*/
       /* font-style: italic;*/
        /*字体粗细，100 - 900  bold bolder*/
        /*font-weight: 600;*/
        /*简写
        swsf : style weight size family
        */
        font:italic 600 20px "宋体","黑体","楷体";
      }
    </style>
```

### 文本属性

| 属性            | 取值                                   | 描述                   |
| --------------- | -------------------------------------- | ---------------------- |
| color           | 十六进制或表示颜色的英文单词           | 设置文本颜色           |
| text-indent     | 2em                                    | 缩进元素中文本的首行   |
| text-decoration | underline;overline                     | 文本的装饰线           |
| text-align      | left、right、center                    | 文本水平对齐方式       |
| vertical-align  | top、middle、bottom                    | 设置元素的垂直对齐方式 |
| line-height     | normal、固定值                         | 设置文本的行高         |
| text-shadow     | 水平偏移、垂直偏移、模糊距离、阴影颜色 | 设置阴影及模糊效果     |

```html
<style>
    p {
      color: green;
      /*水平对齐*/
      text-align: center;
    }
    div{
      /*em:1倍字体的大小  */
      text-indent: 2em;
      /*文本修饰:underline 下划线  overline 上划线 line-through 删除线*/
      /*text-decoration: underline 1px blue dashed;*/
      /*text-decoration-color: blue;*/
      /*text-decoration-thickness: 1px;*/
     /* text-decoration-style: dashed;*/
      /*line-height行高*/
       /* text-underline-offset: 10px;*/

      line-height: 50px;
    }
    #img1 {
      vertical-align: bottom;
    }
  </style>
```

### 背景属性

| 属性                | 取值                                | 描述             |
| ------------------- | ----------------------------------- | ---------------- |
| background-color    | 表示颜色的英语单词或RGB模式         | 设置背景色       |
| background-image    | url('图片路径')                     | 设置背景图片     |
| background-repeat   | repeat-y;repeat-x;repeat;no-repeat; | 背景图的平铺方向 |
| background-position | top;bottom;left;right  ; center;    | 背景图片的位置   |

```html
 <style>
        #div1 {
            height: 300px;
            /*背景颜色*/
            background-color: skyblue;
            /*背景图片*/
            background-image: url("images/1144.png");
            /*背景图片的平铺方向
                repeat-x:水平方向
                repeat-y:垂直方向
                repeat: 平铺
                no-repeat:不平铺
            */
            background-repeat:no-repeat;
            /*设置图片的位置*/
            background-position: center;
            /*背景图片的大小
            cover:完全覆盖
            contain:保留空白
            自定义大小
            */
            background-size: 100px 200px;
        }
    </style>
```

### 列表属性

- list-style-type: 列表项前面的符号

  - circle: 空心圆
  - disc: 实心圆
  - square:方块
  - decimal: 数字
  - lower-alpha:小写字母
  - upper-alpha:大写字母
  - lower-roman:小写罗马数字
  - upper-roman:大写罗马数字

- list-style-image: 定义列表图片

- list-style-position:列表图片的位置

  ```html
  <style>
          #myul {
              /*circle: 空心圆
                disc: 实心圆
                square:方块
                decimal: 数字
                lower-alpha:小写字母
                upper-alpha:大写字母
                lower-roman:小写罗马数字
                upper-roman:大写罗马数字
              */
              list-style-type: none;
              /*列表图片*/
              /*list-style-image: url("images/111.png");*/
              /*指定列表图片位置
                  li的内部和外部
              */
              /*list-style-position: outside;*/
              border: 1px solid green;
              padding: 0;
          }
          #myul li{
              border: 1px solid red;
          }
      </style>
  ```

### 尺寸、显示、轮廓属性

| 属性          | 取值                                                         | 描述           |
| ------------- | ------------------------------------------------------------ | -------------- |
| width         | 数值或百分比                                                 | 设置宽度       |
| height        | 数值或百分比                                                 | 设置高度       |
| display       | none：不显示  block：块级显示  inline：行级显示  Inline-block:行级块显示 | 设置显示方式   |
| outline-style | solid：实线  dotted：虚线  dashed：虚线                      | 设置轮廓的样式 |
| outline-color | 16进制，用于表示颜色的英文                                   | 设置轮廓的颜色 |
| outline-width | 数值                                                         | 设置轮廓的宽度 |

尺寸大小单位：px(像素)、百分比、em(当前字体倍数)、cm(厘米)、in(英寸)、pt(磅)

### 浮动属性

- 实现块级元素一行显示

- left:左浮动
- right:右浮动
- none:未浮动，默认

#### 解决父元素塌陷

1. 给父元素自定义高度
2. 给父元素添加overflow:hidden
3. 给父元素添加空div，添加clear:both
4. 使用伪元素,依靠clear:both

### 清除属性

- 清除浮动元素对其他元素影响

- left:左清除
- right:右清除
- both:全清除

### 溢出属性

- 当前内容超出父元素，怎么处理超出内容

- hidden: 隐藏

- visible: 显示

- scroll: 出现滚动条

- auto: 自动出现滚动条

  ```css
  overflow: auto;/*导致父元素重新计算高，触发了BFC Blocking Format Context 块级格式化上下文*/
  ```

### 定位属性

- static: 静态定位，默认的定位，从上到下，从左到右显示

- relative: 相对定位，相对原始的位置进行偏移。

- absolute: 绝对定位，以离自己最近的非静态定位元素为依据，如果没有相对于html标签。

- fixed:固定定位，以浏览器为依据

  ```html
  <div id="div1" onclick="this.style.display='none'">
         广告内容
  </div>
  ```

## CSS盒子模型

### 边框 border

- border-style:边框样式, solid double dashed dotted
- border-color:边框颜色
- border-width:边框宽度

### 内边距 padding

- padding-top:上内边距
- padding-right:右内边距
- padding-bottom:下内边距
- padding-left:左内边距

### 外边距 margin

- margin-top:上外边距
- margin-right:右外边距
- margin-bottom:下外边距
- margin-left:左外边距

盒子的实际宽度=width+2(padding+border+margin);

盒子的实际高=height+2(padding+border+margin);

盒子水平居中：margin:0 auto;

#### 父元素跟随子元素的margin-top移动

- 给父元素添加border
- 给父元素添加overflow:hidden

## 圆角属性

border-radius: 5px 10px 15px 20px;