import java.util.Vector;

public class Test {
    @org.junit.Test
    public void test01(){
        System.out.println((char) (0 + 'A'));
        System.out.println(6 & 1); // & 运算会将两边数字转化为 二进制进行与运算
        System.out.println(!false);
        System.out.println(Math.pow(2,3));
    }

    @org.junit.Test
    public void test02(){
        String s = "1234567";
        int[] arry = new int[s.length()];
        for (int j = 0; j <s.length() ; j++) {
            String s1 = s.substring(j, j + 1);
            int i1 = Integer.parseInt(s1);
            arry[j] = i1;
        }
        for (int temp:arry) {
            System.out.println(temp);
        }
    }

    @org.junit.Test
    public void test03(){
        double pow = Math.pow(0, 3);
        System.out.println(pow);
        System.out.println(1/10);
    }

    @org.junit.Test
    public void test04(){
        double a = 11.0/13;
        System.out.println(a);
    }

    /**
     * vector 测试
     */
    @org.junit.Test
    public void test05(){
        Vector<Object> vector = new Vector<>();
        for (int i = 0; i < 6; i++) {
            vector.add(i);
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(vector.indexOf(i));
        }
        int i = vector.indexOf(12);
        System.out.println(i);  //vector 中没有时返回 -1
    }

    /**
     * 排序测试
     */
    @org.junit.Test
    public void test06(){
        int[] a = {10,27};
        sort(a);
        for (int temp:a) {
            System.out.println(temp);
        }
    }

    //排序
    public void sort(int[] a){
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if (a[i] > a[j]){
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
}
