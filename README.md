# qf_study
从零开始的Java学习记录我的学习过程

## day04

- 学习了三种循环结构以及他们的区别
- 了解了成员变量，局部变量 

## day05

- 学习了方法和数组

- 了解了static关键字修饰静态方法后，可以直接调用

- 不使用st关键字修饰方法，必须先创建对象再调用
- 栈存储数组的下标和地址、局部变量，堆存储实际数据

## day06

- 学习了内存的基本知识，知道栈内存储基本数据类型的实际数据、引用类型的地址，堆内存储引用数据类型的实际数据
- 学习了数组的排序：冒泡排序、选择排序、插入排序、希尔排序、快速排序
- 学习了数组的查找：遍历查找、二分查找（需要数组是有序数组）

## day07

- ##### 学习了Arrays工具类

  - toString()方法——数组转为字符串
  - sort()方法——数组排序
  - binarySearch()方法——数组二分查找元素
  - copy()方法——数组复制
  - copyOf()方法——数组复制并扩容
  - copyOfRange()方法——数组按范围复制
  - fill()方法——数组替换为指定数字

- 学习了二维数组
- 学习了面向的对象的基本原理
- 学习了方法重载
  - 参数列表、参数个数、参数顺序不同的同名方法
  - 与返回值、方法修饰符无关
- 学习了构造方法
- 学习了创建对象的过程
  - 在堆中开辟空间，属性是默认值
  - 执行构造方法中的代码
  - 将对象地址赋值给局部变量
- 学习了this关键字

## day08

- 学习了文档注释
- 学习了调试技巧
- 学习了封装
  1. 使用private 修饰属性
  2. 添加公开的get、set方法
  3. 在方法中添加逻辑判断，避免非法数据的录入

## day09

- 学习了三大特性封装、继承、多态
- super、this的区别                               

## day10

- 学习了三个修饰符abstecat、static、final
- abstecat不能和static一起使用
- abstecat不能和final一起使用
- 使用abstecat子类必须重写方法
- 使用static不能重写方法，只能重载

## day11

- 学习了接口的概念
- 从宏观角度来看，接口就是一种标准
- 从微观角度来看，接口就是一种能力、约定
- 接口可以理解为特殊的抽象类
- 了解了面向对象的七大设计原则
- 学习了四种内部类

## day12

- 学习了Object类，以及它的方法
- 学习了包装类，以及它的方法
- 学习了String类，以及它的方法
- 学习了可变字符串，StringBuilder、StringBuffer

## day13

- 学习了正则表达式
- 学习了BigDecimal类、Math类、Random类、Data类、SimpleTimeFormat类、Calendar类、System类、Runtime类
- 学习了异常的抛出、声明、定义

## day14

- 学习了集合
- 学习了ArrayList、LinkedList
- 学习了数组、链表、栈、队列类的方法
- 学习了hashSet 重写hashCode、equals方法

## day15

- 学习了set集合map集合
- 了解了红黑树的数据结构，二叉查找树的实现
- 学习了线程的第一种创建方式

## day16

- 学习了多线程的一系列知识
- 学习了创建线程
- 学习了线程的6种方法和线程的6种状态
- 学习了锁的概念与用法

## day17

- 学习了高级多线程
- 学习了创建线程池的6种方式
- 学习了线程池的7个参数，5种拒绝策略
- 学习了Lock锁和ReadWriteLock锁
- 学习了Condition条件队列和Lock锁结合使用，实现多个线程之间通信
- 学习了synchronized和Lock区别

## day18

- 学习了线程安全的集合
- 学习了CAS算法
- 学习了乐观锁、悲观锁
- 学习了Queue接口、BlockingQueue接口（阻塞队列）、多线程三个特性（原子性【互斥性】、可见性【JMM】、有序性【禁止指令重排】）
- 学习了I/O中的File、FileInputStream、FileOutputStream
- 学习了自带缓存区的BufferedInputStream、BufferedOutputStream

## day19

- 学习了全部的I/O框架
- 区分了字节流、字符流各自的用法
- 学习了网络编程中的socket
- 学习了TCP开发

## day20

- 学习了TCP、UDP开发实例
- 学习了反射机制
- 学习了对象的四种创建方式
- 学习了内省以及它的工具类

## day21

- 学习了设计模式中的简单工厂模式、单例模式中的三种
- 学习了枚举类型
- 学习了注解的自定义已经使用
- 学习了LocalDateTime、Instant、ZoneId、DateTimeFormatter，以及Date、Instant、LocalDateTime的转换
- 学习了Stream流以及它的三种操作中的方法
- 学习了JDK8、9、10、11、14、17的新特性

## day22

- 学习了数据库对库的基本操作
- 学习了数据库对表的基本查询操作

## day23

- 学习了子查询、作条件、作枚举（in）、做临时表（as）
- 学习了合并查询（union）、连接查询的三种crpss join、inner join…on、left outer join on、right outer join on
- 学习了数据操作DML的增删改
- 学习了表操作DDL的创建、修改、删除
- 学习了约束的三种完整性约束、域完整性约束、引用完整性约束
- 学习了事务的创建、提交、回滚
- 学习了事务的四种性质、以及四种隔离等级

## day24

- 学习了MySql的权限管理
- 学习了MySql的视图操作
- 学习了JDBC操作数据库、防止SQL注入

## day25

- 学习了ORM、DAO、Impl
- 学习了ThreadLocal中的ThreadLoaclMap读取Connectin对象
- 学习了JDBC事务的创建、提交、回滚、关闭

## day26

- 学习了三层架构表示层、服务层、持久层
- 学习了连接池连接数据库
- 学习了commons_dbutils工具类

## day27

- 学习了html的各种标签、以及使用方法

## day28

- 学习了css的选择器、各种属性以及盒子模型

## day29

- 学习了HTTP协议的格式
- 学习了Servlet的创建、以及配置

## day30

- 学习了servlet的生命周期
- 学习了rerquest对象、response对象以及各自的方法

## day31

- 学习了Cookie、Seesion的使用
- 学习了application的使用
- 学习了三个域对象的区别

## day32

- 学习了JSP的使用方法
- 学习了JSP的指令
- 学习了EL表达式
- 学习了JSTL标签库
