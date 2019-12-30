package com.yb.bfs;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 题目描述
 * 给定一个大小为 N×M的迷宫。迷宫由通道和墙壁组成，每一步可以向邻接的上下左右四格的通道移动。请求出从起点到终点所需的小步数。
 * 请注意，本题假定从起点一定可以移动到终点
 * <p>
 * 限制条件：N,M<=100;
 * <p>
 * 样例输入：N=10,M=10('#','.','S','G'分别表示墙壁，通道，起点和终点)
 * <p>
 * #S######.#
 * <p>
 * ......#..#
 * <p>
 * .#.##.##.#
 * <p>
 * .#........
 * <p>
 * ##.##.####
 * <p>
 * ....#....#
 * <p>
 * .#######.#
 * <p>
 * ....#.....
 * <p>
 * .####.###.
 * <p>
 * ....#...G# 
 * <p>
 * 输出最短路径为22
 */
public class Maze {
    static int[][] maze;        //二维数组存储迷宫

    static int[] start = new int[2];         //起点
    static int[] end = new int[2];           //终点

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);        //迷宫长
        int k = Integer.parseInt(s1[1]);        //迷宫宽

        maze = new int[n][k];

        for (int i = 0; i < k; i++) {
            String s2 = sc.nextLine();
            for (int j = 0; j < n; j++) {
                if (s2.substring(j, j + 1).equals("#")) {       //表示墙
                    maze[i][j] = 1;
                }
                if (s2.substring(j, j + 1).equals(".")) {       //表示通路
                    maze[i][j] = 0;
                }
                if (s2.substring(j, j + 1).equals("S")) {       //表示起点
                    maze[i][j] = 2;
                    start[0] = i;
                    start[1] = j;
                }
                if (s2.substring(j, j + 1).equals("G")) {       //表示终点
                    maze[i][j] = 3;
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("起点：" + "(" + start[0] + "," + start[1] + ")");
        System.out.println("终点：" + "(" + end[0] + "," + end[1] + ")");

//        Point point = new Point(0, 0);
//        point.x=1;
//        point.y=1;
//        System.out.println(point);
        bfs(maze, start, end);

    }

    private static void bfs(int[][] maze, int[] start, int[] end) {
        //1、辅助队列
        LinkedList<int[]> bfsTree = new LinkedList<>();        //存放长度为 2 的数组的辅助队列

        //2、辅助数组
        int[][] num = new int[maze.length + 1][maze[0].length + 1];

        //3、起点入队列
        bfsTree.offer(start);

        //4、num 初始化
        num[start[0]][start[1]] = 1;      //(start_x,start_y) 距离初始点距离为 1

        int[] dx = {1, -1, 0, 0};       // dx[i] + dy[i] 共同构成节点的可移动方向
        int[] dy = {0, 0, 1, -1};

        //5、队列不为空就一直循环
        while (!bfsTree.isEmpty()) {
            int[] head = bfsTree.poll();//移除并返回第一个元素

            for (int i = 0; i < 4; i++) {
                int next[] = new int[2];        //head 的下次可移动方向集合

                // head 的下一次可移动的四个方向集合
                next[0] = head[0] + dx[i];
                next[1] = head[1] + dy[i];

                if (next[0] < 0 || next[0] > maze.length - 1 || next[1] < 0 || next[1] > maze[0].length - 1) {      //越界
                    continue;
                }
                if (maze[next[0]][next[1]] == 1) {       //墙
                    continue;
                }
                if (num[next[0]][next[1]] == 0) {      //next 未被访问
                    //1、加入队列
                    bfsTree.offer(next);
                    //2、距离 + 1
                    num[next[0]][next[1]] = num[head[0]][head[1]] + 1;
                }
                if (head[0] == end[0] && head[1] == end[1]) {        //到达终点
                    System.out.println("最短路径长度为：" + (num[head[0]][head[1]] - 1));
                    break;
                }
            }
        }

    }
}

