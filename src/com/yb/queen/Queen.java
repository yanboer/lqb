package com.yb.queen;

import java.util.Currency;

/**
 * 八皇后问题
 */
public class Queen {
    static int[] queeSite = new int[9];     //每行的 queen 位置
    static int sum = 0;    //记录总解数

    /**
     * 检查第 n 个皇后是否与之前的皇后有冲突
     * true: 冲突
     * fasle：不冲突
     *
     * @param n
     * @return
     */
    public static boolean checkQueen(int n) {
        for (int i = 0; i < n; i++) {
            if (queeSite[n] == queeSite[i] || (Math.abs(n - i) == Math.abs(queeSite[n] - queeSite[i]) && i != 0)) {
                return true;
            }
        }
        return false;
    }

    public static void dfs(int n) {
        if (n == 9) {
            sum++;
            for (int i = 1; i < 9; i++) {
                for (int j = 1; j < 9; j++) {
                    if (queeSite[i] == j) {
                        System.out.print("+ ");
                    } else System.out.print("- ");
                }
                System.out.println();
            }
            System.out.println("***********************************");
            return;
        } else {
            for (int i = 1; i < 9; i++) {
                queeSite[n] = i;        //在第n行第i个位置上放一个皇后
                if (!checkQueen(n)) {   //如果与之前放的不冲突
                    dfs(n + 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        dfs(1);
        System.out.println("八皇后总解数为：" + sum);
        long endTime = System.currentTimeMillis();
        System.out.println("总花费时间为：" + (endTime - startTime) + "ms");
    }
}
