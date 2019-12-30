package com.yb.lqb.ninelqb;

/**
 * 标题：快速排序
 * <p>
 * 以下代码可以从数组a[]中找出第k小的元素。
 * <p>
 * <p>
 * 它使用了类似快速排序中的分治算法，期望时间复杂度是O(N)的。
 * <p>
 * <p>
 * 请仔细阅读分析源码，填写划线部分缺失的内容。
 */

import java.util.Random;

public class Demo05 {
    public static int quickSelect(int a[], int l, int r, int k) {
        Random rand = new Random();
        int p = rand.nextInt(r - l + 1) + l;    //随机哨兵位置
        int x = a[p];
        int tmp = a[p];
        a[p] = a[r];
        a[r] = tmp;    //a[r] 和 a[p] 换位置
        int i = l, j = r;
        while (i < j) {      //左边 < 右边
            while (i < j && a[i] < x) i++;       //左边求比 哨兵大的
            if (i < j) {
                a[j] = a[i];
                j--;
            }
            while (i < j && a[j] > x) j--;       //右边求比 哨兵小的
            if (i < j) {
                a[i] = a[j];
                i++;
            }
        }
        a[i] = x;       // a[i] = a[p] = a[r]
        p = i;


        //哨兵位置左边都比哨兵小，右边都比哨兵大

        if (i - l + 1 == k) return a[i];         //当选中的哨兵和所求第 k 小的数相同时，返回即可
//        if(i - l + 1 < k) return quickSelect( _________________________________ ); //填空
        //在右边区域求第 (k - (左边区域长度 + 哨兵长度))小的元素。 即 k-(i-1-l+1+1)小元素
//        if(i - l + 1 < k) return quickSelect(a, i + 1, r, k-(i-l+1) );

        if (i - l + 1 < k) return quickSelect(a, i, r, k - (i - l));

        else return quickSelect(a, l, i - 1, k);        //当不相同时，在左边区域继续求第 k 小的数。
    }

    public static void main(String args[]) {
        int[] a = {1, 4, 2, 8, 5, 7};
        System.out.println(quickSelect(a, 0, 5, 4));
    }
}
