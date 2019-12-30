package com.yb.lqb.eightlqb;

/**
 *
 标题：纸牌三角形

 A,2,3,4,5,6,7,8,9 共9张纸牌排成一个正三角形（A按1计算）。要求每个边的和相等。
 下图就是一种排法（如有对齐问题，参看p1.png）。

        A                               a[0]
     9   6                          a[1]    a[8]
   4      8     ============》    a[2]          a[7]    ============》
 3  7  5   2                   a[3]  a[4]  a[5]   a[6]


 a[0] + a[1] +a[2] + a[3]    =   a[3] + a[4] + a[5] + a[6]   = a[0] + a[8] + a[7] + a[6]

 这样的排法可能会有很多。

 如果考虑旋转、镜像后相同的算同一种，一共有多少种不同的排法呢？

 请你计算并提交该数字。

 注意：需要提交的是一个整数，不要提交任何多余内容。
 */

/**

       A
     9   6
   4       8
 3   7   5   2

       A
     6   9
   8       4
 2   5   7   8

       2
     5   8
   7       6
 3   4   9   1

       2
     8   5
   6       7
 1   9   4   3

       3
     4   7
   9       5
 1   6   8   2


       3
     7   4
   5       9
 2   8   6   1
 */
class Demo02 {

    static int[] arry = new int[9];
    static boolean[] color = new boolean[9];

    static int sum = 0;     //记录总解数
    public static void main(String[] args) {

        dfs(0);
        System.out.println(sum / 6);        //因为一种情况有三种镜像。(即有四种重复情况)
    }

    private static void dfs(int n) {
        if (n == 9){        //选够数字
            if (checkNumber(arry)){
                sum++;
            }
        }
        else {
            for (int i = 0; i < 9; i++) {
                if (color[i] == false){         //该元素未使用
                    color[i] = true;            //标记
                    arry[n] = i + 1;            //访问
                    dfs(n + 1);              //继续递归
                    color[i] = false;           //回溯
                }
            }
        }
    }

    private static boolean checkNumber(int[] arry) {
        int a = arry[0] + arry[1] + arry[2] + arry[3];
        int b = arry[3] + arry[4] + arry[5] + arry[6];
        int c = arry[0] + arry[8] + arry[7] + arry[6];
        if (a == b && b == c){      //满足就返回 true
            return true;
        }
        return false;
    }


}
