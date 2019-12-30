package com.yb.queen;

/**
 * 八皇后问题    ------------》暴力破解
 */
public class QueenInViolence {

    static int[] queenSite = new int[9];

    static int sum = 0; //记录解数

    /**
     * 判断第 i、j 行是否冲突
     * return true: 冲突
     * retuen false：不冲突
     *
     * @param i
     * @param j
     * @return
     */
    public static boolean checkQueenSite(int i, int j) {
        if (queenSite[i] == queenSite[j] || (Math.abs(i - j) == Math.abs(queenSite[i] - queenSite[j]))) {  //冲突
            return true;
        }
        return false;
    }

    public static void jie() {
        for (int i = 0; i < 8; i++) {                               //1行
            queenSite[1] = i;
            for (int j = 0; j < 8; j++) {                           //2行
                queenSite[2] = j;
                for (int k = 0; k < 8; k++) {                       //3行
                    queenSite[3] = k;
                    for (int l = 0; l < 8; l++) {                   //4行
                        queenSite[4] = l;
                        for (int m = 0; m < 8; m++) {               //5行
                            queenSite[5] = m;
                            for (int n = 0; n < 8; n++) {           //6行
                                queenSite[6] = n;
                                for (int o = 0; o < 8; o++) {       //7行
                                    queenSite[7] = o;
                                    for (int p = 0; p < 8; p++) {   //8行
                                        queenSite[8] = p;

                                        for (int q = 1; q < 9; q++) {    //冲突判断
                                            for (int r = 1; r < 9; r++) {
                                                if (q != r) {
                                                    if (queenSite[q] == queenSite[r] || checkQueenSite(q, r)) {
                                                        continue;
                                                    } else sum++;
                                                }
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        jie();
        System.out.println("总解数为：" + sum);
    }
}
