package qf.task.week02;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02
 * @company lpc
 * date 2023/7/25 7:59
 */
public class day02_Test {


    private static void swap(int i, int j) {
        i = i ^ j;
        j = i ^ j;
        i = i ^ j;
    }
    private static void score(int grade){
        if(grade >= 90){
            System.out.println("优秀");
        }
        if(grade >= 80 && grade < 90){
            System.out.println("良好");
        }
        if(grade >= 70 && grade < 80){
            System.out.println("一般");
        }
    }

    private static void demo01(int...arr){
        for(int n :arr){
            System.out.println("arr = " + n);
        }
    }

    private static void demo02(int [] nums){
        //冒泡排序
        for (int j = 0; j < nums.length - 1; j++) {
            boolean flag = false;
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

    private static void demo03(int [] nums){
        //低效选择排序
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i; j < nums.length; j++) {
                if(nums[i] > nums[j]){
                   nums[i] = nums[i] ^ nums[j];
                   nums[j] = nums[i] ^ nums[j];
                   nums[i] = nums[i] ^ nums[j];
                }
            }
        }
        for (int n : nums){
            System.out.println(n+"\t");
        }
    }

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

    private static void demo05(int [] nums) {
        //插入排序低效
        // 开始时间
        long stime = System.currentTimeMillis();
        for (int i = 1; i < nums.length; i++) {
            for (int j = i-1; j >=0 ; j--) {
                if(nums[j] > nums[i]){
                    nums[j] = nums[j] ^ nums[i];
                    nums[j+1] = nums[j] ^ nums[i];
                    nums[j] = nums[j] ^ nums[i];
                }
            }
        }
        // 结束时间
        long etime = System.currentTimeMillis();
        // 计算执行时间
        System.out.printf("执行时长：%d 毫秒.", (etime - stime));


        for(int n : nums) System.out.println(n + "\t");
    }

    private static void demo06(int [] nums) {
        //插入排序高效
        // 开始时间
        long stime = System.currentTimeMillis();

        for (int i = 1; i < nums.length; i++) {
            int t = nums[i];
            int pos = i - 1;
            while (pos >= 0 && nums[pos] > t) {
                nums[pos + 1] = nums[pos];
                pos--;
            }
            nums[pos + 1] = t;
        }

        long etime = System.currentTimeMillis();
        System.out.printf("执行时长：%d 毫秒.", (etime - stime));
        for(int n : nums) System.out.print(n + "\t");
    }

    private static void demo07(int[] nums) {
        //希尔排序
        long stime = System.currentTimeMillis();

        for (int gap = nums.length >> 1; gap >= 1; gap >>= 1) {
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
        long etime = System.currentTimeMillis();
        System.out.printf("执行时长：%d 毫秒.", (etime - stime));
        for (int n : nums) System.out.print(n + "\t");
    }

    private static int[] demo08(int [] nums, int left, int right){
        long stime = System.currentTimeMillis();

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

    private static int demo09(int [] nums,int key){
        int [] num = demo08(nums,0,nums.length - 1);
        for (int n : num) System.out.print(n + "\t");
        int low = 0;
        int high = num.length-1;
        int mid = low + high >> 1;
        while(low < high){
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

    public static void main(String[] args) {
        int [] nums = {12, 18, 14, 16, 20, 55, 23, 232, 67, 94, 123, 97, 1, 3};
        long stime = System.currentTimeMillis();
        //demo05(new int[]{12,17,22,6,14});
        //demo06(new int[]{12,18,14,16,20,55,23,232,67,94,123,97,1,3});
        //for (int n : demo08(nums,0,nums.length - 1)) System.out.print(n + "\t");
        System.out.println(demo09(nums,2));
        long etime = System.currentTimeMillis();
        System.out.printf("执行时长：%d 毫秒.", (etime - stime));
    }
}
