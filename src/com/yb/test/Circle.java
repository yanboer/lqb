package com.yb.test;

import java.util.Scanner;

public class Circle {
    public static void main(String[] args) {
        long beishu = 100000000; // 放大倍数 应该比保留位数大一位，因为可能倒数的一位 ✖️ r*r 会产生进位
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入圆的半径");
        int r = sc.nextInt(); // r为半径

        double area = Math.PI * r * r;
        System.out.println("π = "+ Math.PI);
        double S = (area * beishu + 0.5) / beishu;
        System.out.printf("面积为%.7f", S);


        /**
         * 四舍五入：（题中10为保留位数） 20.44 ====> 1、20.44*10 = 204.4 2、204.4 + 0.5 = 204.9
         * 3、204.9/10 =20.4
         * 
         * 20.45 ====> 1、20.45*10 = 204.5 2、204.5 +0.5 = 205 3、205/10 =20.5
         */
    }
}