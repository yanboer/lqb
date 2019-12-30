package com.yb.lqb.sevenlqb;

/**
 *
 * 凑算式 B DEF A + --- + ------- = 10 C GHI （如果显示有问题，可以参见【图1.jpg】）
 * 
 * 这个算式中A~I代表1~9的数字，不同的字母代表不同的数字。
 * 
 * 比如： 6+8/3+952/714 就是一种解法， 5+3/1+972/486 是另一种解法。
 * 
 * 这个算式一共有多少种解法？
 * 
 * 注意：你提交应该是个整数，不要填写任何多余的内容或说明性文字。
 */
public class Demo03 {
    public static void main(String[] args) {
        int sum = 0; // sum 为总解法的个数
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    for (int l = 0; l < 10; l++) {
                        for (int m = 0; m < 10; m++) {
                            for (int n = 0; n < 10; n++) {
                                for (int o = 0; o < 10; o++) {
                                    for (int p = 0; p < 10; p++) {
                                        for (int q = 0; q < 10; q++) {
                                            // 1、九个数字互相之间不能重复
                                            int[] kk = new int[10];
                                            kk[i]++;
                                            kk[j]++;
                                            kk[k]++;
                                            kk[l]++;
                                            kk[m]++;
                                            kk[n]++;
                                            kk[o]++;
                                            kk[p]++;
                                            kk[q]++;
                                            for (int r = 1; r <= 9; r++) {
                                                if (kk[r] != 1) {
                                                    break;
                                                }
                                                if ((i + (j * 1.0) / k
                                                        + ((l * 100 + m * 10 + n) * 1.0) / (o * 100 + p * 10 + q)) == 10
                                                        && r == 9) {
                                                    sum++;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println("总共有" + sum + "种解法。");
    }
}
