# day07

## Arrays工具类

- ### toString()方法

​	数组转为字符串

- ### sort()方法

​	数组排序

- ### binarySearch()方法

​	数组二分查找

- ### copy()方法

​	复制数组

- ### copyOf()方法

​	复制数组元素，并扩容

- ### copyOfRange()方法

​	复制指定范围的数组元素

- ### fill()方法

​	将数组中全部元素更改为指定数字

## 二维数组

1. ### 先声明、再分配空间：

   数据类型[][] 数组名;

   数组名 = new 数据类型[低维长度][高维长度];

2. ### 声明并分配空间：

   数据类型[][] 数组名 = new 数据类型[低维长度][高维长度];

3. ### 声明并赋值（繁）：

   数据类型[][] 数组名 = new 数据类型[低维长度][]; //不规则数组

4. ### 声明并赋值（简）：

   数据类型[][] 数组名 = { {v1,v2,v3},{v4,v5},{v6,v7,v8,v9} }; //显示初始化

### 杨辉三角形

```java
  private static void demo03(){
        int [][] triangle = new int [7][];
        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int [i + 1];
            for (int j = 0; j < triangle[i].length; j++) {
                //定义两边元素
                if(j == 0 || j == i) triangle[i][j] = 1;
                //定义中间元素
                else triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        for (int i = 0; i < triangle.length; i++) {
            //输出空格
            System.out.printf("%" + (triangle.length - i) * 2 + "s","");
            //输出元素
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.printf("%-4d",triangle[i][j]);
            }
            System.out.println();
        }
    }
```

## 面向对象

### 方法重载

- 一个类中定义多个相同名称的方法，参数列表不同。

- 重载规则

  - 方法名称相同，参数列表不同(类型、个数、顺序)。

  - 与方法修饰符、返回值类型无关。

  - 调用带有重载的方法时，需要根据传入的实参去找到与之匹配的方法。

- 好处：灵活、方便、屏蔽使用差异。

### 方法重写

### 构造方法

- 类中的特殊方法，主要用于创建对象，初始化属性

- 名称与类名完全相同，没有返回值类型

- 创建对象并初始化时，自动触发构造方法的调用

- 注意：如果没有在类中显示定义构造方法，则编译器默认提供无参构造方法

### 对象的创建过程

1. 在堆中开辟空间，属性默认值

   new(开辟空间)、dup(复制空间的地址)

2. 执行构造方法中的代码

   invokespecial

3. 把对象地址赋值局部变量

   astore_1

### this关键字

​	this是类中的默认引用，代表当前对象（实例），当类服务于某个对象时，this则指向这个对象。

- 在构造方法中，调用本类的其他构造方法，即可复用构造方法中的逻辑代码。
- 两个构造方法当中，包含多条冗余代码
- this()：调用无参构造、this(实参)：调用有参构造、注：必须在构造方法的首行
