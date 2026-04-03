package com.ads.matrix;

import java.util.Random;

/**
 * Utility class for generating random numbers and matrixs, specifically designed to assist with algorithms.
 * It provides methods to generate random double values in the range [0, 1) and random integers within a specified range.
 * The class uses a single instance of Random initialized with the current system time as the seed to ensure variability in generated values.
 */
public final class UtilsRandomGenerator {
    private UtilsRandomGenerator() {
    }

    private static final Random RANDOM;
    private static final long SEED;

    static {
        SEED = System.currentTimeMillis();
        RANDOM = new Random(SEED);
    }

    /**
     * Function to generate matrix of double values, with predefined size.
     *
     * @param r number of rows
     * @param c number of columns
     * @return matrix of Double values, randomly generated, each element is between [0, 1)
     */
    public static Double[][] generateDoubleMatrix(int r, int c) {
        Double[][] mat = new Double[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = generateDouble();
            }
        }
        return mat;
    }

    /**
     * Function to generate matrix of integer values, with predefined size.
     *
     * @param r number of rows
     * @param c number of columns
     * @return matrix of Integer values, randomly generated, each element is between [0, 1)
     */
    public static Integer[][] generateIntMatrix(int r, int c, int n) {
        Integer[][] mat = new Integer[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                mat[i][j] = generateInt(n);
            }
        }
        return mat;
    }

    /**
     * Function to generate Double value.
     *
     * @return Double value [0, 1)
     */
    public static Double generateDouble() {
        return RANDOM.nextDouble();
    }

    /**
     * Function to generate int value.
     *
     * @return int value [0, n)
     */
    public static int generateInt(int n) {
        return RANDOM.nextInt(n);
    }
}