package com.yb.test;

import java.util.Scanner;

public class Summation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //注意，1 < n < 1000000000,所以结果需要拿 long 来保存。
        long result = 0;

        for (int i = 1; i <= n ; i++) {
            result += i;
        }
        System.out.println(result);
    }
}
