package com.yb.test;

import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class Test {
    @org.junit.Test
    public void test01() {
        System.out.println(10007 % 55);
        int a = (int) 4.5 / 2;
        System.out.println(a);
    }

    @org.junit.Test
    public void test02() {
        int[][] arry = new int[3][3];
        System.out.println(arry.length); //3
        System.out.printf("总共需要 L 型骨牌个数为 %d", 1);
    }

    @org.junit.Test
    public void test03() {
        System.out.println("2的3次方 = " + Math.pow(2, 3));
        System.out.println(1/2);
        int k = 0;
        int[][] arry = new int[4][4];
        for (int i = 0; i < arry.length; i++) {
            for (int j = 0; j < arry.length; j++) {
                arry[i][j] = k++;
            }
        }
        for (int i = 0; i < arry.length; i++) {
            for (int j = 0; j < arry.length; j++) {
                System.out.print(arry[i][j]+" ");
            }
            System.out.println();
        }
    }

    @org.junit.Test
    public void test04(){
        long num = 12345678;
        String s = String.valueOf(num);     // Long 转 String

        Long aLong = Long.valueOf(s);//String 转 long

        String a = s.substring(0, s.length() / 2);
        String b = s.substring(s.length() / 2, s.length());
        System.out.println(a+":"+b);
    }
    /**
     * 矩阵相减
     */
    public int[][] matrix_Minus(int[][] a,int[][] b){
        int c[][] = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }

    @org.junit.Test
    public void test05(){
        int[][] a = new int[4][4];
        int[][] b = new int[4][4];
        int num = 0;
        //a 初始化
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = ++num;
            }
        }

        //b初始化
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                b[i][j] = 1;
            }
        }

        int[][] c = matrix_Minus(a, b);

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
    }

    @org.junit.Test
    public void test06(){
        List<String> arry1 = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arry1.add(String.valueOf(i));
        }

        System.out.println(arry1.get(0));

    }

    @org.junit.Test
    public void test07(){
        char c = (char) ('A' + 4);
        System.out.println(c);
        System.out.println(true | false | false | false);
    }
}
