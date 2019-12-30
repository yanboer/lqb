package com.yb.greedy;

import java.util.Scanner;

/**
 * 公司的会议室每天都会有许多会议，有时这些会议的计划时间会发生冲突，需要选择出一些会议。小刘的工作就是安排公司会议室的会议，
 * 每个时间最多安排一个会议。现在小刘有一些会议计划的时间表，他想尽可能的安排更多的会议，请问他该如何安排。
 *
 * 输入
 * 第一行输入一个整数n(1<n<10000)表示该测试数据共有n个活动。
 * 随后的n行，每行有两个正整数Bi,Ei(0<=Bi,Ei<10000),分别表示第i个活动的起始与结束时间（Bi<=Ei)
 * 输出
 * 输出最多能够安排的会议数量，以及哪些会议被安排。
 * 样例输入
 * 3
 * 1 10
 * 10 11
 * 11 20
 * 样例输出
 * 最多能够安排的会议数量：2
 * 安排的会议分别为：
 * 第1个会议.第3个会议.
 */

/**
 * 最优策略即：
 *      能在最短的时间内安排足够多的会议室，即会议结束时间应较早
 */
public class Metting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        System.out.print("n = ");
        int n = sc.nextInt();

        int[][] metting = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            String s = sc2.nextLine();
            String[] s1 = s.split(" ");
            metting[i][1] = Integer.parseInt(s1[0]);
            metting[i][2] = Integer.parseInt(s1[1]);
        }
    }

    private static void sort(int[] mettingEnd) {
        for (int i = 1; i < mettingEnd.length; i++) {
            for (int j = i + 1; j < mettingEnd.length; j++) {
                if (mettingEnd[i] > mettingEnd[j]){
                    int temp = mettingEnd[i];
                    mettingEnd[i] = mettingEnd[j];
                    mettingEnd[j] = temp;
                }
            }
        }
    }
}
