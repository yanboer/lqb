package com.yb.lqb.ninelqb;

/**
 *
 标题：方格计数

 如图p1.png所示，在二维平面上有无数个1x1的小方格。


 我们以某个小方格的一个顶点为圆心画一个半径为1000的圆。
 你能计算出这个圆里有多少个完整的小方格吗？

 注意：需要提交的是一个整数，不要填写任何多余内容。

 */
public class Demo02 {
    public static void main(String[] args) {
        int sum = 0;    //记录总解数

        long r = 1000;
        for (int i = 1; i <= 1000; i++) {       //计算左上边的半弧的方格个数
            for (int j = 1; j <= 1000; j++) {
                if (i*i + j*j <= r*r){      //方格的左上角不超过半径
                    sum++;
                }
            }
        }
        System.out.println(sum * 4);
    }
}
