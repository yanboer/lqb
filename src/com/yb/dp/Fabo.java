package com.yb.dp;

import java.util.Scanner;

/**
 * 普通递归方法计算斐波那契数列
 */
public class Fabo {
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
        if (n < 2){
            return n;
        }
        else {
            return fabonacci(n - 1) + fabonacci(n - 2);
        }
    }
}
