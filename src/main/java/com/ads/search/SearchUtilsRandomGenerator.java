package com.ads.search;

import java.util.Random;

/**
 * Utility class for generating random numbers and arrays, specifically designed to assist with search algorithms.
 * It provides methods to generate random double values in the range [0, 1) and random integers within a specified range.
 * The class uses a single instance of Random initialized with the current system time as the seed to ensure variability in generated values.
 */
public final class SearchUtilsRandomGenerator {
    private SearchUtilsRandomGenerator() {
    }

    private static final Random RANDOM;
    private static final long SEED;

    static {
        SEED = System.currentTimeMillis();
        RANDOM = new Random(SEED);
    }

    /**
     * Function to generate array of double values, with predefined size.
     *
     * @param size result array size
     * @return array of Double values, randomly generated, each element is between [0, 1)
     */
    public static Double[] generateDoubleArray(int size) {
        Double[] arr = new Double[size];
        for (int i = 0; i < size; i++) {
            arr[i] = generateDouble();
        }
        return arr;
    }

    /**
     * Function to generate array of int values, with predefined size and upper bound.
     *
     * @param size result array size
     * @param n upper bound for generated int values (exclusive)
     * @return array of int values, randomly generated, each element is between [0, n)
     */
    public static int[] generateIntArray(int size, int n) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = generateInt(n);
        }
        return arr;
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