第一部分 Java基础（27）

1. 程序本质：代码是如何被执行的？CPU、操作系统、虚拟机各司何职？

2. 基础语法：从CPU角度看变量、数组、类型、运算、跳转、函数等语法3

3. 引用类型：同样都是存储地址，为何Java引用比C/C++指针更安全？

4. 基本类型：既然Java一切皆对象，那又为何要保留int等基本类型？

5. 位运算：>>>和>>有何区别？(原码/反码/补码、算术位移/逻辑位移）

6. 浮点数：计算机如何用二进制表示浮点数？为何0.1+0.1不等于0.2？

7. 字符：为何C/C++中[char](https://www.zhihu.com/search?q=char&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A3050766801})占1个字节，而Java中char占2个字节?

8. 字符串：请解释String类用到的三大技术：压缩、常量池、不可变

9. 对象：请描述一下Java对象的内存结构，以及如何统计对象大小？ 

10. 关键字：[静态内部类](https://www.zhihu.com/search?q=静态内部类&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A3050766801})实现的单例如何做到线程安全且可延迟加载?

11. 容器：为什么不推荐在项目中使用Vector、Stack、HashTable？

12. 容器工具类：TimSort和DualPivotQuickSort的实现原理和区别

13. HashMap(上)：为何HashMap中数组的大小必须是2的幂次方？

14. HashMap(下)：为何链表树化的阈值为8，默认装载因子是0.75？

15. LinkedHashMap：如何使用LinkedHashMap实现LRU缓存？

16. 迭代器：为什么使用迭代器遍历容器的同时修改容器会出错？

17. 异常（上）：在项目开发中如何正确的定义、处理、打印异常?

18. 异常（下）：高并发下异常太多导致程序变慢的核心原因是什么？

19. io类库：[http://java.io](https://link.zhihu.com/?target=http%3A//java.io)类库如此庞大，怎么才能全面系统的掌握它？

20. [nio](https://www.zhihu.com/search?q=nio&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A3050766801})类库：BIO、NIO、AIO三种Java I/O模型的实现原理和区别

21. 高速I/O（上）：普通的I/O读写流程都存在哪些性能问题？

22. 高速I/O（下）：[mmap](https://www.zhihu.com/search?q=mmap&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A3050766801})和零拷贝是如何提高I/O读写速度的？

23. 泛型：为什么C++泛型支持int等基本类型而Java泛型不支持呢？

24. 反射：为什么通过反射创建对象要比使用new创建对象慢？

25. 注解：注解的配置方式相对于XML配置文件有什么优缺点？ 

26. [动态代理](https://www.zhihu.com/search?q=动态代理&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A3050766801})：为什么基于JDK实现的动态代理要求原始类有接口？ 

27. [函数式编程](https://www.zhihu.com/search?q=函数式编程&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A3050766801})：函数接口、Lambda表达式、方法引用、Stream流

    第二部分 多线程

28. 线程概述：有了进程为什么还要有线程？线程越多执行就越快吗？

29. 线程模型：[线程模型](https://www.zhihu.com/search?q=线程模型&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A3050766801})有哪几种？Java线程是基于哪种模型实现的？

30. JMM（上）：CPU缓存和指令重排给多线程编程带来哪些问题？ 

31. JMM（中）：如何解决多线程中的可见性、原子性、有序性问题？ 

32. JMM（下）：既然CPU支持缓存一致性协议，为何还有可见性问题？ 

33. [线程安全](https://www.zhihu.com/search?q=线程安全&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A3050766801})、临界区、竞态：如何分析一段代码是否线程安全？

34. synchronized（上）：线程释放锁之后，如何通知其他线程获取锁？ 

35. synchronized（下）：Java对synchronized进行了哪些性能优化？

36. Lock（上）：相比Java synchronized，JUC Lock有什么优势？

37. Lock（中）：如何使用AQS（抽象队列同步器）实现JUC Lock？

38. Lock（下）：ReadWriteLock的锁升级与锁降级及其底层实现原理?

39. 死锁、活锁、饥饿：如何实现Java多线程死锁检测和撤销？

40.  CAS：如何不使用锁实现AQS中的线程安全的等待队列？

41. 原子类：CAS的ABA问题是如何产生的以及如何解决？

42. 累加器：如何用数据分片、哈希优化、去伪共享等提高累加性能？

43. ThreadLocal：ThreadLocal相对于局部变量有何特殊应用场景？

44. 条件变量：为什么使用条件变量前需要先加锁？

45.  信号量：如何使用信号量来限制并发执行某个接口的线程数？

46. 锁存器和栅栏：如何编程测试接口在不同并发下的性能？

47. 并发容器：如何实现线程安全的数组、链表、[哈希表](https://www.zhihu.com/search?q=哈希表&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A3050766801})等常用数据结构？

48. 写时复制：为什么JUC只支持数组类型的写时复制并发容器？

49. 阻塞等待：如何实现支持阻塞读写的线程安全队列（阻塞并发队列）？

50. 分段加锁：HashMap线程不安全原因及ConcurrentHashMap实现原理

51. 线程状态：为何synchronized和Lock这两种锁对应的线程状态不同？

52. 线程中断：如何安全地提前终止正在执行业务逻辑的线程？

53. 线程池：线程池开多大最合适？为什么Redis单线程执行命令？

54. 线程执行框架：如何获取一个线程所执行的代码的运行结果？

    第三部分 JVM

55. 编译执行：Java代码的执行效率真的比C++等编译型语言低吗？

56. JIT编译：请解释下方法内联、逃逸分析等动态编译优化策略

57. 类加载：双亲委派加载机制存在的意义是什么？

58. 内存分区：JVM内存模型中有几个分区？都是做什么用的？

59. 可达性分析：虚拟机是如何判断一个对象是否可以被回收的？

60. [垃圾回收算法](https://www.zhihu.com/search?q=垃圾回收算法&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A3050766801})：同为垃圾回收，为何FullGC要比YoungGC慢很多？

61. 垃圾回收器（上）：如何在项目中选择合适的垃圾回收器？ 

62. 垃圾回收器（下）：CMS和G1的并发垃圾回收是如何实现的？ 

63. JVM性能优化：多久一次、一次多久FullGC和YoungGC才算正常？

64. JVM问题排查：使用jstat、jmap等工具排查OOM等JVM问题

## [MySQL 面试中常见的问题有哪些？](https://www.zhihu.com/question/484980489/answer/2694621710)

[![终端研发部](./img/v2-167f0162ce1e3020047be9ee6853033f_l.jpg)](https://www.zhihu.com/people/zhimengrensheng)

[终端研发部](https://www.zhihu.com/people/zhimengrensheng)

探索技术，追求本源，还分享职场，毕设，程序员内推和简历指导

185 人赞同了该回答

正好，前几天刚给公司招聘了一个Java后端开发的人员

### 小于哥：**ACID是什么?可以详细说一下吗?**

**候选人：**A=Atomicity：原子性，就是要么全部成功，要么全部失败。不可能只执行一部分操作。

**候选人：**C=Consistency：一致性，系统(数据库)总是从一个一致性的状态转移到另一个一致性的状态，不会存在中间状态。

**候选人：**I=Isolation：隔离性，通常来说：一个事务在完全提交之前，对其他事务是不可见的.注意前面的通常来说加了红色，意味着有例外情况。

**候选人：**D=Durability：持久性，一旦事务提交，那么就永远是这样子了，哪怕系统崩溃也不会影响到这个事务的结果。

## **小于哥：请说一下索引的区别：**

候选人：一个表只能有一个主键索引，但是可以有多个[唯一索引](https://www.zhihu.com/search?q=唯一索引&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A2694621710})。

- 主键索引一定是唯一索引，唯一索引不是主键索引。
- 主键可以与外键构成参照完整性约束，防止数据不一致。
- 联合索引：将多个列组合在一起创建索引，可以覆盖多个列。（也叫复合索引，组合索引）
- 外键索引：只有InnoDB类型的表才可以使用外键索引，保证数据的一致性、完整性、和实现级联操作（基本不用）。
- [全文索引](https://www.zhihu.com/search?q=全文索引&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A2694621710})：MySQL自带的全文索引只能用于MyISAM，并且只能对英文进行全文检索 （基本不用）

## **小于哥：一个B+树的节点中到底存多少个元素合适呢？**

**候选人：** 答案是：B+树中一个节点为一页或页的倍数最为合适。

候选人：因为如果一个节点的大小小于1页，那么读取这个节点的时候其实也会读出1页，造成资源的浪费；如果一个节点的大小大于1页，比如1.2页，那么读取这个节点的时候会读出2页，也会造成资源的浪费；所以为了不造成浪费，所以最后把一个节点的大小控制在1页、2页、3页、4页等倍数页大小最为合适。

## 小于哥：Mysql中B+树的一个节点大小为多大呢？

候选人：这个问题的答案是“1页”，这里说的“页”是Mysql自定义的单位（其实和操作系统类似），Mysql的Innodb引擎中一页的默认大小是16k（如果操作系统中一页大小是4k，那么Mysql中1页=操作系统中4页），可以使用命令**SHOW GLOBAL STATUS like 'Innodbpagesize';** 查看。

候选人：并且还可以告诉你的是，一个节点为1页就够了。

## 小于哥：**什么是最左前缀原则？**

候选人：MySQL中的索引可以以一定顺序引用多列，这种索引叫作联合索引。如User表的name和city加联合索引就是(name,city)，而最左前缀原则指的是，如果查询的时候查询条件精确匹配索引的左边连续一列或几列，则此列就可以被用到。如下：

```sql
select * from user where name=xx and city=xx ; ／／可以命中索引
select * from user where name=xx ; // 可以命中索引
select * from user where city=xx ; // 无法命中索引
```

候选人：这里需要注意的是，查询的时候如果两个条件都用上了，但是顺序不同，如 city= xx and name ＝xx，那么现在的查询引擎会自动优化为匹配联合索引的顺序，这样是能够命中索引的。

候选人：由于最左前缀原则，在创建联合索引时，索引字段的顺序需要考虑字段值去重之后的个数，较多的放前面。ORDER BY子句也遵循此规则。

## 小于哥：**数据库三大范式是什么**

候选人：第一范式：每个列都不可以再拆分。

候选人：第二范式：在第一范式的基础上，非主键列完全依赖于主键，而不能是依赖于主键的一部分。

候选人：[第三范式](https://www.zhihu.com/search?q=第三范式&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A2694621710})：在第二范式的基础上，非主键列只依赖于主键，不依赖于其他非主键。

在设计数据库结构的时候，要尽量遵守三范式，如果不遵守，必须有足够的理由。比如性能。事实上我们经常会为了性能而妥协数据库的设计。

## 小于哥：varchar和char的使用场景?

候选人：1.char的长度是不可变的，而varchar的长度是可变的。

定义一个char[10]和varchar[10]。

如果存进去的是‘csdn’,那么char所占的长度依然为10，除了字符‘csdn’外，后面跟六个空格，varchar就立马把长度变为4了，取数据的时候，char类型的要用trim()去掉多余的空格，而varchar是不需要的。

候选人：2.char的存取速度还是要比varchar要快得多，因为其长度固定，方便程序的存储与查找。

char也为此付出的是空间的代价，因为其长度固定，所以难免会有多余的空格占位符占据空间，可谓是以空间换取时间效率。

varchar是以空间效率为首位。

候选人：3.char的存储方式是：对英文字符（ASCII）占用1个字节，对一个汉字占用两个字节。
varchar的存储方式是：对每个英文字符占用2个字节，汉字也占用2个字节。

**候选人：4.两者的存储数据都非unicode的字符数据。**

## 小于哥：请说说**[乐观锁](https://www.zhihu.com/search?q=乐观锁&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A2694621710})与[悲观锁](https://www.zhihu.com/search?q=悲观锁&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A2694621710})的区别**

候选人：对于**悲观锁来讲**

候选人：总是假设最坏的情况，每次去拿数据的时候都认为别人会修改，所以每次在拿数据的时候都会上锁，这样别人想拿这个数据就会阻塞直到它拿到锁（共享资源每次只给一个线程使用，其它[线程阻塞](https://www.zhihu.com/search?q=线程阻塞&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A2694621710})，用完后再把资源转让给其它线程）。传统的[关系型数据库](https://www.zhihu.com/search?q=关系型数据库&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A2694621710})里边就用到了很多这种锁机制，比如行锁，表锁等，读锁，写锁等，都是在做操作之前先上锁。Java中synchronized和ReentrantLock等独占锁就是悲观锁思想的实现。

候选人：对于乐观锁来讲

候选人：总是假设最好的情况，每次去拿数据的时候都认为别人不会修改，所以不会上锁，但是在更新的时候会判断一下在此期间别人有没有去更新这个数据，可以使用版本号机制和CAS算法实现。乐观锁适用于多读的应用类型，这样可以提高吞吐量，像数据库提供的类似于write_condition机制，其实都是提供的乐观锁。在Java中java.util.concurrent.atomic包下面的原子变量类就是使用了乐观锁的一种实现方式CAS实现的。

### 小于哥：请说说**两种锁的使用场景？** 

候选人：从上面对两种锁的介绍，我们知道两种锁各有优缺点，不可认为一种好于另一种，像乐观锁适用于写比较少的情况下（多读场景），即冲突真的很少发生的时候，这样可以省去了锁的开销，加大了系统的整个吞吐量。但如果是多写的情况，一般会经常产生冲突，这就会导致上层应用会不断的进行retry，这样反倒是降低了性能，所以一般多写的场景下用悲观锁就比较合适。

## 小于哥：在项目开发的时候，**大表遇到数据量过大，怎么优化？**

候选人：当MySQL单表记录数过大时，数据库的CRUD性能会明显下降，一些常见的优化措施如下：

候选人：限定数据的范围： 务必禁止不带任何限制数据范围条件的查询语句。比如：我们当用户在查询订单历史的时候，我们可以控制在一个月的范围内。；

候选人：读/写分离： 经典的数据库拆分方案，主库负责写，从库负责读；

候选人：缓存： 使用MySQL的缓存，另外对重量级、更新少的数据可以考虑使用应用级别的缓存；

候选人：垂直分区：

候选人：根据数据库里面数据表的相关性进行拆分。 例如，用户表中既有用户的登录信息又有用户的基本信息，可以将用户表拆分成两个单独的表，甚至放到单独的库做分库。
简单来说垂直拆分是指数据表列的拆分，把一张列比较多的表拆分为多张表。 如下图所示，这样来说大家应该就更容易理解了。

![img](./img/v2-ffa0959f69642485802847473d357675_b.jpg)

img

候选人：水平分区：


保持数据表结构不变，通过某种策略存储数据分片。这样每一片数据分散到不同的表或者库中，达到了分布式的目的。水平拆分可以支撑非常大的数据量。


水平拆分是指数据表行的拆分，表的行数超过200万行时，就会变慢，这时可以把一张的表的数据拆成多张表来存放。举个例子：我们可以将用户信息表拆分成多个用户信息表，这样就可以避免单一表数据量过大对性能造成影响。

![img](./img/v2-80437809bc620163b69ca48e89c929e6_b.jpg)

数据库水平拆分

水品拆分可以支持非常大的数据量。需要注意的一点是:分表仅仅是解决了单一表数据过大的问题，但由于表的数据还是在同一台机器上，其实对于提升MySQL并发能力没有什么意义，所以 **水品拆分最好分库** 。

### 小于哥：请说说 乐观锁常见的两种实现方式

候选人：乐观锁一般会使用版本号机制或CAS算法实现。

### 小于哥：请说说**MyISAM存储引擎应用场景有哪些？**

候选人：MyISAM 是 MySQL 5.1 及之前的版本的默认的存储引擎。MyISAM 提供了大量的特性，包括全文索引、压缩、空间函数（GIS)等，但MyISAM 不「支持事务和行级锁」，对于只读数据，或者表比较小、可以容忍修复操作，依然可以使用它。

### 小于哥：请说说**MySQL存储引擎MyISAM与InnoDB区别**

候选人：存储引擎Storage engine：MySQL中的数据、索引以及其他对象是如何存储的，是一套文件系统的实现。

候选人：常用的存储引擎有以下：

- **Innodb引擎**：Innodb引擎提供了对数据库ACID事务的支持。并且还提供了行级锁和外键的约束。它的设计的目标就是处理大数据容量的数据库系统。
- **MyIASM引擎**(原本Mysql的默认引擎)：不提供事务的支持，也不支持行级锁和外键。
- **MEMORY引擎**：所有的数据都在内存中，数据的处理速度快，但是安全性不高。

## 小于哥：**int(20)中20的含义**

候选人：int(20)是指显示字符的长度，不影响内部存储，只是当定义了ZEROFILL时，前面补多少个 0

## 小于哥：**什么是触发器，MySQL中都有哪些触发器？**

触发器是指一段代码，当触发某个事件时，自动执行这些代码。在MySQL数据库中有如下六种触发器：

候选人：Before Insert

候选人：After Insert

候选人：Before Update

候选人：After Update

候选人：Before Delete

候选人：After Delete

### 小于哥：MySQL查询字段区不区分大小写？

候选人：答案是不区分

小于哥能做到区分吗？

候选人：不能吧

![img](./img/v2-2405b01103dfd3bb345a82ee8cf5cf18_b.jpg)



小于哥：**如何解决需要区分英文大小写的场景**

小于哥：**解决方案一**

MySQL默认的字符检索策略：`utf8_general_ci`，表示不区分大小写。

可以使用`utf8_general_cs`，表示区分大小写，也可以使用`utf8_bin`，表示二进制比较，同样也区分大小写 。

小于哥：直接修改[sql语句](https://www.zhihu.com/search?q=sql语句&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A2694621710})，在要查询的字段前面加上binary关键字

```text
 -- 在每一个条件前加上binary关键字
select * from user where binary username = 'admin' and binary password = 'admin';

-- 将参数以binary('')包围
select * fromuserwhere username likebinary('admin') andpasswordlikebinary('admin');
```

## 小于哥：**一个6亿的表a，一个3亿的表b，通过外键tid关联，你如何最快的查询出满足条件的第50000到第50200中的这200条数据记录。**

候选人：1、如果A表TID是自增长,并且是连续的,B表的ID为索引

```
select * from a,b where a.tid = b.id and a.tid>50000limit200;
```

候选人：2、如果A表的TID不是连续的,那么就需要使用[覆盖索引](https://www.zhihu.com/search?q=覆盖索引&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A2694621710}).TID要么是主键,要么是辅助索引,B表ID也需要有索引。

```
select * from b , (select tid from a limit50000,200) a where b.id = a .tid;
```

## 小于哥：H**ash索引和B+树所有有什么区别或者说优劣呢?**

候选人：首先要知道Hash索引和B+树索引的底层实现原理:

候选人：hash索引底层就是hash表,进行查找时,调用一次[hash函数](https://www.zhihu.com/search?q=hash函数&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A2694621710})就可以获取到相应的键值,之后进行回表查询获得实际数据.B+树底层实现是多路平衡查找树.对于每一次的查询都是从根节点出发,查找到叶子节点方可以获得所查键值,然后根据查询判断是否需要回表查询数据.

候选人：那么可以看出他们有以下的不同:

候选人：hash索引进行等值查询更快(一般情况下),但是却无法进行范围查询.

候选人：因为在hash索引中经过hash函数建立索引之后,索引的顺序与原顺序无法保持一致,不能支持范围查询.而B+树的的所有节点皆遵循(左节点小于父节点,右节点大于父节点,多叉树也类似),天然支持范围.

- hash索引不支持使用索引进行排序,原理同上.
- hash索引不支持模糊查询以及多列索引的最左前缀匹配.原理也是因为hash函数的不可预测.**AAAA**和**AAAAB**的索引没有相关性.
- hash索引任何时候都避免不了回表查询数据,而B+树在符合某些条件([聚簇索引](https://www.zhihu.com/search?q=聚簇索引&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A2694621710}),覆盖索引等)的时候可以只通过索引完成查询.
- hash索引虽然在等值查询上较快,但是不稳定.性能不可预测,当某个键值存在大量重复的时候,发生hash碰撞,此时效率可能极差.而B+树的查询效率比较稳定,对于所有的查询都是从根节点到叶子节点,且树的高度较低.

候选人：因此,在大多数情况下,直接选择B+树索引可以获得稳定且较好的查询速度.而不需要使用hash索引.

## 小于哥：**主键使用自增ID还是UUID?**

候选人：推荐使用自增ID,不要使用UUID.

候选人：因为在InnoDB存储引擎中,主键索引是作为聚簇索引存在的,也就是说,主键索引的B+树叶子节点上存储了主键索引以及全部的数据(按照顺序),如果主键索引是自增ID,那么只需要不断向后排列即可,如果是UUID,由于到来的ID与原来的大小不确定,会造成非常多的数据插入,数据移动,然后导致产生很多的内存碎片,进而造成插入性能的下降.

候选人：总之,在数据量大一些的情况下,用自增主键性能会好一些.

## 补充：**MySQL 有哪些数据类型？**

MySQL 数据类型非常丰富，常用类型简单介绍如下：

整数类型：BIT、BOOL、TINY INT、SMALL INT、MEDIUM INT、 INT、 BIG INT。

浮点数类型：FLOAT、DOUBLE、DECIMAL。

字符串类型：CHAR、VARCHAR、TINY TEXT、TEXT、MEDIUM TEXT、LONGTEXT、TINY BLOB、BLOB、MEDIUM BLOB、LONG BLOB。

日期类型：Date、DateTime、TimeStamp、Time、Year。

其他数据类型：BINARY、VARBINARY、ENUM、SET...

## 另外，这几个也是常见的面试题

- 创建索引时需要注意什么？
- [MySQL千万级别大表，你要如何优化？](https://zhuanlan.zhihu.com/p/518213477)
- 索引是什么？MySQL为什么使用B+树，而不是使用其他？B+树的特点
- CHAR和VARCHAR的区别？
- 各种索引的概念：索引，主键，唯一索引，联合索引，索引分类
- Myql中的事务回滚机制,持久性，[隔离级别](https://www.zhihu.com/search?q=隔离级别&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A2694621710})的实现
- 说一说drop、delete与truncate的区别
- 什么叫视图？游标是什么？
- 什么是存储过程？用什么来调用？
- MySql索引是如何实现的
- [聚集索引](https://www.zhihu.com/search?q=聚集索引&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A2694621710})与非聚集索引的区别
- NOW（）和CURRENT_DATE（）有什么区别？
- 事务四大特性（ACID）原子性、一致性、隔离性、持久性？
- 事务的并发？[事务隔离级别](https://www.zhihu.com/search?q=事务隔离级别&search_source=Entity&hybrid_search_source=Entity&hybrid_search_extra={"sourceType"%3A"answer"%2C"sourceId"%3A2694621710})，每个级别会引发什么问题，MySQL默认是哪个级别？
- MySQL常见的存储引擎InnoDB、MyISAM的区别？
- 数据库三范式，根据某个场景设计数据表？优缺点
- [Mysql中的order by 是到底该怎么优化？](https://zhuanlan.zhihu.com/p/460995716)
- MySQL 索引使用的注意事项
- [几千万数据，怎么快速查询？](https://zhuanlan.zhihu.com/p/498382688)
- 数据库悲观锁和乐观锁的原理和应用场景？
- 内连接、自连接、外连接（左、右、全）、交叉连接的区别

其实很多大概率不会问，平常用的的很少，很多没啥真的技术含量，就理论知识硬背，所以小于哥就给大家整理了一下~

一,顺序表
线性枚举 前缀和 双指针 二分枚举 三分枚举 离散化 冒泡排序 选择排序快速排序 插入排序希尔排序 归并排序 堆排序 基数排序 计数排序 模拟 贪心
二,链表
单向链表 双向链表
三,栈
LIFO栈（后进先出）单调栈 
四,队列
FLFO队列（先进先出） 双端队列 单调队列
五,字符串
KMP 字典树 马拉车 AC自动机 后缀数组 BM
六,树
二叉树 二叉搜索树 AVL树 线段树 霍夫曼树 堆 红黑树 伸展树 左偏树 Treap B+树 树链剖分 
七,图
二分图 最短路 最小生成树 最近公共祖先 深度优先搜索 强连通分量 双连通分量 2-sat 欧拉回路 
哈密尔顿回路 迭代加深 广度优先搜索 拓扑排序 A* 稳定婚姻 双向广搜 查分约束 并查集 哈希表 跳跃表 树状数组 最大流 
八,动态规划
递推 线性DP 记忆化搜索 背包问题 树形DP 区间DP 数位DP 状压DP 