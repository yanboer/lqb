package com.yb.lqb.sevenlqb;

/**
 * 生日蜡烛
 * <p>
 * 某君从某年开始每年都举办一次生日party，并且每次都要吹熄与年龄相同根数的蜡烛。
 * <p>
 * 现在算起来，他一共吹熄了236根蜡烛。
 * <p>
 * 请问，他从多少岁开始过生日party的？
 * <p>
 * 请填写他开始过生日party的年龄数。 注意：你提交的应该是一个整数，不要填写任何多余的内容或说明性文字。
 * 
 * 
 * 等差数列求和： i：开始年龄 j：现在年龄 ((i+j)*(j-i+1)) /2
 */
public class Demo02 {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            for (int j = i; j < 100; j++) {
                if (((i + j) * (j - i + 1)) / 2 == 236) { // 等差数列的求和公式
                    System.out.println("开始吹蜡烛的年龄为" + i);
                }
            }
        }

    }
}
