package com.yb.test02;

import java.util.Scanner;

/**
 * 问题描述
 * 　　给定一个长度为n的数列，将这个数列按从小到大的顺序排列。1<=n<=200
 * 输入格式
 * 　　第一行为一个整数n。
 * 　　第二行包含n个整数，为待排序的数，每个整数的绝对值小于10000。
 * 输出格式
 * 　　输出一行，按从小到大的顺序输出排序后的数列。
 * 样例输入
 * 5
 * 8 3 6 4 9
 * 样例输出
 * 3 4 6 8 9
 */
public class Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        sc.close();

        String[] s1 = s.split(" ");
        int[] arry = new int[n];

        for (int i = 0; i < s1.length; i++) {
            arry[i] = Integer.parseInt(s1[i]);
        }

        sortArry(arry, 0, n - 1);

        for (int temp : arry) {
            if (temp == arry[n - 1]){
                System.out.println(temp);
            }
            else {
                System.out.print(temp + " ");
            }
        }
    }

    private static void sortArry(int[] arry, int left, int reight) {
        if (left < reight){
            int shaobing = partition(arry,left,reight);     //确定哨兵位置
            sortArry(arry,left,shaobing - 1);       //对哨兵左边排序
            sortArry(arry,shaobing + 1,reight);       //对哨兵右边排序
        }
    }

    private static int partition(int[] arry, int left, int reight) {
        //哨兵在右边开始
        int shaobing = reight;

        while (true){
            while (arry[left] < arry[shaobing] && left < reight){    //左边求比哨兵大的元素
                left++;
            }
            while (arry[reight] > arry[shaobing] && left < reight){    //右边求比哨兵小的元素
                reight++;
            }
            if (left == reight){    //重叠就互换 哨兵和 left 位置
                int temp = arry[shaobing];
                arry[shaobing] = arry[left];
                arry[left] = temp;
                return shaobing;
            }
            if (left < reight){     //left 和 reight 互换位置并重复执行移动操作
                int temp = arry[left];
                arry[left] = arry[reight];
                arry[reight] = temp;
            }
        }
    }
}
