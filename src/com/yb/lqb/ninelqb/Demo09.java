package com.yb.lqb.ninelqb;

import java.util.Scanner;

/**
 * 标题：全球变暖
 * <p>
 * 你有一张某海域NxN像素的照片，"."表示海洋、"#"表示陆地，如下所示：
 * <p>
 * .......
 * .##....
 * .##....
 * ....##.
 * ..####.
 * ...###.
 * .......
 * <p>
 * 其中"上下左右"四个方向上连在一起的一片陆地组成一座岛屿。例如上图就有2座岛屿。
 * <p>
 * 由于全球变暖导致了海面上升，科学家预测未来几十年，岛屿边缘一个像素的范围会被海水淹没。具体来说如果一块陆地像素与海洋相邻(上下左右四个相邻像素中有海洋)，
 * 它就会被淹没。
 * <p>
 * 例如上图中的海域未来会变成如下样子：
 * <p>
 * .......
 * .......
 * .......
 * .......
 * ....#..
 * .......
 * .......
 * <p>
 * 请你计算：依照科学家的预测，照片中有多少岛屿会被完全淹没。
 * <p>
 * 【输入格式】
 * 第一行包含一个整数N。  (1 <= N <= 1000)
 * 以下N行N列代表一张海域照片。
 * <p>
 * 照片保证第1行、第1列、第N行、第N列的像素都是海洋。
 * <p>
 * 【输出格式】
 * 一个整数表示答案。
 * <p>
 * 【输入样例】
 * 7
 * .......
 * .##....
 * .##....
 * ....##.
 * ..####.
 * ...###.
 * .......
 * <p>
 * 【输出样例】
 * 1
 * <p>
 * <p>
 * <p>
 * 资源约定：
 * 峰值内存消耗（含虚拟机） < 256M
 * CPU消耗  < 1000ms
 * <p>
 * <p>
 * 请严格按要求输出，不要画蛇添足地打印类似：“请您输入...” 的多余内容。
 * <p>
 * 所有代码放在同一个源文件中，调试通过后，拷贝提交该源码。
 * 不要使用package语句。不要使用jdk1.7及以上版本的特性。
 * 主类的名字必须是：Main，否则按无效代码处理。
 */
public class Demo09 {
    static int[][] maze;        //代表整个海域
    static boolean[][] color;

    static int N;       //代表海域的行列数

    static int sum = 0;     //记录未来的陆地个数

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = Integer.parseInt(sc.nextLine());        // N 行 N 列的海域
        maze = new int[N][N];
        color = new boolean[N][N];

        for (int i = 0; i < N; i++) {       //把 "." 和 "#" 转变为 0 和 1
            String s = sc.nextLine();

            for (int j = 0; j < N; j++) {
                if (s.substring(j, j + 1).equals(".")) {       //注意 "=" 不能用来进行字符串的比较
                    maze[i][j] = 0;
                } else if (s.substring(j,j+1).equals("#")){     // "#" 代表 1
                    maze[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze.length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                dfs(i, j, maze);
            }
        }
//        dfs(0, 0, maze);        //从 (0,0) 位置开始检索

        System.out.println("未来剩余岛屿数量 = " + sum);

    }

    private static void dfs(int x, int y, int[][] maze) {
        if (x < 0 || y < 0) {         //左上越界
            return;
        }
        if (x > maze.length - 1 || y > maze[0].length - 1) {         //右下越界
            return;
        }
        if (maze[x][y] == 0) {       //该位置为 海洋
            return;
        }
        if (color[x][y] == true){       //该位置走过
            return;
        }

        if (maze[x - 1][y] == 0 || maze[x + 1][y] == 0
                || maze[x][y - 1] == 0 || maze[x][y + 1] == 0) {         //如果该陆地 四个方向有一个是海洋
            return;
        }

        if (maze[x - 1][y] == 1 || maze[x + 1][y] == 1
                || maze[x][y - 1] == 1 || maze[x][y + 1] == 1) {         //如果该陆地 四个方向都是陆地
            sum++;
        }

//        color[x][y] = true;     //标记该位置走过
//
//        dfs(x + 1, y, maze);      //向右走
//        dfs(x - 1, y, maze);      //向左走
//        dfs(x, y - 1, maze);      //向上走
//        dfs(x, y + 1, maze);      //向下走
//
//        color[x][y] = false;     //回溯
    }
}
