package com.yb.lqb.sevenlqb;

import java.util.ArrayList;
import java.util.List;

/**
 * 剪邮票
 * <p>
 * 如【图1.jpg】, 有12张连在一起的12生肖的邮票。
 * 现在你要从中剪下5张来，要求必须是连着的。
 * （仅仅连接一个角不算相连）
 * 比如，【图2.jpg】，【图3.jpg】中，粉红色所示部分就是合格的剪取。
 * <p>
 * 请你计算，一共有多少种不同的剪取方法。
 * <p>
 * 请填写表示方案数目的整数。
 * 注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
 */
public class Demo07 {
    static int[] target = new int[6];    //代表选中的九宫格的格子

    static boolean[] used = new boolean[13]; //代表每个格子是否被访问过

    static int[] B = new int[]{0, 1, 2, 3, 4, 6, 7, 8, 9, 11, 12, 13, 14};        //分别代表九宫格的标记

    static int[] statu = new int[]{0, 2, 3, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41};      //每个素数代表一个格子的状态

    static int sum = 0; //剪取方法数

    static int statuSum = 0;  //五个格子的状态和

    static List<Integer> staList = new ArrayList<>();

    /**
     * 判断该点是否与之前的点相邻
     * return
     * true：相连
     * false：不相邻
     *
     * @param a
     * @return
     */
    public static boolean check(int a) {
        if (a == 1) {
            return true;
        } else {
            for (int i = 1; i < a; i++) {
                if (Math.abs(target[a] - target[i]) == 1 || Math.abs(target[a] - target[i]) == 5) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void dfs(int n) {    //dfs 求任意位置开始连续五个的方格
        if (n == 6) {    //n=1,2,3,4,5 时分别剪取一个
            sum++;
        } else {
            for (int i = 1; i < 13; i++) {
                if (!used[i]) {          //未访问过
                    used[i] = true;      //标记为访问过
                    target[n] = B[i];
                    statuSum += statu[i];
                    if (check(n)) {
                        dfs(n + 1);
                    }
                    used[i] = false;   //回溯
                    statuSum -= statu[i];
                }
            }
        }
    }

    public static void main(String[] args) {
        dfs(1);
        System.out.println("剪取的方案数为：" + sum);
    }
}
