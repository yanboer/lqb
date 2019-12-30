package com.yb.lqb.sixlqb;

/**
 *
 立方变自身

 观察下面的现象,某个数字的立方，按位累加仍然等于自身。
 1^3 = 1
 8^3  = 512    5+1+2=8
 17^3 = 4913   4+9+1+3=17
 ...

 请你计算包括1,8,17在内，符合这个性质的正整数一共有多少个？

 请填写该数字，不要填写任何多余的内容或说明性的文字。

 */
public class Demo02 {
    static int sum = 0;        //保存一共多少个这样的数字
    public static void main(String[] args) {
        findNumber();
        System.out.println("共有" + sum + "种解法");
    }

    private static void findNumber() {
        for (int i = 1; i < 100000; i++) {
            long i_pow = i*i*i;
            int b = 0;
            while (i_pow != 0){
                b += i_pow%10;        //从低位开始计算 i_pow 的各个位数值
                i_pow = i_pow/10;
            }

            if (i == b){
                sum++;
            }
        }
    }

    /**
     * 判断 i^3 的 各个位数之和是否 = i
     */
//    public static boolean checkNumber(int i,long pow){
//        int a = i;      //数字本身
//        String s = String.valueOf(pow);
//        int[] arry = new int[s.length()];
//        for (int j = 0; j <s.length() ; j++) {
//            String s1 = s.substring(j, j + 1);
//            int i1 = Integer.parseInt(s1);
//            arry[j] = i1;
//        }
//
//        int b = 0;      //数字的立方和
//        for (int temp:arry) {
//            b +=temp;
//        }
//
//        if (a == b){
//            return true;
//        }
//        return false;
//    }
}


