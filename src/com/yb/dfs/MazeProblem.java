package com.yb.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 迷宫问题
 * <p>
 * 给定一个M*N的矩阵（二维数组），分别用0和1表示通路和障碍物。
 * 即 0 表示 通路；1 表示 障碍物。从矩阵的左上角开始，每次只能向右，下，左，上移动位置，不能斜着走。请给出从入口到出口的路线。
 */
public class MazeProblem {

    static String path = "";        //记录实时路径

    static List<String> pathList = new ArrayList<>();      //使用 pathList 来记录每次过迷宫时的总路径

    static String shortPath = "";       //最短路径


    public static void main(String[] args) {
        int[][] map = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };

        int[][] map2 = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 0, 1, 1, 0, 1, 1, 0, 1, 0 },
                { 1, 0, 1, 0, 0, 1, 0, 0, 1, 0 },
                { 1, 0, 1, 0, 1, 0, 1, 0, 1, 0 },
                { 0, 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 0, 1, 1, 1, 1, 1, 1, 1, 0 },
                { 1, 0, 1, 0, 0, 1, 0, 0, 1, 0 },
                { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 }

        };

        int[][] maze = {         //迷宫矩阵
                {0, 0, 1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 0}
        };

        mazeDfs(map2, 0, 0);        //从 (0,0) 开始走

        if (pathList.isEmpty()){
            System.out.println("没有可到达路径！");
        }
        else {
            System.out.println("所有可到达通路：");
            for (String temp:pathList) {        //遍历 pathList 来取出所有可到达路径
                System.out.println(temp);
            }
            System.out.println("*******************************************************");

            shortPath = pathList.get(0);
            for (int i = 0; i < pathList.size(); i++) {         // pathList.get(i).length() - 1 即为该条路径字符串长度
                if (pathList.get(i).length() - 1 < shortPath.length() - 1){
                    shortPath = pathList.get(i);
                }
            }
            System.out.println("最短路径为：" + shortPath);

            System.out.println("*******************************************************");

            //切割路径，则总步数 = 切割数组长度 - 1
            String[] shortPath_split = shortPath.split("->");
            System.out.println("最短路径长为：" + (shortPath_split.length - 1));

            System.out.println("*******************************************************");


            System.out.println("打印所有最短路径：");
            for (int i = 0; i < pathList.size(); i++) {
                if (pathList.get(i).length() - 1 == shortPath.length() - 1){        //如果其他还有步数 == 最短路径的，也打印出来
                    System.out.println(pathList.get(i));

                }
            }


        }


    }

    /**
     * @param maze 二维矩阵迷宫
     * @param x    当前所在位置的 x 坐标
     * @param y    当前所在位置的 y 坐标
     */
    private static void mazeDfs(int[][] maze, int x, int y) {
        if (x < 0 || y < 0) {        //左上越界
            return;
        }
        if (x > maze.length - 1 || y > maze[0].length - 1) {        //右下越界
            return;
        }
        if (maze[x][y] == 1) {       //该位置有障碍物
            return;
        }
        if (x == maze.length - 1 && y == maze[0].length - 1) {       //到达终点
            path += "(" + x + "," + y + ")";
            pathList.add(path);
        }

        String temp = path;     //记录上次的路径，以便用于回溯。
        path += "(" + x + "," + y + ")" + "->";     //记录这次的路径
        maze[x][y] = 1;     //标记当前位置为已走

        mazeDfs(maze,x + 1,y);      //向右继续遍历
        mazeDfs(maze,x - 1,y);      //向左继续遍历
        mazeDfs(maze,x,y - 1);      //向下继续遍历
        mazeDfs(maze,x,y + 1);      //向上继续遍历

        //回溯
        path = temp;        //路径回溯
        maze[x][y] = 0;     //标记回溯
    }
}
