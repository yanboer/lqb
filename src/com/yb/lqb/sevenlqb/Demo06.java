package com.yb.lqb.sevenlqb;

/**
 * 方格填数
 *
 * 如下的10个格子
 *    +--+--+--+
 *    |  |  |  |
 * +--+--+--+--+
 * |  |  |  |  |
 * +--+--+--+--+
 * |  |  |  |
 * +--+--+--+
 *
 * （如果显示有问题，也可以参看【图1.jpg】）
 *
 * 填入0~9的数字。要求：连续的两个数字不能相邻。
 * （左右、上下、对角都算相邻）
 *
 * 一共有多少种可能的填数方案？
 *
 * 请填写表示方案数目的整数。
 * 注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
 */
public class Demo06 {

    static int left = 1; //左边相邻
    static int right = 2; //右边相邻
    static int top = 4; //上相邻
    static int bootom = 8; //下相邻

    static int sum =0; //总解数
    public static void main(String[] args) {

    }
}
