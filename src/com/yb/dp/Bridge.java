package com.yb.dp;

import java.util.Scanner;

/**
 * bridge：
 * 在一个夜黑风高的晚上，有n（n <= 50）个小朋友在桥的这边，现在他们需要过桥，但是由于桥很窄，每次只允许不大于两人通过，
 * 他们只有一个手电筒，所以每次过桥的两个人需要把手电筒带回来，i号小朋友过桥的时间为T[i]，两个人过桥的总时间为二者中时间长者。
 * 问所有小朋友过桥的总时间最短是多少？
 */
public class Bridge {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入 n = ");
        int peopleNumber = sc.nextInt();

        int[] bridgeTime = new int[peopleNumber + 1];
        for (int i = 1; i <= peopleNumber; i++) {
            System.out.print("请输入第 " + i + "个小朋友的过桥时间为：");
            bridgeTime[i] = sc.nextInt();
        }

        sort(bridgeTime, 0, bridgeTime.length - 1);
        for (int temp : bridgeTime) {
            if (temp != 0) {
                System.out.print(temp + " ");
            }
        }
        System.out.println();

        int spendTime = solution(peopleNumber, bridgeTime);

        System.out.println("最短过桥时间为：" + spendTime);
    }

    /**
     * 对 n 个小朋友的过河时间进行升序排序  ----> 快速排序
     *
     * @param arry
     */
    public static void sort(int[] arry, int left, int right) {

        if (left < right) {
            int shaobing = shaobing(arry, left, right);       //确定哨兵位置
            sort(arry, left, shaobing - 1);       //对哨兵左边进行排序
            sort(arry, shaobing + 1, right);     //对哨兵右边进行排序
        }
    }

    private static int shaobing(int[] arry, int left, int right) {
        int shaobing = right;   //哨兵初始位置在右边
        while (true) {
            while (arry[left] < arry[shaobing]) {        //左边求出比哨兵大的元素
                left++;
            }
            while (arry[right] > arry[shaobing]) {       //右边求出比哨兵小的元素
                right++;
            }

            if (left == right) {      //如果位置重叠则互换 left shaobing 位置
                int temp = arry[left];
                arry[left] = arry[shaobing];
                arry[shaobing] = temp;
                return shaobing;
            }
            if (left < right) {      //如果位置不重叠则互换 left right 位置
                int temp = arry[left];
                arry[left] = arry[right];
                arry[right] = temp;
            }
        }
    }


    private static int solution(int peopleNumber, int[] bridgeTime) {

        //bestTime[n] 表示前 n 个小朋友的最短过桥时间
        int[] bestTime = new int[peopleNumber + 1];
        int spendTime = best(peopleNumber, bridgeTime, bestTime);
        return spendTime;
    }


    private static int best(int peopleNumber, int[] bridgeTime, int[] bestTime) {

        if (bestTime[peopleNumber] != 0) {
            return bestTime[peopleNumber];
        } else {
            if (peopleNumber == 1) {
                bestTime[1] = bridgeTime[1];
            }
            if (peopleNumber == 2) {
                bestTime[2] = bridgeTime[2];
            }
            for (int i = 3; i <= peopleNumber ; i++) {
                // b[n] = b[n - 2] + t[1] + t[2]*2 + t[n];      当有两个人跑的快时   例如 1，2，5，10  ====》结果为17
                int a = best(peopleNumber - 2, bridgeTime, bestTime) + bridgeTime[2] * 2 + bridgeTime[1] + bridgeTime[i];

                //b[n] = b[n - 1] + t[1] + t[n]         当有一个人跑的快时 例如 1，7，8，9 ====》结果为26
                int b = best(peopleNumber - 1, bridgeTime, bestTime) + bridgeTime[1] + bridgeTime[i];
                bestTime[peopleNumber] = Math.min(a, b);
            }
        }
        return bestTime[peopleNumber];
    }
}
