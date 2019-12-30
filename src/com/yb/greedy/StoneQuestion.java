package com.yb.greedy;

import java.util.Scanner;

/**
 *  你有n堆石头质量分别为W1,W2,W3…Wn.(n＜＝100000)现在需要你将两堆石头合并，问一共所用力量最小是多少？
 */
public class StoneQuestion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入 n = ");
        int n = sc.nextInt();
        int[] weight = new int[n + 1];

        for (int i = 1; i <= n ; i++) {
            System.out.print("请输入第 " + i + "堆石头的重量：");
            weight[i] = sc.nextInt();
        }


        int minPower = minPower(n,weight);
        System.out.println("所需最小力量为：" + minPower);
    }

    private static int minPower(int n, int[] weight) {
        int minPower = 0;
        for (int i = 2; i <= n ; i++) {
            //对石头重量进行排序
            quick(weight,1,n);

            //贪心算法，每次合并最小力量的两堆石头(局部最优解)
            weight[i] += weight[i - 1];
            minPower += weight[i];
        }
        return minPower;
    }





    /**
     * @param target 目标数组
     * @param left   左边
     * @param right  右边
     */
    public static void quick(int[] target, int left, int right) {
        if (right > left) {
            int sb = partation(target, left, right);//哨兵定位，返回哨兵位置
            quick(target, left, sb - 1);  //对哨兵左边排序
            quick(target, sb + 1, right); //对哨兵右边排序
        }
    }

    //确定哨兵位置的方法
    private static int partation(int[] target, int left, int right) {
        int shaobing = right;
        while(true) {
            while (target[left] < target[shaobing] && left < right) {      //左边求比哨兵大的元素(不能包含等于，等于时应该退出)
                left++;
            }
            while (target[right] > target[shaobing] && right > left) {      //右边求出比哨兵小的元素(不能包含等于，等于时应该退出)
                right--;
            }
            if (right == left) {        //左右重合时即代表哨兵的位置
                int temp = target[shaobing];
                target[shaobing] = target[left];
                target[left] = temp;
                return shaobing;
            } else if (left < right) {     //不相等则交互位置继续操作
                int temp = target[left];
                target[left] = target[right];
                target[right] = temp;
            }
        }
    }
}
