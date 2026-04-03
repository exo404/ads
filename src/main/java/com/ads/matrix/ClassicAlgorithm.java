package com.ads.matrix;

import com.ads.matrix.Utils;
import com.ads.matrix.UtilsRandomGenerator;
import com.ads.matrix.MatrixProductAlgorithm;

/**
 * Matrix product base algorithm
 * 
 * This class provides methods for the base version of the
 * matrix product algorithm.
 * 
 * Time Complexity:
 *  O(n^3)
 *
 * Space Complexity: 
 *  O(1) 
 *  
 * @see MatrixProductAlgorithm
 */
class ClassicAlgorithm implements MatrixProductAlgorithm {

    @Override
    public Number[][] squareMatrixProduct(Number[][] A, Number[][] B) {
        return classicSquareProduct(A, B);
    }

    @Override
    public Number[][] matrixProduct(Number[][] A, Number[][] B){
        return classicProduct(A, B);
    }

    /**
     * Classic product algorithm method
     * 
     * @param A first factor (n,n)
     * @param B second factor (n,n)
     * @return The (n,n) matrix containing the product AB 
     */
    public static Number[][] classicSquareProduct(Number[][] A, Number[][] B) {
        if (A.length != A[0].length || B.length != B[0].length || A.length != B.length) {
            throw new IllegalArgumentException("Matrices must be square and of the same size");
        }

        int n = A.length;
        Number[][] C = new Number[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = 0;
                for (int k = 0; k < n; k++){
                    C[i][j] = Utils.add(C[i][j], Utils.multiply(A[i][k], B[k][j]));
                }
            }
        }

        return C;
    }

        /**
     * Classic product algorithm method
     * 
     * @param A first factor (r,n)
     * @param B second factor (n,c)
     * @return The (r,c) matrix containing the product AB 
     */
    public static Number[][] classicProduct(Number[][] A, Number[][] B) {
        if (A[0].length != B.length) {
            throw new IllegalArgumentException("Incompatible matrix dimensions");
        }
        int r = A.length;
        int n = A[0].length;
        int c = B[0].length;
        Number[][] C = new Number[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                C[i][j] = 0;
                for (int k = 0; k < n; k++){
                    C[i][j] = Utils.add(C[i][j], Utils.multiply(A[i][k], B[k][j]));
                }
            }
        }

        return C;
    }

    public static void main (String[] args) {
        ClassicAlgorithm matrixProduct = new ClassicAlgorithm();
        int n = UtilsRandomGenerator.generateInt(5);
        int r = UtilsRandomGenerator.generateInt(5);
        int c = UtilsRandomGenerator.generateInt(5);

        Integer[][] A = UtilsRandomGenerator.generateIntMatrix(n, n, 10);
        Integer[][] B = UtilsRandomGenerator.generateIntMatrix(n, n, 10);
        Integer[][] C = UtilsRandomGenerator.generateIntMatrix(r, n, 10);
        Integer[][] D = UtilsRandomGenerator.generateIntMatrix(n, c, 10);
            
        Utils.print(A);
        System.out.println();
        Utils.print(B);
        System.out.println();
        Utils.print(matrixProduct.squareMatrixProduct(A, B));
        System.out.println();
        Utils.print(C);
        System.out.println();
        Utils.print(D);
        System.out.println();
        Utils.print(matrixProduct.matrixProduct(C, D));
    }
}