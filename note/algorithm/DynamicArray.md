# 动态数组

## 代码实现

```java
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

/**
 * @author 10431
 * @version v1.0
 * @porject algorithm
 * @package PACKAGE_NAME
 * @company lpc
 * date 2023/7/26 19:31
 */
public class DynamicArray implements Iterable<Integer>{
    private int size = 0;//逻辑大小
    private int capacity = 10;//容量
    private int[] array = {};

    public  void addLast(int element){
        add(size,element);
    }

    public void add(int index,int element){

        checkAndGrow();
        //添加逻辑
        if(index >= 0 && index < size){
            //array数组的index开始，向array数组拷贝，拷贝到index+1，拷贝size-element个元素
            System.arraycopy(array,index,
                    array,index + 1,size - index);
        }
        array[index] = element;
        size++;
    }
    //扩容
    private void checkAndGrow() {
        if(size == 0) array = new int[capacity];
        //容量检查
        else if (size == capacity) {
            //进行扩容，java中扩容1.5倍、1.618、2
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array,0,
                    newArray,0,size);
            array = newArray;
        }
    }

    //删除
    public int remove(int index){
        if(index >= 0 && index < size){
            int removed =  array[index];
            if(index < size - 1){
                System.arraycopy(array,index + 1,
                        array,index,size - index - 1);
            }
            size--;
            return removed;
        }
        return -1;
    }
    //查询元素
    public int get(int index){
        if(index >= 0 && index <= size - 1){
            return array[index];
        }
        return -1;
    }

    public void foreach(Consumer<Integer> consumer){
        for (int i = 0; i < size; i++) {
            //提供array[i]
            //返回void
            consumer.accept(array[i]);
        }
    }

    //迭代器遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int pos = 0;
            @Override
            public boolean hasNext() {//有没有下一个元素
                return pos < size;
            }

            @Override
            public Integer next() {//返回当前元素，并移向下一个元素
                return array[pos++];
            }
        };
    }

    //以流的形式遍历
    public IntStream stream(){
        return IntStream.of(Arrays.copyOfRange(array,0,size));
    }

}

```

## 时间复杂度分析

 * ### 查询

   * 根据索引去数组查询，时间复杂度O(1)
   * 根据值去数组查询，时间复杂度O(n)

 * ### 插入或删除

   * 头部插入，时间复杂度O(n)
   * 中间插入，时间复杂度O(n)
   * 尾部插入，时间复杂度O(1)

## 新知识

1. #### 新的数组copy方式

   从array数组的index开始，向array数组拷贝，拷贝到index+1，拷贝size-element个元素

   ```java
   System.arraycopy(原数组,开始下标(从这开始),目标数组,目标数组下标(从这开始),拷贝个数);
   System.arraycopy(array,index,array,index + 1,size - index);
   ```

2. #### 迭代器遍历

   需要继承Iterator<包装类型>

   ```java
   	 @Override
       public Iterator<Integer> iterator() {
           return new Iterator<Integer>() {
               int pos = 0;
               @Override
               public boolean hasNext() {//有没有下一个元素
                   return pos < size;
               }
          @Override
           public Integer next() {//返回当前元素，并移向下一个元素
               return array[pos++];
           }
       };
   }
   ```

3. ####  以流的形式遍历   

   - IntStream.of()方法，传递元素

   - 用dynamicArray.stream().forEach(变量名 ->{

   ​	对变量的操作，比如打印

   })

   ```java
   public IntStream stream(){
           return IntStream.of(Arrays.copyOfRange(array,0,size));
       }
   //打印
   dynamicArray.stream().forEach(element -> {
               System.out.print(element + "\t");
    });
   ```

4. #### 函数式接口

   - 如何选择函数式接口？

     根据方法返回值和方法参数进行判断

   ```java
   //实现了打印array[i]
   public void foreach(Consumer<Integer> consumer){
           for (int i = 0; i < size; i++) {
               //提供array[i]
               //返回void
               consumer.accept(array[i]);
           }
       }
   ```

   

5. #### 使用单元测试@Test和断言

​	导包使用

```java
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

int removed = dynamicArray.remove(2);
//判断结果值是否与目标值3相等
Assert.assertEquals(3, removed);
```

