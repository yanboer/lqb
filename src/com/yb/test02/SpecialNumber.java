package com.yb.test02;

public class SpecialNumber {
    public static void main(String[] args) {

        for (int i = 100; i < 1000; i++) {
            int a = i/100;
            int b = (i - a*100)/10;
            int c = i - a*100 - b*10;
            if (Math.pow(a,3) + Math.pow(b,3) + Math.pow(c,3) == i){
                System.out.println(i);
            }
        }
    }
}
