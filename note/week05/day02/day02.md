# day21

## 设计模式

- 什么是设计模式

  一套被反复使用、多数人知晓的、经过分类编目的、代码设计经验的总结

  可以简单理解为特定问题的固定解决方法

- 好处

  使用设计模式是为了可重用代码、让代码更容易被他人理解、保证代码可靠性、重用性

### 设计模式种类

1. 创建型模式，共五种

   工厂方法模式、抽象工厂模式、单例模式、建造者模式、原型模式 (简单工厂模式)

2. 结构型模式，共七种

   适配器模式、装饰者模式、代理模式、外观模式、桥接模式、组合模式、享元模式

3. 行为型模式，共十一种

   策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、访问者模式、中介者模式、解释器模式

#### 简单工厂模式

```java
//Clothes
public abstract class Clothes {
    //准备
    public abstract void prepare();
    //制作
    public abstract void make();
    //打包
    public abstract void box();
}

//夹克
public class Jacket extends Clothes{
    @Override
    public void prepare() {
        System.out.println("开始准备夹克");
    }

    @Override
    public void make() {
        System.out.println("开始制作夹克");
    }

    @Override
    public void box() {
        System.out.println("开始打包夹克");
    }
}

//裙子
public class Skirt extends Clothes{
    @Override
    public void prepare() {
        System.out.println("开始准备裙子");
    }

    @Override
    public void make() {
        System.out.println("开始制作裙子");
    }

    @Override
    public void box() {
        System.out.println("开始打包裙子");
    }
}

//裤子
public class Trousers extends Clothes{
    @Override
    public void prepare() {
        System.out.println("开始准备裤子");
    }

    @Override
    public void make() {
        System.out.println("开始制作裤子");
    }

    @Override
    public void box() {
        System.out.println("开始打包裤子");
    }
}
//T恤
public class Tshirt extends Clothes{
    @Override
    public void prepare() {
        System.out.println("开始准备T恤");
    }

    @Override
    public void make() {
        System.out.println("开始制作T恤");
    }

    @Override
    public void box() {
        System.out.println("开始打包T恤");
    }
}
//工厂类
public class ClothesFactory {
    private static Properties properties;
    static {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("src\\week05\\day02\\clothes\\clothes.properties");
            properties.load(fis);
            fis.close();
        } catch (Exception e) {
            System.out.println("加载配置文件失败");
        }
    }
    public static Clothes createClothes(int type){
        Clothes clothes = null;
//        if(type == 1){
//            clothes = new Jacket();
//        }else if (type == 2){
//            clothes = new Trousers();
//        }else if(type == 3){
//            clothes = new Tshirt();
//        }
        if(properties.containsKey(Integer.toString(type))){
            try {
                String value = properties.getProperty(Integer.toString(type));
                Class<?> class1 = Class.forName(value);
                clothes = (Clothes) class1.newInstance();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if(clothes != null){
            clothes.prepare();
            clothes.make();
            clothes.box();
        }
        return clothes;
    }
}

//配置文件
1=week05.day02.clothes.Jacket
2=week05.day02.clothes.Trousers
3=week05.day02.clothes.Tshirt
4=week05.day02.clothes.Skirt

//测试类
 	public class Test {
    public static void main(String[] args) {
        System.out.println("----1.夹克---2.裤子---3.T恤----");
        System.out.println("请选择");
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        Clothes clothes = ClothesFactory.createClothes(type);
        if(clothes != null){
            System.out.println("购买成功");
        }else {
            System.out.println("购买失败");
        }
    }
}
```



#### 单例模式

单例（Singleton）：只允许创建一个该类的对象。

实现单例三个步骤

1. 私有化构造方法
2. 在类内部创建一个对象
3. 在类中添加一个公开的方法，返回单例对象

#### 方式1：饿汉式（类加载时创建，天生线程安全）

```java
public class SingleTon1 {
    /**
     * 饿汉式
     * 1. 私有化构造方法
     * 2. 在类内部创建一个对象
     * 3. 在类中添加一个公开的方法，返回单例对象
     */
    private SingleTon1() {
    }
    private static final SingleTon1 Instance = new SingleTon1();
    public static SingleTon1 getInstance(){
        return Instance;
    }

    public void method1(){
        System.out.println("method1");
    }

    public void method2(){
        System.out.println("method2");
    }
}
```

#### 方式2：懒汉式（使用时创建，线程不安全，需加同步）

```java
public class SingleTon2 {
    private SingleTon2(){}
    private static volatile SingleTon2 instance;
    public static SingleTon2 getInstance(){
        //双重检查锁：提高效率 double check lock（DCL）
        if(instance == null) {
            synchronized (SingleTon2.class) {
                if(instance == null){
                    instance = new SingleTon2();
                }
            }
        }
        return instance;
    }
}
```

###### 优化懒汉式(多线程操作下防止指令重排)

- volatile:保证内存可见性，禁止指令重排
- as if serial：单线程情况，无论怎么指令重排，保证结果不变
- happens-before规则：如果操作a，必须要在操作b之前执行，并且操作a的结果对操作b是可见的
- 常见规则：

1. 程序顺序规则 int a = 10; int b = 20; int c = a+b;
2. 传递性规则 a happens-before b  b happens-before a
3. 监视器锁规则 synchronized
4. volatile 变量规则
5. 线程start()规则
6. 线程join()规则
7. 线程interrupt()规则
8. 对象终结规则

#### 方式3：静态内部类写法（使用时创建，线程安全）

```java
public class SingleTon3 {
    private SingleTon3() {
    }
    private static class Holerd{
        private static SingleTon3 instance = new SingleTon3();
    }
    public static SingleTon3 getInstance(){
        return Holerd.instance;
    }

    public void method1(){
        System.out.println("method1");
    }

    public void method2(){
        System.out.println("method2");
    }
}
```

## 枚举类

什么是枚举

- 枚举是一个引用类型，枚举是一个规定了取值范围的数据类型

注意事项

- 定义枚举使用enum关键字
- 枚举中主要包含常量，只写常量名，多个常量之间用逗号隔开，最后分号可写可不写，推荐写
- 枚举也可以包含属性和方法、私有构造方法，必须在常量后面

枚举好处

- 枚举变量只能使用枚举中常量赋值，不能使用其他数据，提高程序安全性

枚举本质

- 枚举是一个最终类，并继承Enum抽象类
- 枚举中常量是当前类型的静态常量

## 注解

### 什么是注解

- 注解(Annotation)是代码里的特殊标记, 程序可以读取注解，一般用于替代配置文件
- 属于引用数据类型

### 注意事项

- 定义注解使用@interface关键字
- 注解中只能包含公开属性，属性后面要写小括号，使用default关键字赋默认值
- 如果属性名是value，赋值时可以省略属性名

### 注解应用

- 注解的典型应用是：可以通过反射技术去得到类里面的注解，以决定怎么去运行类

常见注解：@Override、@Deprecated

```java
 /*
 * 注解属性的数据类型
 * 1 基本数据类型
 * 2 字符串类型
 * 3 Class类型
 * 4 枚举类型
 * 5 注解类型
 * 以及上述的一维数组
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
    //属性
    String name() default "xxx";
    int age() default 0;

    //String value();
}
//使用
public class Student {
    @MyAnnotation(name = "赵云", age = 18)
    public void show() {
        try {
            Class<?> class1 = Class.forName("week05.day02.testannotain.Student");
            Student s1 = (Student) class1.newInstance();
            Method show = class1.getMethod("show");

            MyAnnotation annotation = show.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.name());
            System.out.println(annotation.age());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
//测试
public class Test {
    public static void main(String[] args) {
        Student s  = new Student();
        s.show();
    }
}
```



### 注解属性类型

- String类型
- 基本数据类型
- Class类型
- 枚举类型
- 注解类型
- 以上类型的一维数组

### 元注解

用来描述注解的注解。

@Retention:用于指定注解可以保留的域

- RetentionPolicy.CLASS

  注解记录在class文件中，运行Java程序时, JVM不会保留，此为默认值

- RetentionPolicy.RUNTIME

  注解记录在 class文件中，运行Java程序时，JVM会保留，程序可以通过反射获取该注解

- RetentionPolicy.SOURCE

  编译时直接丢弃这种策略的注解

@Target

- 指定注解用于修饰类的哪个成员

注解本质：接口、属性变成抽象方法

## JDK8新特性

### Lambda表达式

Lambda引入了新的操作符:->(箭头操作符),->将表达式分成两部分

- 左侧：(参数1，参数2…)，表示方法参数列表
- 右侧：{}内部是方法体

注意事项

- 形参列表的数据类型会自动推断
- 如果形参列表为空，只需保留( ) 
- 如果形参只有1个，( )可以省略，只需要参数的名称即可
- 如果执行语句只有一句，且无返回值，{}可以省略，若有返回值，则若想省去{}，则必须同时省略return，且执行语句也保证只有一句
- Lambda不会生成一个单独的内部类文件

### 函数式接口

- 如果一个接口只有一个抽象方法，则该接口称之为函数式接口，函数式接口可以使用Lambda表达式，Lambda表达式会被匹配到这个抽象方法上
- @FunctionalInterface 注解检测接口是否符合函数式接口

#### 常见函数式接口

|        函数式接口        | 参数类型 | 返回类型 |                             说明                             |
| :----------------------: | :------: | :------: | :----------------------------------------------------------: |
| Consumer<T>  消费型接口  |    T     |   void   |          void  accept(T t);对类型为T的对象应用操作           |
| Supplier<T>  供给型接口  |    无    |    T     |                 T  get(); 返回类型为T的对象                  |
| Function<T,R> 函数型接口 |    T     |    R     | R  apply(T t);对类型为T的对象应用操作，并返回类型为R类型的对象。 |
| Predicate<T>  断言型接口 |    T     | boolean  | boolean  test(T t);确定类型为T的对象是否满足条件，并返回boolean类型。 |

```java
public class TestLambda {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("赵云！！！")).start();
        Comparator<Integer> comparator = (a, b) -> a - b;

        //消费型接口
        happy(d-> System.out.println("花费："+d),2000);
        //供给型接口
        System.out.println(Arrays.toString(getNum(() -> new Random().nextInt(100),10)));
        //函数型接口
        System.out.println(handleString(s -> s.toUpperCase(),"hello"));
        //断言型接口
        List<String> list = new ArrayList<>();
        list.add("zhang");
        list.add("zhao");
        list.add("li");
        List<String> lis = filter(s -> s.startsWith("zhao"), list);
        System.out.println(lis);

    }
    //消费型接口
    public static void happy(Consumer<Double> con,double money){
        con.accept(money);
    }
    //供给型接口
    public static int[] getNum(Supplier<Integer> sup, int count){
        int[] nums = new int[count];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sup.get();
        }
        return nums;
    }
    //函数型接口
    public static String handleString(Function<String,String> fun,String s ){
        return fun.apply(s);
    }
    //断言型接口
    public static List<String> filter(Predicate<String> pre, List<String> list){
        List<String> res = new ArrayList<>();
        for (String s : list) {
            if(pre.test(s)){
                res.add(s);
            }
        }
        return res;
    }
}
```

#### 方法引用

方法引用是Lambda表达式的一种简写形式

条件

1. Lambda表达式方法体中只是调用一个特定的已经存在的方法
2. 方法的参数和返回值和接口一致

常见形式

- 对象::实例方法

- 类::静态方法
- 类::实例方法
- 类::new
- 元素类型[]::new

## Stream流

流（Stream）与集合类似，但集合中保存的是数据，而Stream中保存对集合或数组数据的操作

#### Stream特点

- Stream 自己不会存储元素
- Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream
- Stream 操作是延迟执行的，会等到需要结果的时候才执行

#### Stream操作步骤

1. 创建流

   - 通过Collection集合的stream()或parallelStream()方法
   - 通过Arrays类的stream()方法。
   - 通过Stream接口的of()、iterate()、generate()方法
   - 通过IntStream、LongStream、DoubleStream接口中的of、range、rangeClosed方法

   ```java
   public class TestStream1 {
       public static void main(String[] args) {
           ArrayList<String> list = new ArrayList<>();
           list.add("a");
           list.add("d");
           list.add("c");
           list.add("b");
           Stream<String> stream = list.stream();
           stream.filter(s -> s.startsWith("a"))
                   .forEach(System.out::print);
           System.out.println();
           System.out.println("-------Arrays.stream-----------");
           IntStream stream1 = Arrays.stream(new int[]{23, 345, 23, 645, 22, 1});
           stream1.sorted()
                   .forEach(System.out::print);
           System.out.println();
           System.out.println("--------Stream.of----------");
           Stream<int[]> stream2 = Stream.of(new int[]{23, 345, 23, 645, 22, 1});
           stream2.sorted()
                   .forEach(System.out::print);
           System.out.println();
           System.out.println("--------无限迭代流----------");
           Stream<Integer> stream3 = Stream.iterate(0, x -> x = x + 2);
           stream3.limit(10)
                   .forEach(System.out::print);
           System.out.println();
           System.out.println("--------无限生成流----------");
           Stream<Integer> stream4 = Stream.generate(() -> new Random().nextInt(100));
           stream4.limit(10)
                   .forEach(System.out::print);
           System.out.println();
           System.out.println("--------range----------");
           IntStream range = IntStream.range(0,100);
           range.forEach(System.out::print);
           System.out.println();
           System.out.println("---------rangeclosed---------");
           IntStream rangeClosed = IntStream.rangeClosed(0, 100);
           rangeClosed.forEach(System.out::print);
       }
   }
   ```

   

2. 中间操作

   在一个或多个步骤中，将初始Stream转化到另一个Stream的中间操作

   filter、limit、skip、distinct、sorted

   map

   parallel

   ```java
   public class TestStream2 {
       public static void main(String[] args) {
           Employee e1 = new Employee("赵云", 18, 400200);
           Employee e2 = new Employee("关羽", 38, 50000);
           Employee e3 = new Employee("张飞", 38, 20000);
           Employee e4 = new Employee("马超", 28, 13000);
           Employee e5 = new Employee("黄忠", 48, 14000);
           Employee e6 = new Employee("黄忠", 48, 14000);
   
           List<Employee> list = new ArrayList<>();
           list.add(e1);
           list.add(e2);
           list.add(e3);
           list.add(e4);
           list.add(e5);
           list.add(e6);
           //过滤
           System.out.println("---------filter------------");
           list.stream()
                   .filter(e -> e.getSalary() >= 20000)
                   .forEach(System.out::println);
           System.out.println("--------");
           list.stream()
                   .filter(e -> e.getAge() >= 28)
                   .forEach(System.out::println);
           //限制范围
           System.out.println("---------limit------------");
           list.stream()
                   .limit(2)
                   .forEach(System.out::println);
           //跳过
           System.out.println("---------skip------------");
           list.stream()
                   .skip(2)
                   .limit(2)
                   .forEach(System.out::println);
           //去重 hashcode  equals
           System.out.println("---------distinct------------");
           list.stream()
                   .distinct()
                   .forEach(System.out::println);
           //排序
           System.out.println("---------sorted------------");
           list.stream()
                   .distinct()
                   .sorted((o1,o2) -> o1.getAge() - o2.getAge())
                   .forEach(System.out::println);
           //映射
           System.out.println("---------map------------");
           list.stream()
                   .map(Employee::getName)
                   .forEach(System.out::println);
           System.out.println("---------parallel------------");
           list.stream()
                   .parallel()
                   .forEach(System.out::println);
       }
   }
   ```

3. 终止操作

   使用一个终止操作来产生一个结果。该操作会强制之前的延迟操作立即执行，在此之后，该Stream就不能使用了

   forEach、min、max、count

   reduce、collect

   ```java
   public class TestStream3 {
       public static void main(String[] args) {
           Employee e1 = new Employee("赵云", 18, 400200);
           Employee e2 = new Employee("关羽", 38, 50000);
           Employee e3 = new Employee("张飞", 38, 20000);
           Employee e4 = new Employee("马超", 28, 13000);
           Employee e5 = new Employee("黄忠", 48, 14000);
           Employee e6 = new Employee("黄忠", 48, 14000);
   
           List<Employee> list = new ArrayList<>();
           list.add(e1);
           list.add(e2);
           list.add(e3);
           list.add(e4);
           list.add(e5);
           list.add(e6);
   
           System.out.println("---------forEach------------");
           list.stream()
                   .forEach(System.out::println);
           System.out.println("---------min------------");
           System.out.println(list.stream()
                   .min(Comparator.comparingInt(Employee::getAge)));
           System.out.println("---------max------------");
           System.out.println(list.stream()
                   .max(Comparator.comparing(Employee::getSalary)));
           //获取元素个数
           System.out.println("---------count------------");
           System.out.println((long) list.size());
           //统计规约
           System.out.println("---------reduce------------");
           System.out.println(list.stream()
                   .map(Employee::getSalary)
                   .reduce(Double::sum));
           //收集 把元素放入list集合
           System.out.println("---------collect------------");
           System.out.println(list.stream()
                   .map(Employee::getName)
                   .collect(Collectors.toList()));
       }
   }
   ```

### 新时间API

之前时间API存在问题：线程安全问题、设计混乱；可变的

##### 本地化日期时间API

- LocalDate
- LocalTime
- LocalDateTime：类似于Calendar 创建：LocalDateTime now = LocalDateTime.*now*();

方法

- 获取getYear()
- 修改withYear()

```java
public class TestLocalDataTime {
    public static void main(String[] args) {
        //LocalDataTime:本地日期时间
        //LocalData：本地日期
        //LocalTime：本地时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println("今天是: " + now);

        LocalDateTime yesterday = now.minusDays(1);
        System.out.println("昨天是：" + yesterday);

        LocalDateTime tomorrow = now.plusDays(1);
        System.out.println("明天是：" + tomorrow);

        LocalDateTime localDateTime = LocalDateTime.of(2002, 8, 15, 15, 20, 30);
        System.out.println("创建时间是： " + localDateTime);

        //获取时间信息
        System.out.println(now.getYear());
        System.out.println(localDateTime.getHour());
    }
}
```

##### Instant：时间戳，类似于Date 

方法：

- 创建：Instant now = Instant.*now*();与中国时间少8小时
- now.toEpochMilli() 获取毫秒值，1970.1.1至今
- now.minus() 减毫秒值
- now.plus() 加毫秒值

```java
public class TestInstant {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println("今天是: " + now);

        System.out.println(now.toEpochMilli());

        Instant yesterday = now.minusSeconds(24*60*60);
        System.out.println("昨天是：" + yesterday);

        Instant tomorrow = now.plusSeconds(24*60*60);
        System.out.println("明天是：" + tomorrow);

        Instant.parse("2023-08-15T09:11:17.512487100Z");
    }
}
```

ZoneId：时区

```java
public class TestZonId {
    public static void main(String[] args) {
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        for (String availableZoneId : availableZoneIds) {
            System.out.print(availableZoneId+"\t");
        }
        //获取默认时区
        ZoneId zoneId = ZoneId.systemDefault();

        System.out.println("-----LocalDataTime--->Instant--->Date---------");
        LocalDateTime now = LocalDateTime.now();
        Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        System.out.println(date);

        System.out.println("------Instant--->Date--->LocalDataTime------");
        Instant instant1 = date.toInstant();
        LocalDateTime localDateTime = instant1.atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(localDateTime);
    }
}
```

Date、Instant、LocalDateTime的转换

```java
      System.out.println("-----LocalDataTime--->Instant--->Date---------");
        LocalDateTime now = LocalDateTime.now();
        Instant instant = now.atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        System.out.println(date);

        System.out.println("------Instant--->Date--->LocalDataTime------");
        Instant instant1 = date.toInstant();
        LocalDateTime localDateTime = instant1.atZone(ZoneId.systemDefault()).toLocalDateTime();
        System.out.println(localDateTime);
```

DateTimeFormatter：格式化类

```java
public class TestDateTimeFormater {
    public static void main(String[] args) {
        DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        //时间->字符串
        String format = now.format(dtf);
        System.out.println(format);
        //字符串->时间
        LocalDateTime parse = LocalDateTime.parse("2002-2-2 12:12:12");
        System.out.println(parse);
    }
}
```

## JDK9+新特性

### 1、JDK9

> 2017年9月发布JDK9开始，Oracle对于JDK的更新就类似坐火箭一样，非常的迅速。
> 从JDK9JDK中不再提供独立的jre。
> 下面我们来看下JDK9添加的新特性。

#### 1.1 接口变化

> JDK9中，接口中可以包含私有方法，在JDK8版本中是可以包含默认方法和静态方法的。

#### 1.2 Java9 新特性之 String 底层存储结构更换

> JDK8 之前 String 的底层结构类型都是 char [] , 但是 JDK9 就替换成 byte [] 这样来讲，更节省了空间和提高了性能。

#### 1.3 Java9 新特性之异常处理 try 升级

```java
//首先看下 jdk6,7,8,9 的 try catch 的比较
//Java6 处理方式：每一个流打开的时候都要关闭
@Test
public void test6(){
    InputStreamReader reader = null;
    try{
        reader = new InputStreamReader(System.in);
        reader.read();
    }catch (IOException e){
        e.printStackTrace();
    }finally {
        if (reader != null){
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

//java7和8及 每一个流打开的时候都要关闭,但是在try的括号中来进行关闭
@Test
public void test7_8(){
    try(InputStreamReader reader =new InputStreamReader(System.in)){
        reader.read();
    }catch (IOException e){
        e.printStackTrace();
    }
}
//java9及 每一个流打开的时候都要关闭,但是在try的括号中来进行关闭，在
//java8的基础上进一步升级 直接在try括号中直接写入 变量就好，如果有多个流，就用分号隔开
//try(reader;writer){}
@Test
public void test9(){
    InputStreamReader reader =new InputStreamReader(System.in);
    try(reader){
        reader.read();
    }catch (IOException e){
        e.printStackTrace();
    }
}
```



#### 1.4 集合添加了of方法

```java
public class Demo1 {
    public static void main(String[] args) {
        List<String> list = List.of("xxx", "yyy", "ccc");
        list.add("zzz");

        for (String s : list) {
            System.out.println(s);
        }
    }
}
```



### 2、JDK11

> JDK11于2018年09月25正式发布。

#### 2.1  支持源文件直接运行(无需javac)

```
java Demo.java  //自动完成Demo.java的编译和运行，没有生成class文件。如果想生成class文件，还需要使用javac编译。
```



#### 2.2 关于变量定义

> 在JDK11中，可以使用var关键字定义变量，类似于JavaScript中var。但是var关键字使用有一些限制。
> 1.只能声明局部变量，不能声明成员变量
> 2.声明时必须赋值，而且不能分割成两句，否则无法推荐类型

#### 2.3 针对String提供的新功能

> 从jdk11开始，String提供了isBlank()，strip(), stripLeading(), stripTrailing()等方法。
>
> isBlank(); 判断是否为空，空格字符串也返回true。 isEmpty()不能判断空格字符串。
>
> trip(); 去掉前后的半角、全角空白。strim()方法只能去掉半角空白。
>
> stripLeading();去掉左边的空白。
>
> stripTrailing();去掉右边的空白。

#### 2.4  FileInputStream的增强

> jdk11提供了一个关于FileInputStream文件快速复制的方法transferTo()。

#### 2.5 针对集合功能的增强

> 集合提供了快速复制的方法copy()等。

#### 2.6 对于JDK11出现的新GC(ZGC)

> Java 11新增了一个全新的垃圾收集器--ZGC，它由Oracle开发，宣传可以在数TB的堆上具有非常低的暂停时间。
>
> 其实在Java10中已经有四种发布多年的垃圾收集器，并且几乎都是无限可调的，那又为什么会新增一个GC呢？换个角度看，G1是2006年时引入Hotspot VM的。当时最大的AWS实例有1 vCPU和1.7GB内存，而今天AWS很乐意租给你一个x1e.32xlarge实例，该类型实例有128个vCPU和3,904GB内存。
>
> ZGC的设计目标是：支持TB级内存容量，暂停时间低（<10ms），对整个程序吞吐量的影响小于15%。将来还可以扩展实现机制，以支持不少令人兴奋的功能，例如多层堆（即热对象置于DRAM和冷对象置于NVMe闪存），或压缩堆。
>
> zgc在进行对象转移的过程中，只需要修改对象指针的几个标志位，相当于g1需要在对象转移时读取对象头来说，少了内存读取的操作，速度更快。不过也正是由于zgc使用了对象指针的几个标志位来完成并发标识和并发转移等的工作，所以zgc不能压缩指针，并且只能运行在基于64位的操作系统上。

### 3、JDK14

#### 3.1 swith新特性

> Switch的新特性，早在JDK 12就以预览功能被引入了，最终在JDK 14成为了正式版本的功能。
>
> 其实Switch新增的特性有两个，一个就是允许每个case包含多个常量，一个就是switch-case块可以有返回值。
>
> switch语句变成了switch表达式。并且提供支持箭头操作。

示例演示1： case包含多个变量

```java
 //JDK14之前:
        int month=5;
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("31天");
                break;
            case 2:
                System.out.println("28天");
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("30天");
        }
```

```java
//JDK14之后，使用逗号隔开每个常量。
//可以把冒号优化为箭头符号，且可省略break关键字；如果有多个条语句需要加大括号。
        int month=5;
        switch (month){
            case 1,3,5,7,8,10,12->
                System.out.println("31天");
            case 2 ->
                System.out.println("28天");
            case 4,6,9,11->
                System.out.println("30天");
        }
```

示例演示2： switch-case块可以有返回值

```java
//JDK14之前:
        int month=5;
        int day;
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                day=31;
                break;
            case 2:
                day=28;
            case 4:
            case 6:
            case 9:
            case 11:
                day=30;
            default:
                day=0;
        }
        System.out.println(day);
```

```java
//JDK14之后
	int month = 5;
        int day = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 2 -> 28;
            case 4, 6, 9, 11 -> 30;
            default -> 0;
        };
        System.out.println(day);

```

```java
//如果有多条语句，可以使用大括号包括，并且使用yield关键字返回
//JDK14之后
        int month = 5;
        int day = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> {
                System.out.println("~~~31天~~~");
                yield 31;
            }
            case 2 -> {
                System.out.println("~~~28天~~~");
                yield 28;
            }
            case 4, 6, 9, 11 -> {
                System.out.println("~~~30天~~~");
                yield 30;
            }
            default -> 0;
        };
        System.out.println(day);
```



### 4、JDK15、16、17

> JDK 17 于2021年09月14发布，有史以来最快的Java,JDK17号称有史以来最快的Java，Java创始人高斯林推荐升级。Oracle 宣布，从 JDK 17 开始，后面的 JDK 都全部免费提供。

#### 4.1 文本块

> 文本块是JDK15添加的新语法，可以用来表示任何字符串，具有更高的表达能力和更少的复杂度。文本块的开头定界符是由三个双引号字符(""")组成的序列独占一行，之后可以包含多行内容，最后跟一个结束定界符三个双引号字符。

```
		//一行编写
        String s1="line1 \nline2 \nline3\n";
        System.out.println(s1);
        //多行编写
        String s2="line1 \n" +
                "line2 \n" +
                "line3 \n";
        System.out.println(s2);
        //文本块
        String s3= """
                line1
                line2
                line3
                """;
        System.out.println(s3);
```



#### 4.2  instanceof模式匹配

> 在JDK16版本中，instanceof运算符具有模式匹配的能力。
>
> 模式匹配能够使程序的通用逻辑更加简洁，代码更加简单，同时在做类型判断和类型转换的时候也更加安全

```
//JDK16之前
        Object obj="helloworld";
        if(obj instanceof String){
            String str= (String) obj;
            System.out.println(str.toString());
        }else{
            //...
        }
//JDK16之后
        if(obj instanceof String str){
            System.out.println(str);
        }else{
            //...
        }
```

#### 4.2 密封类

> 密封类（Sealed Classes）是JDK15引入的，在JDK17正式转正。密封类可以对继承或者实现他们的类进行限制。
>
> 优点：使用密封类可以限制继承该类的子类的范围，从而更加精确地控制类的继承关系，增加程序的安全性和可维护性。

> 例如：
> Person类被 sealed 修饰，只允许（permits）Male和Female类继承，继承的类必须有 final 或者 no-sealed 来修饰。
> Function接口被 sealed 修饰，只允许（permits）Male和Female类实现，实现的类必须有 final 或者 no-sealed

```java
public static void main(String[] args) {
    Male male = new Male();
    male.eat();

    Female female = new Female();
    female.eat();
}

static sealed class Person permits Male, Female {
}

static final class Male extends Person implements Function {
    @Override
    public void eat() {
        System.out.println("eat 1");
    }
}

static non-sealed class Female extends Person implements Function {
    @Override
    public void eat() {
        System.out.println("eat 2");
    }
}

sealed interface Function permits Male, Female {
    void eat();
}
```

