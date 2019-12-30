package com.yb.search;

/**
 * 快速排序：
 * 1．先从数列中取出一个数作为基准数。
 * <p>
 * 2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
 * <p>
 * 3．再对左右区间重复第二步，直到各区间只有一个数。
 */
public class QuickQuery {

    /**
     * @param target 目标数组
     * @param left   左边
     * @param right  右边
     */
    public void quick(int[] target, int left, int right) {
        if (right > left) {
            int sb = partation(target, left, right);//哨兵定位，返回哨兵位置
            quick(target, left, sb - 1);  //对哨兵左边排序
            quick(target, sb + 1, right); //对哨兵右边排序
        }
    }

    //确定哨兵位置的方法
    private int partation(int[] target, int left, int right) {
        int shaobing = left;
        while (left < right) {
            while (target[right] >= target[shaobing] && right > left) {      //右边求出比哨兵小的元素(不能包含等于，等于时应该退出)
                right--;
            }
            while (target[left] <= target[shaobing] && left < right) {      //左边求比哨兵大的元素(不能包含等于，等于时应该退出)
                left++;
            }

            if (left < right) {     //不相等则交互位置继续操作
                int temp = target[left];
                target[left] = target[right];
                target[right] = temp;
            }
            if (right == left) {        //左右重合时即代表哨兵的位置
                int temp = target[shaobing];
                target[shaobing] = target[left];
                target[left] = temp;
            }
        }
        return shaobing;
    }

    public static void main(String[] args) {
        int[] list_A = {1, 3, 7, -9, -1, 13, 25, 88, -33, 4, 20, 18, 22, 6, 5, -7, 7};

        int[] list_B = {-9, 7, 4, -33, -1};

        QuickQuery quickQuery = new QuickQuery();
        quickQuery.quick(list_A, 0, list_A.length - 1);
        for (int temp : list_A) {
            System.out.print(temp + " ");
        }
        System.out.println();
        quickQuery.quick(list_B, 0, list_B.length - 1);
        for (int temp : list_B) {
            System.out.print(temp + " ");
//        }
        }
    }
}
