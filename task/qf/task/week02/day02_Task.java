package qf.task.week02;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02
 * @company lpc
 * date 2023/7/25 16:57
 */
public class day02_Task {
    //7.
    private static int demo01(int [] nums) {
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        return sum/nums.length;
    }
    //8.
    private static int demo02(int [] nums,int key) {
        int low = 0;
        int high = nums.length-1;
        int mid = low + high >> 1;
        while(low <= high){
            if(nums[mid] < key){
                low = mid + 1;
            }else if(nums[mid] > key){
                high = mid - 1;
            }else {
                return mid;
            }
            mid = low + high >> 1;
        }
        return -1;
    }

    //9.
    private static void demo03(int [] nums){
        int min = nums[0], max =0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] >= max) max = nums[i];
            if(nums[i] <= min) min = nums[i];
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }

    //10.
    private static void demo04(int [] nums) {
        int [] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[nums.length - i - 1] = nums[i];
        }
        for (int n : res) System.out.println("\t " + n);
    }

    //11.冒泡排序
    private static void demo05(int [] nums){
        for (int i = 0; i < nums.length - 1; i++) {
            boolean flag = false;
            for (int j = i; j < nums.length - i - 1; j++) {
                if(nums[j] > nums[j + 1]){
                    flag = true;
                    nums[j] = nums[j] ^ nums[j + 1];
                    nums[j + 1] = nums[j] ^ nums[j + 1];
                    nums[j] = nums[j] ^ nums[j + 1];
                }
            }
            if(!flag) break;
        }
        for (int num : nums) {
            System.out.print("\t " + num);
        }
    }

    //12.快速排序
    private static int[] demo06(int [] nums, int left, int right){
        int i = left,j = right,povit = nums[i];
        while (i < j) {
            while(i < j){
                if(nums[j] <= povit){
                    nums[i++] = nums[j];
                    break;
                }else {
                    j--;
                }
            }
            while (i < j){
                if(nums[i] >= povit){
                    nums[j--] = nums[i];
                    break;
                }else {
                    i++;
                }
            }
        }
        nums[i] = povit;
        if(i + 1 < right) demo06(nums,left, i -1);
        if(i - 1 > left) demo06(nums, j + 1,right);
        return nums;
    }
    public static void main(String[] args) {
        int [] arr= {1,3,2,7,5};
//        System.out.println(demo01(arr));
//        System.out.println(demo02(arr,2));
//        demo03(arr);
//        demo04(arr);
//        demo05(arr);
       int [] res = demo06(arr,0,arr.length - 1);
        for (int n : res) {
            System.out.print("\t" + n);
        }
    }
}
