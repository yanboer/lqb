package com.yb.search;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class Bubbling {
    static int[] listA = new int[]{1, -1, 7, 3, 8, -7, 2, 4, 3, -1};

    public int[] maopao(int[] listA) {
        for (int i = 0; i < listA.length; i++) {
            for (int j = i + 1; j < listA.length; j++) {
                if (listA[i] > listA[j]) {
                    int temp = listA[j];
                    listA[j] = listA[i];
                    listA[i] = temp;
                }
            }
        }
        return listA;
    }

    public static void main(String[] args) {
        Bubbling bubbling = new Bubbling();
        int[] maopao_list = bubbling.maopao(listA);
        for (int temp : maopao_list) {
            System.out.print(temp + " ");
        }

    }
}
