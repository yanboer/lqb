package com.yb.lqb.sixlqb;

/**
 * 加法变乘法
 * <p>
 * 我们都知道：1+2+3+ ... + 49 = 1225
 * 现在要求你把其中两个不相邻的加号变成乘号，使得结果为2015
 * <p>
 * 比如：
 * 1+2+3+...+10*11+12+...+27*28+29+...+49 = 2015
 * 就是符合要求的答案。
 * <p>
 * 请你寻找另外一个可能的答案，并把位置靠前的那个乘号左边的数字提交（对于示例，就是提交10）。
 * <p>
 * 注意：需要你提交的是一个整数，不要填写任何多余的内容。
 */


/**
 * 2015 - 1225 = 790
 * <p>
 * 所以：a * b + c * d - a - b - c - d = 790 即可。
 * <p>
 * a * (a + 1) + b * (b + 1) - a - (a + 1) - b - (b + 1) = 790
 * <p>
 * 1 <= a < b <= 49            ====> 输出 a 即可
 */
public class Demo06 {
    static boolean[] color = new boolean[49];
    static int[] target = new int[2];       //选中两个数字

    public static void main(String[] args) {

        dfs(0);

    }

    private static void dfs(int n) {
        if (n == 2) {        //选中 2 个数字
            if (checkNumber(target)) {
                sort(target);
                System.out.println("a = " + target[0]);
                System.out.println("b = " + target[1]);
            }
        } else {
            for (int i = 0; i < 49; i++) {
                if (color[i] == false) { // 未访问过
                    color[i] = true; // 标记为访问过
                    target[n] = i + 1;
                    dfs(n + 1);
                    color[i] = false; // 回溯
                }
            }
        }
    }

    /**
     * 检查选中的数字是否满足条件
     *
     * @param target
     * @return
     */
    private static boolean checkNumber(int[] target) {
        int a = target[0];
        int b = target[1];
        if ((a * (a + 1) + b * (b + 1) - a - (a + 1) - b - (b + 1)) == 790) {
            return true;
        }
        return false;
    }

    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }


}
