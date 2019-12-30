package com.yb.lqb.sixlqb;

/**
 * 牌型种数
 *
 * 小明被劫持到X赌城，被迫与其他3人玩牌。
 * 一副扑克牌（去掉大小王牌，共52张），均匀发给4个人，每个人13张。
 * 这时，小明脑子里突然冒出一个问题：
 * 如果不考虑花色，只考虑点数，也不考虑自己得到的牌的先后顺序，自己手里能拿到的初始牌型组合一共有多少种呢？
 *
 * 请填写该整数，不要填写任何多余的内容或说明文字。
 */

/**
 *  dfs 深度遍历所有情况
 *      一张牌可以重复 4 次。
 */
public class Demo07 {
    static int[] target = new int[13];        //代表十三张牌选择情况

    static int sum = 0;     //总共的可能数

    public static void main(String[] args) {
        dfs(0);
        System.out.println("初始牌型组合一共有:" + sum + "种");
    }

    private static void dfs(int n) {
        if (n == 13){       //从 A~K 中选择 0~4 个
            int count = 0;      //记录一共选了多少张牌
            for (int temp:target) {
                count += temp;
            }
            if (count == 13){
                sum++;
            }
        }
        else {
            for (int i = 0; i < 5; i++) {       //第 i 个牌的选中个数
                target[n] = i;      //选中一个牌 n 张
                dfs(n + 1);      //继续递归
                target[n] = 0;      //回溯
            }
        }
    }

}
