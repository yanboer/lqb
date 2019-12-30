package com.yb.search;

/**
 * 二分搜索的前提是需要待搜索的数组是有序的，令A[low…high]为元素按升序排列的非空数组，
 * A[mid]为中间元素，x为给定元素，假定x>A[mid]，那么，x肯定在A[mid+1],…,A[high]中，
 * 接下来只需在A[mid+1…high]中搜索x即可。类似的，如果x<<A[mid]，只需在A[low..mid-1]中搜索x。
 * 重复此过程，直到找到元素x或者当前数组长度为0为止。
 */
public class HalfSearch {
    /**
     * @param target 目标数组
     * @param x      待查数索引
     */
    public int searchX(int[] target, int x) {
        int left = 0;
        int right = target.length - 1;
        int index = 0; //要查数据的索引
        while (left <= right) {
            int midel = (left + right) / 2;       //中间元素
            if (x > target[midel]) {
                left = midel + 1;
            } else if (x < target[midel]) {
                right = midel - 1;
            } else if (x == target[midel]) {
                index = midel;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {

        int[] target = {1, 3, 5, 7, 9, 10, 11, 15, 20, 21};
        HalfSearch hs = new HalfSearch();
        int x = hs.searchX(target, 9);
        System.out.println("查询结果为该数组第" + x + "个！");
    }
}
