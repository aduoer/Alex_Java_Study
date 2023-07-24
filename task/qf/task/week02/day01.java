package qf.task.week02;

import java.util.Scanner;

public class day01 {
    private static void demo1() {
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" +(i*j) + "\t");
            }
            System.out.println();

        }
    }

    private static void demo2() {
        int num = 0;
        int k = 1;
        for (int i = 1; i <= 101; i+=2) {
            num += i*k;
            k = -k;
        }
        System.out.println(num);
    }

    private static void demo3() {
        System.out.println(compare(100,1));
    }
    private  static int compare(int a,int b) {
        if(a>b){
            return a;
        }else if (a<b){
            return b;
        }else {
            return  0;
        }
    }

    private static void demo4(){
        System.out.println(sum(100));
    }
    private static int sum(int n){
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res += i;
        }
        return res;
    }

    private static void demo5(){
        System.out.println(isShu(7));
    }
    private static boolean isShu(int num){
        if(num == 1){
            return false;
        }
        for (int i = 2; i <= num >>1; i++) {
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }

    private static int demo6(int n){
      if(n == 1) return 1;
      return demo6(n-1)*n;
    }

    private static int demo7(int n){
        if(n == 1 || n == 2) return 1;
        if(n == 3) return 2;
        return demo7(n -1)+demo7(n - 2);
    }

    private static void demo8(){
        int [] nums = {10,11,12,13,14};
        int sum = 0;
        for(int n : nums){
            sum += n;
        }
        System.out.println(sum/nums.length);
    }
    private static int demo9( int[] nums,int n){
       for (int i = 0; i < nums.length;i++){
           if(nums[i] == n) return i;
       }
        return -1;
    }

    private static void demo10(){
        Scanner sc = new Scanner(System.in);
        String[] city = new String[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入城市名字：");
            city[i] = sc.next();
        }
        for (String n :city){
            System.out.println(n);
        }
    }
    private static void demo11(){
        int [] nums = {1,2,3,4,5,0,0,0,0,};
        int size = 5;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入位置");
        int pos = sc.nextInt();
        System.out.println("请输入元素");
        int n = sc.nextInt();
        if(pos >= 0&& pos <=size){
            for (int i = size - 1; i >= pos; i--) {
                nums[i +1] = nums[i];
            }
            nums[pos] = n;
            size++;
        }
        System.out.println(size);
        for(int num : nums){
            System.out.println(num);
        }
    }

    private static void demo12(){
        int [] nums = {1,2,3,4,5,6};
        int [] des = new int[nums.length*2];
        int a = 0;
        for ( int n : nums){
            des[a] = n;
            a++;
        }
        for (int m : des){
            System.out.println(m);
        }

    }
    private static void demo13(){
        int [] nums = {1,2,3,4,5,0,0,0,0};
        int size = 5;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入删除位置");
        int pos = sc.nextInt();
        if(pos >= 0&& pos < size){
            for (int i = pos; i < size - 1; i++) {
                nums[i] = nums[i + 1];
            }
        }
        nums[--size] = 0;
        System.out.println("------------删除后--------------");
        for(int num : nums){
            System.out.println(num);
        }
    }
    public static void main(String[] args) {
//       int [] nums = {10,11,12,13,14};
//       System.out.println(demo9(nums,11));
        demo13();
   }
}
