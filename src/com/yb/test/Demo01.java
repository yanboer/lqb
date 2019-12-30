package com.yb.test;
/**
 * 问题描述
 * Fibonacci数列的递推公式为：Fn=Fn-1+Fn-2，其中F1=F2=1。
 * <p>
 * 当n比较大时，Fn也非常大，现在我们想知道，Fn除以10007的余数是多少。
 * <p>
 * 输入格式
 * 输入包含一个整数n。
 * 输出格式
 * 输出一行，包含一个整数，表示Fn除以10007的余数。
 * 说明：在本题中，答案是要求Fn除以10007的余数，因此我们只要能算出这个余数即可，而不需要先计算出Fn的准确值，再将计算的结果除以10007取余数，直接计算余数往往比先算出原数再取余简单。
 * <p>
 * 样例输入
 * 10
 * 样例输出
 * 55
 * 样例输入
 * 22
 * 样例输出
 * 7704
 * 数据规模与约定
 * 1 <= n <= 1,000,000。
 */

import java.util.Scanner;

public class Demo01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = quyu(n);
        System.out.println(result);
    }

    private static int quyu(int n) {
        //text[n] 记录 n 时的余数
        int[] text = new int[n + 1];

        int result = caul(n, text);
        return result;
    }

    private static int caul(int n, int[] text) {
        if (text[(int)n] != 0) {
            return text[n];
        } else {
            if (n == 1) {
                text[n] = 1 % 10007;
            }
            if (n == 2) {
                text[n] = 1 % 10007;
            }
            for (int i = 3; i <= n; i++) {
                text[n] = (caul(n - 1, text) + caul(n - 2, text)) % 10007;
            }
        }
        return text[n];
    }
}
