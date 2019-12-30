package com.yb.dfs;

import java.util.Scanner;

/**
 * 油田问题
 */
public class Oilfield {
    static int sum = 0;     //记录总共八联通数
    static boolean[][] color = null;

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("输入 m = ");
//        int m = sc.nextInt();       //m 行
//        System.out.println("输入 n = ");
//        int n = sc.nextInt();       //n 列
//
//        int[][] arry = new int[m + 1][n + 1];   //矩阵代表油田
//        color = new boolean[m + 1][n + 1];      //代表是否访问过该方格
//
//        dfs(arry,1);

        color = new boolean[6][9];
        int[][] test = new int[6][9];
        initArry(test);
        for (int i = 1; i < test.length; i++) {
            for (int j = 1; j < test[i].length ; j++) {
                System.out.printf(test[i][j] + " ");
            }
            System.out.println();
        }

        dfs(test,1);
        System.out.println("结果为："+ sum + " 个八联通");

    }

    //数组初始化
    public static void initArry(int[][] arry){
        for (int i = 1; i < arry.length; i++) {
            for (int j = 1; j < arry[i].length ; j++) {
                if ( i%2 !=0) {
                    arry[i][j] = 1;
                }
                else {
                    arry[i][j] = 0;
                }
            }

        }
    }

    private static void dfs(int[][] arry, int n) {
        if (n > 8){        //八个时返回结果
            sum++;
        }
        else {
            for (int i = 1; i < arry.length ; i++) {       //行
                for (int j = 1; j < arry[i].length; j++) {     //列
                    if (arry[i][j] != 0 && !color[i][j]){        //该方格为 "@" 格子
                        color[i][j] = true;     //标记该格子
                        if (checkChar(arry,i,j,color)){       //判断 arry[i][j] 和之前的 "@" 字符是否相连
                            dfs(arry,n + 1);
                        }
                        color[i][j] = false;        //回溯
                    }
                }

            }
        }
    }



    //检查第 i 个是否和之前相连
    private static boolean checkChar(int[][] arry,int m,int n,boolean[][] color){
        for (int i = 1; i < arry.length; i++) {
            for (int j = 1; j < arry[i].length ; j++) {
                if (color[i][j]){
                    if ((m == i && Math.abs(n - i) == 1) || (n == j && Math.abs(m - i) == 1) ){     //横竖相连
                        if (Math.abs(m - i) == 1 && Math.abs(n - j) == 1 ) {       //斜着相连
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}
