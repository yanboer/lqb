package com.yb.dp;

/**
 * 0-1 背包问题：给定 n 种物品和一个容量为 C 的背包，物品 i 的重量是 wi，其价值为 vi 。
 * <p>
 * 问：应该如何选择装入背包的物品，使得装入背包中的物品的总价值最大？
 */

/**
 * 设有三个背包，其重量分别为：16,15, 15；价值分别为： 45，25，25；请选择背包，使其重量不超过30，但价值最大。
 */

public class BackQuestion {

    public static void main(String[] args) {

        int[] weight = {0, 16, 15, 15, 20};    //物品重量
        int[] value = {0, 45, 25, 25, 30};       //物品价值

        int capacity = 40;      //背包容量
        int result = bestSolution(weight, value, capacity, 4);//n：总物品个数
        System.out.println("最大价值为：" + result);

    }

    private static int bestSolution(int[] weight, int[] value, int capacity, int n) {

        int[][] m = new int[n + 1][capacity + 1];       //m[i][j] 表示在面对第 i 件物品，且剩余背包容量为 j 时所能获得的最大价值

        int result = soluve(weight, value, capacity, n, m);
        return result;

    }

    private static int soluve(int[] weight, int[] value, int capacity, int n, int[][] m) {

        int result = 0;     //最大价值
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (j >= weight[i]) {        //剩余容量大于第 i 个物品容量
                    m[i][j] = Math.max(m[i - 1][j], m[i - 1][j - weight[i]] + value[i]);
                    result = m[i][j];
                }
                else {
                    m[i][j] = m[i - 1][j];
                    result = m[i][j];
                }
            }
        }
        return result;
    }
}




