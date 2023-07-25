# day02

方法返回值：基本类型返回是数据，引用类型返回是地址

## 可变长参数

#### 语法：数组元素类型…数组名

#### 调用：直接传递数组元素、数组

#### 注意：只能定义一个，必须定义再方法参数列表的最后

## 数组排序

### 冒泡排序  O(n^2)

1. 一次比较两个相邻元素，如果它们的顺序错误就把它们交换过来。
2. 重复地进行直到没有再需要交换。
3. 这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
4. ```java
    private static void demo02(int [] nums){
           //冒泡排序
           for (int j = 0; j < nums.length - 1; j++) {
               boolean flag = false;
               //数组内挨个比较，交换位置
               for (int i = 0; i < nums.length - j - 1; i++) {
                   if(nums[i] > nums[i+1]){
                       flag = true;
                       int temp = nums[i];
                       nums[i]=nums[i +1];
                       nums[i +1]=temp;
                   }
               }
               if(!flag){
                   break;
               }
           }
   
           for (int n : nums) System.out.print(n + "\t");
   
       }
   ```

   

### 选择排序  O(n^2)

1. 首先在未排序数组中找到最小（大）元素，存放到排序数组的起始位置。
2. 然后再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾
3. 依次类推，直到交换完毕。
4. ```java
   private static void demo04(int [] nums){
           //选择排序
           for (int i = 0; i < nums.length - 1; i++) {
               int min = i;
               for (int j = i + 1; j < nums.length; j++) {
                   if(nums[min] > nums[j]){
                       min = j;
                   }
               }
               if(min != i){
                   nums[min] = nums[min] ^ nums[i];
                   nums[i] = nums[min] ^ nums[i];
                   nums[min] = nums[min] ^ nums[i];
               }
           }
           for (int n : nums){
               System.out.println(n+"\t");
           }
       }	
   ```

   

### 插入排序  O(n^2)

​	每一步都将一个待排数据按其大小插入到已经排序的数据中的适当位置，直到全部插入完毕

```java
 private static void demo06(int [] nums) {
        //插入排序高效
        for (int i = 1; i < nums.length; i++) {
            int t = nums[i];
            int pos = i - 1;
            while (pos >= 0 && nums[pos] > t) {
                nums[pos + 1] = nums[pos];
                pos--;
            }
            nums[pos + 1] = t;
        }
        for(int n : nums) System.out.print(n + "\t");
    }
```



### 希尔排序  O(n^1.3)

- 划分间隔，让每个间隔都进行插入排序

- 间隔大时，每一趟比较次数少，但数据项移动距离长，所以一次比较交换就可能消除掉多个元素交换

- 间隔小时，每一趟比较次数多，但此时已经接近于它们排序后的最终位置，当gap==1就得到最终结果

- ```java
   private static void demo07(int[] nums) {
          //希尔排序
  
          for (int gap = nums.length >> 1; gap >= 1; gap >>= 1) {
              //插入排序
              for (int i = gap; i < nums.length; i++) {
                  int t = nums[i];
                  int pos = i - gap;
                  while (pos >= 0 && nums[pos] > t) {
                      nums[pos + gap] = nums[pos];
                      pos -= gap;
                  }
                  nums[pos + gap] = t;
              }
          }
          for (int n : nums) System.out.print(n + "\t");
      }
  ```

  

### 快速排序  O(n log2n)

1. 通过一趟排序将要排序的数据分割成独立的两部分；

2. 其中一部分的所有数据都比另外一部分的所有数据都要小；

3. 然后再按此方法对这两部分数据分别进行快速排序，整个排序过程可以递归进行，以此达到整个数据变成有序序列。

4. ```java
   private static int[] demo08(int [] nums, int left, int right){
           int i = left;
           int j = right;
           int piovt = nums[i];
   
           while (i < j){
               //从后向前
               while (i < j){
                   if(nums[j] > piovt) j--;
                   else {
                       nums[i++] = nums[j];
                       break;
                   }
               }
               //从前往后
               while (i < j){
                   if(nums[i] < piovt) i++;
                   else {
                       nums[j--] = nums[i];
                       break;
                   }
               }
           }
           nums[i] = piovt;
   
           if(i - 1 > left) demo08(nums,left,i - 1);
           if(i + 1 < right) demo08(nums,j + 1,right);
           return nums;
       }
   ```

   

## 数组查找

#### 顺序查找

​	从头开始遍历查找

#### 二分查找

- 数组必须有序
- 每次从中间开始查找，直到找到为止

```Java
    private static int demo09(int [] nums,int key){
        //调用快速排序，给数组升序排列
        int [] num = demo08(nums,0,nums.length - 1);
        for (int n : num) System.out.print(n + "\t");
        //开始二分查找
        int low = 0;
        int high = num.length-1;
        int mid = low + high >> 1;
        while(low <= high){
            if(num[mid] < key){
                low = mid + 1;
            }else if(num[mid] > key){
                high = mid -1;
            }
            else {
                return mid;
            }
            mid = low + high >> 1;
        }
        return -1;
    }
```

