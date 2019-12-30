package com.yb.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *    1   2   3   4   5   6   7
 *    #############################
 *  1 #   |   #   |   #   |   |   #
 *    #####---#####---#---#####---#
 *  2 #   #   |   #   #   #   #   #
 *    #---#####---#####---#####---#
 *  3 #   |   |   #   #   #   #   #
 *    #---#########---#####---#---#
 *  4 #   #   |   |   |   |   #   #
 *    #############################
 *            (图 1)
 *
 *    #  = Wall
 *    |  = No wall
 *    -  = No wall
 *
 * 图1是一个城堡的地形图。请你编写一个程序，计算城堡一共有多少房间，最大的房间有多大。城堡被分割成m*n(m≤50，n≤50)个方块，每个方块可以有0~4面墙。 
 * Input程序从标准输入设备读入数据。第一行是两个整数，分别是南北向、东西向的方块数。在接下来的输入行里，每个方块用一个数字(0≤p≤50)描述。
 * 用一个数字表示方块周围的墙，1表示西墙，2表示北墙，4表示东墙，8表示南墙。每个方块用代表其周围墙的数字之和表示。城堡的内墙被计算两次，
 * 方块(1,1)的南墙同时也是方块(2,1)的北墙。输入的数据保证城堡至少有两个房间。Output城堡的房间数、城堡中最大房间所包括的方块数。结果显示在标准输出设备上。 
 *
 *
 * Sample Input
 * 4
 * 7
 * 11 6 11 6 3 10 6
 * 7 9 6 13 5 15 5
 * 1 10 12 7 13 7 5
 * 13 11 10 8 10 12 13
 * Sample Output
 *
 * 5
 * 9
 */
public class Tower {
    static int[][] maze;            //表示城堡

    static boolean[][] color;       //标记房间

    static int roomNumber = 0;      //房间数量  ===》房间个数

    static int currentRoomArea = 0;        //当前房间面积

    static int maxRoomArea = 0;        //最大房间面积

    static int minRoomArea = 100;     //最小房间面积

    static List<String> pathList = new ArrayList<>();       //数组记录每条路径

    static int west = 1;        //1表示西墙
    static int north = 2;       //2表示北墙
    static int east = 4;        //4表示东墙
    static int sourth = 8;      //8表示南墙


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = Integer.parseInt(sc.nextLine());        //城堡行数
        int n = Integer.parseInt(sc.nextLine());        //城堡列数

        maze = new int[m][n];
        color = new boolean[m][n];

        //maze 数组初始化
        for (int i = 0; i < m; i++) {
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            for (int j = 0; j < n; j++) {
                maze[i][j] = Integer.parseInt(s1[j]);
            }
        }

        //验证
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (color[i][j] == false) {
                    roomNumber++;       //房间个数 + 1
                    currentRoomArea = 0;       //每次开始时房间个数均为0
                    dfs(maze, i, j);
                    maxRoomArea = Math.max(maxRoomArea,currentRoomArea);        //最大房间面积
                    minRoomArea = Math.min(minRoomArea,currentRoomArea);        //最小房间面积
                }
            }
        }
        System.out.println("房间数 = " + roomNumber);
        System.out.println("最大房间个数 = " + maxRoomArea);
        System.out.println("最小房间个数 = " + minRoomArea);


    }

    private static void dfs(int[][] maze,int x,int y) {
        if (x < 0 || x > maze.length - 1 || y < 0 || y > maze[0].length - 1){       //越界
            return;
        }
        if (color[x][y] == true){       //访问过就直接退出
            return;
        }
        color[x][y] = true;     //标记该元素

        currentRoomArea++;

        if ((maze[x][y] & west) == 0){      //没有西墙
            dfs(maze,x,y - 1);      //继续向西深搜
        }
        if ((maze[x][y] & north) == 0 ){     //没有北墙
            dfs(maze,x - 1,y);      //继续向北深搜
        }
        if ((maze[x][y] & east) == 0 ){     //没有东墙
            dfs(maze,x,y + 1);      //继续向东深搜
        }
        if ((maze[x][y] & sourth) == 0 ){     //没有南墙
            dfs(maze,x + 1,y);      //继续向南深搜
        }

    }
}