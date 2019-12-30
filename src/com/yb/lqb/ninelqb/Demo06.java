package com.yb.lqb.ninelqb;

import java.util.Scanner;

/**
 * 标题：递增三元组
 * <p>
 * 给定三个整数数组
 * A = [A1, A2, ... AN],
 * B = [B1, B2, ... BN],
 * C = [C1, C2, ... CN]，
 * 请你统计有多少个三元组(i, j, k) 满足：
 * <p>
 * 1. 1 <= i, j, k <= N
 * 2. Ai < Bj < Ck
 * <p>
 * 【输入格式】
 * 第一行包含一个整数N。
 * 第二行包含N个整数A1, A2, ... AN。
 * 第三行包含N个整数B1, B2, ... BN。
 * 第四行包含N个整数C1, C2, ... CN。
 * <p>
 * 对于30%的数据，1 <= N <= 100
 * 对于60%的数据，1 <= N <= 1000
 * 对于100%的数据，1 <= N <= 100000 0 <= Ai, Bi, Ci <= 100000
 * <p>
 * 【输出格式】
 * 一个整数表示答案
 * <p>
 * 【输入样例】
 * 3
 * 1 1 1
 * 2 2 2
 * 3 3 3
 * <p>
 * 【输出样例】
 * 27
 * <p>
 * <p>
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 1000ms
 * <p>
 * <p>
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 不要使用package语句。不要使用jdk1.7及以上版本的特性。
 * 主类的名字必须是：Main，否则按无效代码处理。
 */
public class Demo06 {
    static int[] a1;
    static int[] a2;
    static int[] a3;
    static int n;

    static int count = 0;       //记录满足条件的个数


    static int[] target;        //将选中的数字放入 target 中


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();      //第一行
        n = Integer.parseInt(s1);

        a1 = new int[n];        //初始化
        a2 = new int[n];
        a3 = new int[n];
        target = new int[n];

        String s2 = sc.nextLine();      //第二行
        String s3 = sc.nextLine();      //第三行
        String s4 = sc.nextLine();      //第四行


        String[] sa = s2.split(" ");
        String[] sb = s3.split(" ");
        String[] sd = s4.split(" ");

        for (int i = 0; i < n; i++) {
            a1[i] = Integer.parseInt(sa[i]);
            a2[i] = Integer.parseInt(sb[i]);
            a3[i] = Integer.parseInt(sd[i]);
        }

//        System.out.println("数组赋值结果为：");
//
//        for (int i = 0; i < n; i++) {
//            System.out.println("a1 =" + a1[i]);
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.println("a2 =" + a2[i]);
//        }
//        for (int i = 0; i < n; i++) {
//            System.out.println("a3 =" + a3[i]);
//        }
//
//        System.out.println(n);

        dfs(0);
        System.out.println("有"+count+"种");
    }

    private static void dfs(int index) {
        if (index == 3) {
            if (checkNum(target)) {
                count++;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (index == 0) {
                    target[index] = a1[i];      //赋值
                    dfs(index + 1);     //递归
                    target[index] = 0;      //回溯
                }
                if (index == 1) {
                    target[index] = a2[i];      //赋值
                    dfs(index + 1);     //递归
                    target[index] = 0;      //回溯
                }
                if (index == 2) {
                    target[index] = a3[i];      //赋值
                    dfs(index + 1);     //递归
                    target[index] = 0;      //回溯
                }
            }
        }

    }

    private static boolean checkNum(int[] target) {
        if (target[0] < target[1] && target[1] < target[2]) {        //arry[0]、arry[1]、arry[2]分别代表 Ai  Bj  Ck
            return true;
        }
        return false;
    }
}
