package com.yb.lqb.ninelqb;

public class Test {
    @org.junit.Test
    public void test01(){
        String s ="....##.";
        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.substring(i,i+1));
        }
    }
}
