package com.yb.game;

/**
 * Strassen 矩阵乘法：
 *
 *      A * B = C
 *
 *      M1 = A11*(B12 -B22)
 *      M2 = (A11 + A12)*B22
 *      M3 = (A21 + A22)*B11
 *      M4 = A22*(B21-B11)
 *      M5 = (A11 + A22)*(B11 + B22)
 *      M6 = (A12 - A22)*(B21 + B22)
 *      M7 = (A11 - A21)*(B11 + B12)
 *
 *
 *      C11 = M5 + M4 - M2 + M6
 *      C12 = M1 + M2
 *      C21 = M3 + M4
 *      C22 = M5 + M1 -M3 -M7
 */
public class Strassen {

    /**
     *
     * @param a         矩阵 A
     * @param a1        矩阵 A 的左上角第一个下标
     * @param a2        矩阵 A 的左上角第二个下标
     * @param a_row     矩阵 A 的行数
     * @param a_column  矩阵 A 的列数
     * @param b         矩阵 B
     * @param b1        矩阵 B 的左上角第一个下标
     * @param b2        矩阵 B 的左上角第二个下标
     * @param b_row     矩阵 B 的行数
     * @param b_column  矩阵 B 的列数
     *
     *
     *        M1 = A11*(B12 -B22)
     *        M2 = (A11 + A12)*B22
     *        M3 = (A21 + A22)*B11
     *        M4 = A22*(B21-B11)
     *        M5 = (A11 + A22)*(B11 + B22)
     *        M6 = (A12 - A22)*(B21 + B22)
     *        M7 = (A11 - A21)*(B11 + B12)
     */
    public int[][] matrix_Multi(int[][] a,int a1,int a2,int a_row,int a_column,int[][] b,int b1,int b2,int b_row,int b_column){


        // A11 * B12 - A11 * B22
        int[][] A11_and_B12 = matrix_Multi(a,a1,a2,a_row/2,a_column/2,b,b1,b2+b_column/2,b_row/2,b_column/2);
        int[][] A11_and_B22 = matrix_Multi(a,a1,a2,a_row/2,a_column/2,b,b1 + b_row/2,b2 + b_column/2,b_row/2,b_column/2);
        int[][] A12_and_B22 = matrix_Multi(a,a1,a2 + a_column/2,a_row/2,a_column/2,b,b1 + b_row/2,b2 + b_column/2,b_row/2,b_column/2);
        int[][] A21_and_B11 = matrix_Multi(a,a1 + a_row/2,a2,a_row/2,a_column/2,b,b1,b2,b_row/2,b_column/2);
        int[][] A22_and_B11 = matrix_Multi(a,a1 + a_row/2,a2 + a_column/2,a_row/2,a_column/2,b,b1,b2,b_row/2,b_column/2);
        int[][] A22_and_B21 = matrix_Multi(a,a1 + a_row/2,a2 + a_column/2,a_row/2,a_column/2,b,b1 + b_row/2,b2,b_row/2,b_column/2);
        int[][] A11_and_B11 = matrix_Multi(a,a1,a2,a_row,a_column,b,b1,b2,b_row,b_column);
        int[][] A22_and_B22 = matrix_Multi(a,a1 + a_row/2,a2 + a_column/2,a_row/2,a_column/2,b,b1 + b_row/2,b2 + b_column/2,b_row/2,b_column/2);



        int[][] M1 = matrix_Minus(A11_and_B12,A11_and_B22);


//        int[][] A12 = matrix_Minus(a,a1,a2+a_column/2,a_row/2,a_column/2,)

        if (a1 == 1 || a2 ==1 || b1 ==1 || b2 ==1){

        }
        else {

        }

        return null;
    }

    //矩阵相减
    public int[][] matrix_Minus(int[][] a,int[][] b){
        int c[][] = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }

    public static void main(String[] args) {

    }
}
