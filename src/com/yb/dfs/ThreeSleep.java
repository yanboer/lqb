package com.yb.dfs;

/**
 * 三羊献瑞
 * <p>
 * 观察下面的加法算式：
 * <p>
 *      祥 瑞 生 辉                                 a[2] a[4] a[3] a[7]
 * +    三 羊 献 瑞             =========》  +      a[0] a[1] a[6] a[4]
 * -------------------                      --------------------------
 *   三 羊 生 瑞 气                            a[0] a[1] a[3] a[4] a[5]
 * <p>
 * (如果有对齐问题，可以参看【图1.jpg】)
 * <p>
 * 其中，相同的汉字代表相同的数字，不同的汉字代表不同的数字。
 * <p>
 * 请你填写“三羊献瑞”所代表的4位数字（答案唯一），不要填写任何多余内容。
 */

/**
 * 三、羊、祥、生、瑞、气、献、辉  -----》一共八个字(不能重复)
 * <p>
 * "三"  = 1;
 * "祥" = 9;
 * "羊" = 0;
 */
public class ThreeSleep {
    static int[] number = new int[8];       //存储前八个字代表的数字
    static boolean[] color = new boolean[10];       //标记十个数字的访问情况

    public static void main(String[] args) {
        dfs(0);
    }

    public static void dfs(int n) {
        if (n == 8) {        // 0~7 凑够八个数字
            if (checkNum(number)) {
                System.out.println(number[0]+""+number[1]+""+number[6]+""+number[4]);
            }
        } else {
            for (int i = 0; i < 10; i++) {
                if (n == 0 && i != 1){      // '三' = 1
                    continue;
                }
                if (n == 1 && i != 0){      //'羊' = 0
                    continue;
                }
                if (n == 2 && i != 9){      // '祥' =9
                    continue;
                }
                if (!color[i]) {
                    color[i] = true;        //标记
                    number[n] = i;
                    dfs(n + 1);
                    color[i] = false;      //回溯
                }
            }
        }
    }

    /*
    true：满足条件
    false：不满足条件
     */
    public static boolean checkNum(int[] number) {
        int a = number[2] * 1000 + number[4] * 100 + number[3] * 10 + number[7];
        int b = number[0] * 1000 + number[1] * 100 + number[6] * 10 + number[4];
        int c = number[0] * 10000 + number[1] * 1000 + number[3] * 100 + number[4] * 10 + number[5];
        if (c == (a + b)) {
            return true;
        } else {
            return false;
        }
    }
}
