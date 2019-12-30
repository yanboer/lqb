package com.yb.dp;

import java.util.Scanner;

/**
 * 钢条切割：
 * 长度：1    2   3   4   5   6   7   8   9   10
 * 价格：1    5   8   9   10  17  17  20  24  30
 * <p>
 * 给定长度为 n 的钢条，和价格表，求钢条切割方案使得收益最大！(若 n 时收益最大，则不切割就可以了！)
 */

/**
 * 自顶向下的备忘录法
 */
public class Bar_Cutting {

    public static void main(String[] args) {
        int[] price = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};      //切成每段时的钢条收益

        Scanner sc = new Scanner(System.in);
        System.out.print("钢条长度 n = ");
        int n = sc.nextInt();
        int result = partition(n, price);      //返回一个最大收益的结果

        System.out.println("钢条长度为 " + n + "时的最大收益为：" + result);

    }

    /**
     * @param n 钢条长度 n
     * @param p 长度为 n 时的收益为 p
     * @return 返回值为最大收益为多少
     */
    private static int partition(int n, int[] p) {
        //创建备忘录，即 income[n] 表示钢条长度为 n 时的最大收益的数组
        int[] income = new int[n + 1];
        int result = caculate_Money(n, p, income);        //返回最大收益
        return result;

    }

    /**
     * 表示钢条长度为 n 时的最佳收益。
     *
     * @param n      钢条长度
     * @param p      对应的钢条价格
     * @param income 最大列表收益
     * @return
     */
    private static int caculate_Money(int n, int[] p, int[] income) {
        int result = 0;
        if (income[n] != 0) {
            result = income[n];
        } else {
            if (n == 0) {
                income[0] = 0;
            }
            for (int i = 1; i <= n; i++) {
                // 最大收益 = 上次的最大收益 || 钢条长为 i 时的价格 + 剩下的 (n - i) 长度钢条的最佳切割方案
                income[n] = Math.max(income[n], p[i] + caculate_Money(n - i, p, income));
                result = income[n];
            }
        }
        return result;
    }
}
