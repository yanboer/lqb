package com.yb.lqb.sevenlqb;

/**
 * 凑算式 B DEF A + --- + ------- = 10 C GHI （如果显示有问题，可以参见【图1.jpg】）
 * <p>
 * 这个算式中A~I代表1~9的数字，不同的字母代表不同的数字。
 * <p>
 * 比如： 6+8/3+952/714 就是一种解法， 5+3/1+972/486 是另一种解法。
 * <p>
 * 这个算式一共有多少种解法？
 * <p>
 * 注意：你提交应该是个整数，不要填写任何多余的内容或说明性文字。
 */
public class Demo03_dfs {
    static int[] num = new int[10]; // 存储九个数字
    static boolean[] used = new boolean[10]; // 判断该元素是否被访问过
    static int sum = 0; // 记录解的个数

    public static void dfs(int n) {
        if (n == 10) {
            if (CheckNumber() == true) {
                sum++;
            }
        }
        for (int i = 1; i <= 9; i++) {
            if (used[i] == false) { // 未访问过
                used[i] = true; // 标记为访问过
                num[n] = i;
                dfs(n + 1);
                used[i] = false; // 回溯
            }
        }

    }

    public static boolean CheckNumber() {

        double a = num[1];
        double b = num[2] * 1.0 / num[3];
        double c = ((num[4] * 100 + num[5] * 10 + num[6] * 1) * 1.0) / (num[7] * 100 + num[8] * 10 + num[9] * 1);
        if (a + b + c == 10) {
            return true;
        } else
            return false;
    }

    public static void main(String[] args) {
        dfs(1);
        System.out.println("总共有" + sum + "种解");
    }
}