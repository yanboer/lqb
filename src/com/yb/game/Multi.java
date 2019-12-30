package com.yb.game;

/**
 * 大整数乘法
 *
 *
 *  X = AB      (AB 分别为 n/2 位的数)
 *  Y = CD      (CD 分别为 n/2 位的数)
 *      分治法：
 *          XY = ac * 10^n + (ad+bc)*10^(n/2) +bd
 *          共需计算四次 2^(n/2)次计算
 *
 *      优化1、XY = ac * 10^n + ((a-b)(d-c)+ac+bd)*10^(n/2) + bd    =====>十进制就是 10 ^n
 *
 *      优化2、XY = ac * 10^n + ((a+b)(c+d)-ac-bd)*10^(n/2) + bd    =====>二进制就是 2 ^n
 *
 */
public class Multi {


    /**
     *
     * @param x     X
     * @param y     Y
     */
    public static double partition(long x,long y){

        String x_s = String.valueOf(x);
        String y_s = String.valueOf(y);
        int x_midel = x_s.length() / 2;     //x的位数
        int y_midel = y_s.length() / 2;     //y的位数



        long a = Long.valueOf(x_s.substring(0,x_midel));        // String 类型转化为 long 类型
        long b = Long.valueOf(x_s.substring(x_midel,x_s.length()));        // String 类型转化为 long 类型

        long c = Long.valueOf(y_s.substring(0, y_midel));        // String 类型转化为 long 类型
        long d = Long.valueOf(y_s.substring(y_midel,y_s.length()));        // String 类型转化为 long 类型

        if (x_s.length() == 2 && y_s.length() == 2){
            return (a * c) * Math.pow(10,x_s.length()) +((a - b) * (d - c)+ a * c + d * b) * Math.pow(10,x_midel) + b * d * 1.0;
        }
        //XY = ac * 10^n + ((a-b)(d-c)+ac+bd)*10^(n/2) + bd

        return partition(a, c) * Math.pow(10, x_s.length()) + ((a - b) * (d - c) + partition(a, c) + partition(b, d)) * Math.pow(10, x_midel) + partition(b, d);


    }

    public static void main(String[] args) {

        long x = 9999;
        long y = 9999;
        double result = partition(x, y);
        System.out.println("预期结果：x * y = "+result);
        System.out.println("实际结果：x * y =  " + 9999 * 9999);
    }
}
