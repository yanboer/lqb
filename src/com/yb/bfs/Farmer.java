package com.yb.bfs;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 1、农夫知道一头牛的位置，想要抓住它。农夫和牛都位于数轴上，农夫起始位于点N(0<=N<=100000)，牛位于点K(0<=K<=100000)。农夫有两种移动方式：
 * 1、从X移动到 X-1，每次移动花费一分钟
 * 4、从X移动到 X+1，每次移动花费一分钟
 * 3、从X移动到 X*2，每次移动花费一分钟
 *
 * 假设牛没有意识到农夫的行动，站在原地不动。农夫最少要花多少时间才能抓住牛？
 */
public class Farmer {
    static int num[] = new int[100000 + 1];     //辅助数组

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);        //起点位置 ====》农夫位置
        int k = Integer.parseInt(s1[1]);        //终点位置 ====》牛位置

        bfs(n,k);
    }

    /**
     *
     * @param n        //起点位置 ====》农夫位置
     * @param k        //终点位置 ====》牛位置
     */
    private static void bfs(int n, int k) {

        LinkedList<Integer> bfsTree = new LinkedList<>();//辅助队列

        bfsTree.offer(n);       //初始节点入队

        //n 距离 n 为 1(之后总路数 - 1 即可)
        num[n] = 1;

        while (!bfsTree.isEmpty()){

            int head = bfsTree.poll();//移除并返回队首元素
            
            for (int i = 0; i < 3; i++) {       //所有可走情况的模拟
                int next = 0;       //队首元素的下一个元素
                if (i == 0){        //从X移动到 X-1
                    next = head + 1;
                }
                if (i == 1){        //从X移动到 X+1
                    next = head - 1;
                }
                if (i == 2){        //从X移动到 X*2
                    next = head * 2;
                }

                if (next <0 || next > 100000){      //越界则进入下一次循环
                    continue;
                }

                if (num[next] == 0){        //该节点未被访问
                    num[next] = num[head] + 1;      //距离 + 1
                    bfsTree.offer(next);        //next 加入队列
                }

                if (head == k){     //到达终点
                    System.out.println("步数为：" + (num[head] - 1));
                    break;
                }
            }
        }

    }
}
