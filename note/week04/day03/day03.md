# ·day17

## 高级多线程

### 线程池

#### 现有问题

- 线程是宝贵的内存资源、单个线程约占1MB空间，过多分配易造成内存溢出
- 频繁的创建及销毁线程会增加虚拟机回收频率、资源开销，造成程序性能下降

#### 线程池

- 线程容器，可设定线程分配的数量上限
- 将预先创建的线程对象存入池中，并重用线程池中的线程对象
- 避免频繁的创建和销毁

#### 获取线程池

常用的线程池接口和类(所在包java.util.concurrent，简称JUC)：

Executor：线程池的顶级接口

- execute();

ExecutorService：线程池接口，可通过submit(Runnable task) 提交任务代码。

- submit()；//提交任务
- shutdown();//关闭线程池
- isTerminated();//判断线程池中的线程是否都结束了

Executors工厂类：通过此类可以获得一个线程池

- 通过newFixedThreadPool(int nThreads) 获取固定数量的线程池。参数：指定线程池中线程的数量
- 通过newCachedThreadPool() 获得动态数量的线程池，如不够则创建新的，无上限

#### 创建线程池

1. ##### 创建动态数量线程池

   ExecutorService es = Executors.*newCachedThreadPool*();

2. ##### 创建单个线程线程池

   ExecutorService es = Executors.*newSingleThreadExecutor*()

3. ##### 创建固定线程个数线程池

   ExecutorService es = Executors.*newFixedThreadPool*(4);

4. ##### 创建调度线程池，实现周期执行或者延迟执行 不能直接使用shutdown关闭

   ```java
   //ScheduledExecutorService se = Executors.newScheduledThreadPool(1);
   //es.scheduleAtFixedRate(执行任务，初始延迟时间，周期执行时间，时间单位);执行线程
   //se.scheduleWithFixedDelay(执行任务，初始延迟时间，周期执行时间，时间单位);执行线程
   //se.schedule(延迟执行任务，延迟的时间，时间单位)
   //          固定频率
   ScheduledExecutorService se = Executors.newScheduledThreadPool(1);
   se.scheduleAtFixedRate(new Runnable() {
       private int count = 0;
       @Override
       public void run() {
           System.out.println(new Date());
           count++;
           if(count == 20){
               se.shutdown();
           }
       }
   },0,1000, TimeUnit.MILLISECONDS);
   
   //        //固定延迟
   ScheduledExecutorService se = Executors.newScheduledThreadPool(1);
   se.scheduleWithFixedDelay(new Runnable() {
       private int count = 0;
       @Override
       public void run() {
           System.out.println(new Date());
           count++;
           if(count == 10){
               try {
                   Thread.sleep(5000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
       }
   },1000,1000, TimeUnit.MILLISECONDS);
   //         延迟执行
   ScheduledExecutorService se = Executors.newScheduledThreadPool(1);
   
   se.schedule(new Runnable() {
       private int count = 0;
       @Override
       public void run() {
           System.out.println(new Date());
           count++;
           if(count == 10){
               try {
                   Thread.sleep(5000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
           }
       }
   },2000, TimeUnit.MILLISECONDS);
   se.shutdown();
   ```

5. ##### 创建工作窃取线程池：采用工作窃取算法
   ```java
   //创建工作窃取线程池：采用工作窃取算法
   //工作窃取线程池中的每个线程都有自己的队列，属于双端队列
   //如果一个线程的任务执行完毕了，去别的线程的队列头中窃取一个来执行，提供执行效率
   //优点：可以充分利用多核cpu的优点，提供执行效率
   //工作窃取线程池中的线程属于守护线程
     ExecutorService es = Executors.newWorkStealingPool();
           Runnable ticket = new Runnable() {
               private int count = 10000;
               @Override
               public void run() {
                   while (true) {
                       synchronized (this) {
                           if (count < 1) break;
                           System.out.println(Thread.currentThread().
                                   getName() + "\t卖了" + count + "张票");
                           count--;
                       }
                   }
               }
           };
           for (int i = 0; i < 4; i++) {
               es.submit(ticket);
           }
           es.shutdown();
           while (!es.isTerminated());
           System.out.println("主线程执行完毕");
   ```

6. ThreadPoolExecutor类的参数

   1. corePoolSize：核心线程数

   2. maximumPoolSize：最大线程数

   3. keepAliveTime：非核心线程的存活时间

   4. timeunit：时间单位

   5. workQueue：工作队列：阻塞队列

   6. threadFactory：线程工厂

   7. handler：拒绝策略

      - AbortPolicy：中断，抛出异常（核心业务，使用最多）

      - DiscardPolicy：直接抛弃，不抛出异常（非核心业务）

      - DiscardOldestPolicy：把旧的抛弃，加入新的（喜新厌旧）

      - CallerRunsPolicy：线程池创建者执行
      - new RejectedExecutionHandler():自定义拒绝策略


​	使用顺序：核心线程->工作队列->非核心线程，线程数量大于线程池容量，走拒绝策略

```java
  ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                2,
                3,
                60,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(1),
                Executors.defaultThreadFactory(),
                //new ThreadPoolExecutor.AbortPolicy()//抛出异常
                //new ThreadPoolExecutor.CallerRunsPolicy()//交给创建线程的创建者
                //new ThreadPoolExecutor.DiscardPolicy()//直接抛弃
                //new ThreadPoolExecutor.DiscardOldestPolicy()//删除旧的，加入新的
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        System.out.println("加的太多啦");
                    }
                }
        );
        Runnable ticket = new Runnable() {
            private int count = 10000;
            @Override
            public void run() {
                while (true) {
                    synchronized (this) {
                        if (count < 1) break;
                        System.out.println(Thread.currentThread().
                                getName() + "\t卖了" + count + "张票");
                        count--;
                    }
                }
            }
        };
        try {
            for (int i = 0; i < 5; i++) {
                threadPoolExecutor.submit(ticket);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        threadPoolExecutor.shutdown();
```

### callable接口

public interface Callable<V>{

​	public V call() throws Exception;

}

JDK1.5加入，与Runnable接口类似，实现之后代表一个线程任务。

Callable具有泛型返回值、可以声明异常

### Future接口

- Future: 代表任务将要执行完毕的结果
- 概念：异步接收ExecutorService.submit()所返回的状态结果，当中包含了call()的返回值
- 方法：V get()以阻塞形式等待Future中的异步处理结果（call()的返回值）

```java
 public static void main(String[] args) {
        Callable<Integer> call = new Callable<Integer>() {
            int sum = 0;
            @Override
            public Integer call() throws Exception {
                for (int i = 1; i <= 100; i++) {
                    sum += i;
                }
                return sum;
            }
        };
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer> future = es.submit(call);
        try {
            System.out.println(future.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        es.shutdown();
    }
```

### Lock接口

JDK5加入，与synchronized比较，显示定义，结构更灵活

提供更多实用性方法，功能更强大、性能更优越

常用方法:

- void lock() //获取锁，如锁被占用，则等待
- boolean tryLock() //尝试获取锁（成功返回true。失败返回false，不阻塞）
- void unlock() //释放锁

### ReadWriteLock读写锁

一种支持一写多读的同步锁，读写分离，可分别分配读锁、写锁

支持多次分配读锁，使多个读操作可以并发执行

互斥规则

- 写-写：互斥，阻塞
- 读-写：互斥，读阻塞写、写阻塞读
- 读-读：不互斥、不阻塞

- 在读操作远远高于写操作的环境中，可在保障线程安全的情况下，提高运行效率

```java
package qf.week04.day03;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.week04.day03
 * @company lpc
 * date 2023/8/9 16:17
 */
public class TestReadWriteLock {
    public static void main(String[] args) {
        ReadWrite rd = new ReadWrite();
        ExecutorService es = Executors.newFixedThreadPool(20);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 2; i++) {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    rd.setValue(new Random().nextInt(1,10));
                }
            });
        }
        for (int i = 0; i < 18; i++) {
            es.submit(new Runnable() {
                @Override
                public void run() {
                    rd.getValue();
                }
            });
        }
        es.shutdown();
        while (!es.isTerminated());
        long end = System.currentTimeMillis();
        System.out.println("用时：" + (end - start));
    }
    static class ReadWrite{
        private int value;
        //private ReadWriteLock readWrite = new ReentrantReadWriteLock();
        private Lock lock = new ReentrantLock();
        public int getValue(){
            //readWrite.readLock().lock();
            lock.lock();
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"读取了"+value);
                return value;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                //readWrite.readLock().unlock();
                lock.unlock();
            }
        }
        public void setValue(int value){
            //readWrite.writeLock().lock();
            lock.lock();
            try {
                Thread.sleep(1000);
                this.value = value;
                System.out.println(Thread.currentThread().getName()+"写入了"+value);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                //readWrite.writeLock().unlock();
                lock.unlock();
            }
        }
    }
}
//Lock互斥锁 20123ms
//ReadWriteLock 3023ms
```

### Condition条件队列

- Condition接口也提供了类似Object的监视器方法，与Lock配合可以实现等待/通知模式

- Condition可以通俗的理解为条件队列。当一个线程在调用了await方法以后，直到线程等待的某个条件为真的时候才会被唤醒

  | **方法名**  | **描述**             |
  | ----------- | -------------------- |
  | await()     | 当前线程进入等待状态 |
  | signal()    | 随机唤醒一个等待线程 |
  | signalAll() | 唤醒所有等待线程     |

```java
package qf.week04.day03;

import qf.week04.day02.bread.Bread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.week04.day03
 * @company lpc
 * date 2023/8/9 16:57
 */
public class TestProduceConsume {
    public static void main(String[] args) {
        Container container = new Container();
        ExecutorService es = Executors.newFixedThreadPool(4, new ThreadFactory() {
            private int count;
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"hahah-" + count++);
            }
        });
        //生产
        es.submit(() -> {for (int i = 0; i < 30; i++)
                            container.input(new Bread(i,Thread.currentThread().getName()));});
        es.submit(() -> {for (int i = 0; i < 30; i++)
                            container.input(new Bread(i,Thread.currentThread().getName()));});
        //消费
        es.submit(() -> {for (int i = 0; i < 30; i++) container.output();});
        es.submit(() -> {for (int i = 0; i < 30; i++) container.output();});
        es.shutdown();

    }

    static class Container {
        private Bread[] breads = new Bread[6];
        private Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();
        private int size;

        public void input(Bread bread) {
            lock.lock();
            try {
                while (size >= breads.length) {
                    condition.await();
                }
                breads[size] = bread;
                size++;
                System.out.println(Thread.currentThread().getName()+"生产了"+bread.getBreadId());
                condition.signalAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }

        }
        public void output() {
            lock.lock();
            try {
                while (size <= 0) {
                    condition.await();
                }
                size--;
                System.out.println(Thread.currentThread().getName()+"消费了"+breads[size].getBreadId());
                breads[size] = null;
                condition.signalAll();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        }
    }

    static class Bread {
        private String breadName;
        private int breadId;

        public Bread() {
        }

        public Bread(int breadId,String breadName) {
            this.breadName = breadName;
            this.breadId = breadId;
        }

        public String getBreadName() {
            return breadName;
        }

        public void setBreadName(String breadName) {
            this.breadName = breadName;
        }

        public int getBreadId() {
            return breadId;
        }

        public void setBreadId(int breadId) {
            this.breadId = breadId;
        }

        @Override
        public String toString() {
            return "Bread{" +
                    "breadName='" + breadName + '\'' +
                    ", breadId=" + breadId +
                    '}';
        }
    }
}

```

### synchronized和Lock区别

| **类别** | **synchronized**                                             | **Lock**                                    |
| -------- | ------------------------------------------------------------ | ------------------------------------------- |
| 存在层次 | Java的关键字，在jvm层面上                                    | 是一个类或接口                              |
| 锁释放   | 1、获取锁的线程执行完同步代码，自动释放锁   2、线程执行发生异常，JVM让线程释会放锁 | 在finally中必须释放锁，不然容易造成线程死锁 |
| 锁的获取 | 假设A线程获得锁，B线程等待。  如果A线程阻塞，B线程会一直等待 | Lock可以尝试获得锁，线程可以不用一直等待。  |
| 锁状态   | 无法判断                                                     | 可以判断                                    |
| 锁类型   | 可重入、不可中断、非公平                                     | 可重入、可中断、可公平或非公平              |
| 性能     | 较低、少量同步                                               | 较高、大量同步                              |