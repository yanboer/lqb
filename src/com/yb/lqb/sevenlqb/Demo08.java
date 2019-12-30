package com.yb.lqb.sevenlqb;

import java.util.Scanner;

/**
 * 四平方和
 *
 * 四平方和定理，又称为拉格朗日定理：
 * 每个正整数都可以表示为至多4个正整数的平方和。
 * 如果把0包括进去，就正好可以表示为4个数的平方和。
 *
 * 比如：
 * 5 = 0^2 + 0^2 + 1^2 + 2^2
 * 7 = 1^2 + 1^2 + 1^2 + 2^2
 * （^符号表示乘方的意思）
 *
 * 对于一个给定的正整数，可能存在多种平方和的表示法。
 * 要求你对4个数排序：
 * 0 <= a <= b <= c <= d
 * 并对所有的可能表示法按 a,b,c,d 为联合主键升序排列，最后输出第一个表示法
 *
 *
 * 程序输入为一个正整数N (N<5000000)
 * 要求输出     4个非负整数  ，按  从小到大    排序，中间用空格分开
 *
 * 例如，输入：
 * 5
 * 则程序应该输出：
 * 0 0 1 2
 *
 * 再例如，输入：
 * 12
 * 则程序应该输出：
 * 0 2 2 2
 *
 * 再例如，输入：
 * 773535
 * 则程序应该输出：
 * 1 1 267 838
 *
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 3000ms
 *
 *
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 *
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 注意：不要使用package语句。不要使用jdk1.7及以上版本的特性。
 * 注意：主类的名字必须是：Main，否则按无效代码处理。
 */
public class Demo08 {

    static int[] target = new int[4];       //存放第 i 次输出结果

    static int n;       //存放输入结果

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();       // 0 < N < 5000000

        dfs(0);

    }

    private static void dfs(int index) {
        if (index == 4){        //四个数找完
            if (checkNum(target)){      //找到的数字满足条件
                sort(target);       //对找到符合条件的数组排序
                System.out.println(target[0]+" "+ target[1] +" "+target[2] +" "+target[3]);
                System.exit(0);         //执行完一次输出直接退出当前程序
            }
        }
        else {
            for (int i = 0; i <= Math.sqrt(n); i++) {       //每个数字最大值就是 Math.sqrt(n)
                target[index] = i;      //赋值
                dfs(index + 1);     //继续深度检索
                target[index] = 0;      //回溯
            }

        }
    }

    private static void sort(int[] target) {
        for (int i = 0; i < target.length; i++) {
            for (int j = i; j < target.length; j++) {
                if (target[i] > target[j]){
                    int temp = target[i];
                    target[i] = target[j];
                    target[j] = temp;
                }
            }
        }
    }

    private static boolean checkNum(int[] target) {

        int a = target[0];
        int b = target[1];
        int c = target[2];
        int d = target[3];

        if (a*a + b*b + c*c + d*d ==n){
            return true;
        }
        return false;
    }
}