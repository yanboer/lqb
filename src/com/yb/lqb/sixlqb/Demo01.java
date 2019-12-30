package com.yb.lqb.sixlqb;

/**
 * 三角形面积
 * <p>
 * 如【图1】所示。图中的所有小方格面积都是1。
 * 那么，图中的三角形面积应该是多少呢？
 * <p>
 * 请填写三角形的面积。不要填写任何多余内容或说明性文字。
 */
public class Demo01 {
    public static void main(String[] args) {
        double result = 8 * 8 - 4 * 8 * 0.5 - 4 * 6 * 0.5 - 2 * 8 * 0.5;
        System.out.println((int)result);
    }
}
