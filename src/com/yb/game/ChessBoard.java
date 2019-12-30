package com.yb.game;

/**
 * 残缺棋盘问题
 */
public class ChessBoard {
    int[][] chessBoard = null;        //代表整个大棋盘

    int color = 1;      //L 型骨牌编号

    public ChessBoard(int n) {       //构造函数初始化棋盘大小 ，n 必须是 2 的幂数次方
        chessBoard = new int[n][n];
    }


    /**
     * 棋盘分割
     *
     * @param chessBoard 棋盘
     * @param l1         左上角的第一个下标
     * @param l2         左上角的第二个下标
     * @param special1   特殊格子的第一个下标
     * @param special2   特殊格子的第二个下标
     * @param size       棋盘大小
     */
    public void partition(int[][] chessBoard, int l1, int l2, int special1, int special2, int size) {

        int midel = size / 2;
        if (midel == 0) {
            return;
        } else {
            //特殊方格在左上棋盘
            int t = color++;
            if (special1 < l1 + midel && special2 < l2 + midel) {
                partition(chessBoard, l1, l2, special1, special2, midel);       //左上角的棋盘
            } else {      //将右下角的方格视为特殊方格
                chessBoard[l1 + midel - 1][l2 + midel - 1] = t;
                //左上角的棋盘
                partition(chessBoard, l1, l2, l1 + midel - 1, l2 + midel - 1, midel);
            }

            //特殊方格在左下棋盘
            if (l1 + midel <= special1 && special2 < l2 + midel) {
                partition(chessBoard, l1 + midel, l2, special1, special2, midel);    //左下角的棋盘
            } else {      //将右上角的方格视为特殊方格
                chessBoard[l1 + midel][l2 + midel - 1] = t;
                //左下角的棋盘
                partition(chessBoard, l1 + midel, l2, l1 + midel, l2 + midel - 1, midel);
            }

            //特殊方格在右上棋盘
            if (special1 < l1 + midel && l2 + midel <= special2) {
                partition(chessBoard, l1, l2 + midel, special1, special2, midel);    //右上角的棋盘
            } else {      //将左下角的方格视为特殊方格
                chessBoard[l1 + midel - 1][l2 + midel] = t;
                //右上角的棋盘
                partition(chessBoard, l1, l2 + midel, l1 + midel - 1, l2 + midel, midel);    //右上角的棋盘
            }

            //特殊方格在右下棋盘
            if (l1 + midel <= special1 && l2 + midel <= special2) {
                partition(chessBoard, l1 + midel, l2 + midel, special1, special2, midel);  //右下角的棋盘
            } else {      //将左上角的方格视为特殊方格
                chessBoard[l1 + midel][l2 + midel] = t;
                //右下角的棋盘
                partition(chessBoard, l1 + midel, l2 + midel, l1 + midel, l2 + midel, midel);  //右下角的棋盘
            }
        }
    }

    public static void main(String[] args) {

        ChessBoard chessBoard = new ChessBoard(8);      //8X8棋盘
        chessBoard.partition(chessBoard.chessBoard, 0, 0, 1, 1, 8);
        for (int i = 0; i < chessBoard.chessBoard.length; i++) {
            for (int j = 0; j < chessBoard.chessBoard.length; j++) {
                System.out.printf("%4d", chessBoard.chessBoard[i][j]);
            }
            System.out.println();
        }
        System.out.println("总共需要 L 型骨牌个数为： " + (chessBoard.color-1));
    }
}
