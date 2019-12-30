package com.yb.dp;

import java.util.Scanner;

/**
 * 使用 DP 的自顶向下的备忘录法计算 fabonacci 数列
 */
public class Demo01{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long startTime = System.currentTimeMillis();


        System.out.print("请输入 n = ");
        int n = sc.nextInt();
        int result = fabonacci(n);
        System.out.println("f(" + n + ") = " + result);


        long endTime = System.currentTimeMillis();
        System.out.println("共费事：" + (endTime - startTime) + "ms");
    }

    private static int fabonacci(int n) {
        //创建备忘录
        int[] arry = new int[n + 1];
        //递归函数计算 f(n)
        int result = fabo(n,arry);
        return result;
    }

    private static int fabo(int n, int[] arry) {
        if (arry[n] != 0){      //如果 f(n) 备忘录不为空
            return arry[n];
        }
        else {      //如果 f(n) 备忘录为空
            if (n < 2){
                arry[n] = n;
            }
            else {
                arry[n] = fabo(n - 1,arry) + fabo(n - 2,arry);
            }
        }
        return arry[n];
    }
}