package com.yb.dp;

import java.util.Scanner;

/**
 * 使用 DP 的字底向上求解 fabonacii
 */
public class Demo02 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Scanner sc = new Scanner(System.in);


        System.out.print("请输入 n = ");
        int n = sc.nextInt();
        int result = fabonacci(n);
        System.out.println("f(" + n + ") = " + result);


        long endTime = System.currentTimeMillis();
        System.out.println("共费事：" + (endTime - startTime) + "ms");
    }

    private static int fabonacci(int n) {
        int[] arry = new int[n + 1];
        arry[0] = 0;
        arry[1] = 1 ;
        for (int i = 2; i <= n; i++) {
            arry[i] = arry[i - 1] + arry[i - 2];
        }
        return arry[n];
    }
}
