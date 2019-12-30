/**
 * 1~9 九个数字全排列组成4位数字的个数(不能重复)
 */
public class Number {
    static int[] number = new int[10];
    static boolean[] color = new boolean[10];  //记录每个数字的情况

    static int sum = 0; //记录总解数

    public static void dfs(int n) {
        if (n == 5) {         // n=1,2,3,4 时分别取一个数
            sum++;
        } else {
            for (int i = 1; i < 10; i++) {
                if (!color[i]) {
                    color[i] = true;  //标记
                    number[n] = i;
                    dfs(n + 1);
                    color[i] = false; //回溯
                }
            }
        }
    }

    public static void main(String[] args) {
        dfs(1);
        System.out.println("总解数为：" + sum);
    }
}
