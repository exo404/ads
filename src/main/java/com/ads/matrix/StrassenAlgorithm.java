package com.ads.matrix;

import com.ads.matrix.Utils;
import com.ads.matrix.UtilsRandomGenerator;
import com.ads.matrix.MatrixProductAlgorithm;

/**
 * Generic Strassen algorithm
 * 
 * Adds an O(n^2) matrix construction phase before jumping into classic recursion 
 * 
 * Time Complexity:
 *  O(n^log7)
 * 
 * Space Complexity:
 *  O(n^2)
 * 
 * @see MatrixProductAlgorithm
 */
class StrassenAlgorithm implements MatrixProductAlgorithm {

    @Override
    public Number[][] squareMatrixProduct(Number[][] A, Number[][] B) {
        return strassenProduct(A, B);
    }

    @Override
    public Number[][] matrixProduct(Number[][] A, Number[][] B) {
        return strassenProduct(A, B);
    }

    /**
     * Strassen method to compute two the product of two matrices
     * 
     * @param A first matrix to multiply
     * @param B second matrix to multiply
     * @param C the product matrix
     */
    public static Number[][] strassenProduct (Number[][] A, Number[][] B) {
        int n = A.length;

        Number[][] C = new Number[n][n];

        if (n == 1) {
            C[0][0] = Utils.multiply(A[0][0], B[0][0]); 
        }
        else {
            Number[][] A11 = new Number[n][n];
            Number[][] A12 = new Number[n][n];
            Number[][] A21 = new Number[n][n];
            Number[][] A22 = new Number[n][n];         
            Number[][] B11 = new Number[n][n];
            Number[][] B12 = new Number[n][n];
            Number[][] B21 = new Number[n][n];
            Number[][] B22 = new Number[n][n];

            split(A, A11, 0, 0);
            split(A, A12, 0, n/2);
            split(A, A21, n/2, 0);
            split(A, A22, n/2, n/2);
            split(B, B11, 0, 0);
            split(B, B12, 0, n/2);
            split(B, B21, n/2, 0);
            split(B, B22, n/2, n/2);

            Number[][] S1 = sub(B12, B22);
            Number[][] S2 = add(A11, A12);
            Number[][] S3 = add(A21, A22);
            Number[][] S4 = sub(B21, B11);
            Number[][] S5 = add(A11, A22);
            Number[][] S6 = add(B11, B22);
            Number[][] S7 = sub(A12, A22);
            Number[][] S8 = add(B21, B22);
            Number[][] S9 = sub(A11, A21);
            Number[][] S10 = add(B11, B12);

            Number[][] P1 = strassenProduct(A11, S1);
            Number[][] P2 = strassenProduct(S2, B22);
            Number[][] P3 = strassenProduct(S3, B11);
            Number[][] P4 = strassenProduct(A22, S4);
            Number[][] P5 = strassenProduct(S5, S6);
            Number[][] P6 = strassenProduct(S7, S8);
            Number[][] P7 = strassenProduct(S9, S10);

            Number[][] C11 = add(sub(add(P5, P4), P2), P6);
            Number[][] C12 = add(P1, P2);
            Number[][] C21 = add(P3, P4);
            Number[][] C22 = sub(sub(add(P5, P1), P3), P7);

            join(C11, C, 0, 0);
            join(C12, C, 0, n/2);
            join(C21, C, n/2, 0);
            join(C22, C, n/2, n/2);
        }

        return C;
    }


    /**
     * Function to sum two matrices
     * 
     * @param A first matrix
     * @param B second matrix
     */
    public static Number[][] add(Number[][] A, Number[][] B) {
        int n = A.length;
        Number[][] C = new Number[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = Utils.add(A[i][j], B[i][j]);
            }
        }

        return C;
    }

    /**
     * Function to subtract two matrices
     * 
     * @param A first matrix
     * @param B second matrix
     */
    public static Number[][] sub(Number[][] A, Number[][] B) {
        int n = A.length;
        Number[][] C = new Number[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = Utils.sub(A[i][j], B[i][j]);
            }
        }

        return C;       
    }

    /**
     * Function to split parent matrix into child matrices
     * 
     * @param P parent matrix
     * @param C child matrix
     */
    public static void split(Number[][] P, Number[][] C, int startRow, int startColumn) {
        int n = C.length;
        
        for (int iC = 0, iP = startRow; iC < n; iP++, iC++) {
            for (int jC = 0, jP = startColumn; jC < n; jP++, jC++) {
                C[iP][jP] = P[iC][jC];  
            }   
        }
    }

    /**
     * Function to join child matrix into parent matrices
     * 
     * @param P parent matrix
     * @param C child matrix
     */
    public static void join(Number[][] C, Number[][] P, int startRow, int startColumn) {
        int n = C.length;
        
        for (int iC = 0, iP = startRow; iC < n; iP++, iC++) {
            for (int jC = 0, jP = startColumn; jC < n; jP++, jC++) {
                P[iP][jP] = C[iC][jC];  
            }   
        }
    }

    public static void main (String[] args) {
        ClassicAlgorithm matrixProduct = new ClassicAlgorithm();
        int n = UtilsRandomGenerator.generateInt(5);

        Integer[][] A = UtilsRandomGenerator.generateIntMatrix(n, n, 10);
        Integer[][] B = UtilsRandomGenerator.generateIntMatrix(n, n, 10);
            
        Utils.print(A);
        System.out.println();
        Utils.print(B);
        System.out.println();
        Utils.print(matrixProduct.squareMatrixProduct(A, B));
    }
    
}