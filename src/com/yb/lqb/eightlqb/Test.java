package com.yb.lqb.eightlqb;

public class Test {

    @org.junit.Test
    public void test(){
        String s1 ="abcdkkk";
        String s2 ="baabcdadabc";
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        for (char temp:c1) {
            System.out.println(temp);
        }
        System.out.println("=================");
        for (char temp:c2) {
            System.out.println(temp);
        }
    }
}
