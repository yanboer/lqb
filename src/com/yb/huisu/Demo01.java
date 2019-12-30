package com.yb.huisu;

/**
 * 有多个货箱，它们的重量分别是【 w1, w2, w3, ······,wn】,货船的最大载重为W，设计方法，使货船能装上尽量多的货箱。
 */
public class Demo01 {

    static int WEIGHT = 10;      //货船最大载重量
    static int[] w = new int[]{8, 6, 4, 2};    //

    static int currentWeight = 0; //当前货船重量

    public static void dfs(int n) {
        if (n > 4) {
            System.out.println(currentWeight);
        } else {
            for (int i = 0; i < 4; i++) {
                if (currentWeight < WEIGHT) {
                    currentWeight += w[i];
                    dfs(n + 1);
                }
                currentWeight -= w[i];
            }
        }
    }

    public static void main(String[] args) {
        dfs(1);
    }
}
