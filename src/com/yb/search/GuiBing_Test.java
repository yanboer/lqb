package com.yb.search;

/**
 * 归并排序
 */
public class GuiBing_Test {
    public static void main(String[] args) {
        int[] arry = {1, -1, 8, -8, 3, -1, 1, 7, 4, 7, 8};
        partation(arry,0,arry.length - 1);
        for (int temp :
                arry) {
            System.out.print(temp + " ");
        }
    }

    private static void partation(int[] arry, int left, int right) {
        int midel = (left + right)/2;
        if (left < right){
            partation(arry,left,midel);
            partation(arry,midel + 1,right);
            merge(arry,left,midel + 1,right);
        }
    }

    private static void merge(int[] arry, int left, int midel, int right) {
        int l = left;
        int r = midel;
        int[] temp = new int[arry.length];      //临时数组
        int t = 0;      //临时指针

        while (l <= midel - 1 && r <= right){
            if (arry[l] < arry[r]){
                temp[t++] = arry[l++];
            }
            if (arry[l] >= arry[r]){
                temp[t++] = arry[r++];
            }
        }
        while (l <= midel - 1){
            temp[t++] = arry[l++];
        }
        while (r <= right){
            temp[t++] = arry[r++];
        }

        t = 0;
        while (left <= right){
            arry[left++] = temp[t++];
        }
    }
}
