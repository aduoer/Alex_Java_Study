package qf.task.week02.day03;

import java.util.Arrays;

/**
 * @author 10431
 * @version v1.0
 * @porject qftask
 * @package qf.task.week02
 * @company lpc
 * date 2023/7/26 9:00
 */
public class day03_Test {
    private static int demo01(int [] nums,int left,int right) {
    Arrays.sort(nums);
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
    if(i + 1 < right) demo01(nums,left, i -1);
    if(i - 1 > left) demo01(nums, j + 1,right);
    return nums[nums.length - 1];
}
    private static int[] demo02(int [] nums) {
        int [] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[nums.length - i - 1] = nums[i];
        }
        return res;
    }

    private static void demo03(){
        int [][] triangle = new int [7][];
        for (int i = 0; i < triangle.length; i++) {
            triangle[i] = new int [i + 1];
            for (int j = 0; j < triangle[i].length; j++) {
                if(j == 0 || j == i) triangle[i][j] = 1;
                else triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }
        for (int i = 0; i < triangle.length; i++) {
            System.out.printf("%" + (triangle.length - i) * 2 + "s","");
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.printf("%-4d",triangle[i][j]);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
//        demo01();
        demo03();


    }

}
