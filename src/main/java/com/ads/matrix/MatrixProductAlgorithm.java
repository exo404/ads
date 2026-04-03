package com.ads.matrix;

import java.util.Arrays;
import com.ads.matrix.Utils;
import com.ads.matrix.UtilsRandomGenerator;

/**
 * Matrix product common algorithm interface 
 */
public interface MatrixProductAlgorithm {

    /**
     * Main method for square matrix products
     * 
     * @param A first factor (n,n)
     * @param B second factor (n,n)
     * @return the (n,n) matrix containing the product AB 
     */
     Number[][] squareMatrixProduct(Number[][] A, Number[][] B);

    /**
     * Main method for generic matrix products
     * 
     * @param A first factor (r, n)
     * @param B second factor (n, c)
     * @return the (r,c) matrix containing the product AB 
     */
    Number[][] matrixProduct(Number[][] A, Number[][] B);
}