package com.yb.lqb.ninelqb;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 标题：复数幂

 设i为虚数单位。对于任意正整数n，(2+3i)^n 的实部和虚部都是整数。
 求 (2+3i)^123456 等于多少？ 即(2+3i)的123456次幂，这个数字很大，要求精确表示。



 答案写成 "实部±虚部i" 的形式，实部和虚部都是整数（不能用科学计数法表示），中间任何地方都不加空格，实部为正时前面不加正号。(2+3i)^2 写成: -5+12i，
 (2+3i)^5 的写成: 122-597i


 注意：需要提交的是一个很庞大的复数，不要填写任何多余内容。

 */

/**
 * 考察 java 大数据的存储和计算
 *      BigInteger：大整形数据。
 *      BigDecimal：大浮点型。
 *
 *      创建 BigInteger 或 BigDecimal 需要 new 出来。
 *
 *      常用方法：
 *          1.add();            相加
 *          2.subtract();       相减
 *          3.multiply();       相乘
 *          4.divide();         相除取整
 *          5.remainder();      取余
 *          6.pow();            a.pow(b)=a^b
 *          7.gcd();            最大公约数
 *          8.abs();            绝对值
 *          9.negate();        取反数
 *          10.max(); min();    最大值，最小值。
 */
public class Demo03 {
    public static void main(String[] args) {

        BigInteger[] arry = caul();
        System.out.println(arry[0] + "" + arry[1]);

    }

    public static BigInteger[] caul(){

        BigInteger a = new BigInteger("2");     //实部
        BigInteger b = new BigInteger("3");     //虚部


        BigInteger temp_a = new BigInteger("2");     //存储第 i 次时的 a、b值
        BigInteger temp_b = new BigInteger("3");

        for (int i = 2; i <= 123456; i++) {
            BigInteger c = temp_a;    //存储第 i-1 次的 a、b值
            BigInteger d = temp_b;

            // temp_a = a * temp_a - b * temp_b
            temp_a = (a.multiply(temp_a)).subtract(b.multiply(temp_b));       //第 i 次的 a、b值

            // temp_b = 2 * d + 3 *c
            temp_b = (d.multiply(a)).add(c.multiply(b));
        }

        BigInteger[] arry = new BigInteger[2];
        arry[0] = temp_a;
        arry[1] = temp_b;
        return arry;
    }
}

