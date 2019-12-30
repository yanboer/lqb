package com.yb.search;

import com.sun.xml.internal.ws.util.StreamUtils;

/**
 * 归并排序
 */
public class GuiBing {

    //递归实现长数组的分割
    public void sort(int[] arry, int left, int right) {
        int midle = (left + right) / 2;
        if (left < right) {
            sort(arry, left, midle);                //对左半部分分割
            sort(arry, midle + 1, right);       //对右半部分分割
            merge(arry, left, midle + 1, right);        //数组元素的升序合并
        }
    }

    /**
     * 用于数组元素的升序合并
     *
     * @param arry1 需要分割的长数组
     * @param left  左半部分的首元素
     * @param midel 右半部分的首元素（同时也能表示左边数组的右边界）
     * @param right 右半部分的边界值
     */
    public void merge(int[] arry1, int left, int midel, int right) {
        int l = left;  //左半部分的指针
        int r = midel;  //右半部分的指针
        int temp[] = new int[arry1.length];      //创建临时数组
        int t = 0;  //临时数组指针
        while (l <= midel - 1 && r <= right) {
            if (arry1[l] < arry1[r]) {        //比较左半部分和右半部分元素的大小，小的放入temp[] 中
                temp[t++] = arry1[l++];
            } else if (arry1[l] >= arry1[r]) {        //比较左半部分和右半部分元素的大小，小的放入temp[] 中
                temp[t++] = arry1[r++];
            }
        }
        while (l <= midel - 1) {       //如果左边数组未放完，将剩余元素放入   temp[]
            temp[t++] = arry1[l++];
        }

        while (r <= right) {       //如果右边数组未放完，将剩余元素放入   temp[]
            temp[t++] = arry1[r++];
        }

        t = 0;
        //将 temp[] 复制到 arry1[]
        while (left <= right) {
            arry1[left++] = temp[t++];
        }
    }

    public static void main(String[] args) {

        int[] arry = new int[]{1, 3, -3, 7, 3, 2, 4, 6, 8, -1, -19};
        GuiBing guiBing = new GuiBing();
        guiBing.sort(arry, 0, arry.length - 1);
        for (int temp : arry) {
            System.out.print(temp + " ");
        }
    }
}
