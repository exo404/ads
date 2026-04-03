package com.ads.matrix;

import java.util.Arrays;

/**
 * Utility class providing common methods for the subarray class problems
 */
final class Utils {

    private Utils(){
    }

    /**
     * Comparse two elements and returns true if the first element is less than the second element
     * @param firstElement  the first element to compare
     * @param secondElement the second element to compare
     * @return true if the first element is less than the second, false otherwise
     */
    public static <Number extends Comparable<Number>> boolean less(Number firstElement, Number secondElement){
        return firstElement.compareTo(secondElement) < 0;
    }

    /**
     * Comparse two elements and returns true if the first element is greater than the second element
     * @param firstElement  the first element to compare
     * @param secondElement the second element to compare
     * @return true if the first element is greater than the second, false otherwise
     */
    public static <Number extends Comparable<Number>> boolean greater(Number firstElement, Number secondElement){
        return firstElement.compareTo(secondElement) > 0;
    }

    /**
     * Comparse two elements and returns true if the first element is greater or equal than the second element
     * @param firstElement  the first element to compare
     * @param secondElement the second element to compare
     * @return true if the first element is greater or equal than the second, false otherwise
     */
    public static <Number extends Comparable<Number>> boolean greaterOrEqual(Number firstElement, Number secondElement){
        return firstElement.compareTo(secondElement) >= 0;
    }

    /**
     * Comparse two elements and returns true if the first element is equal to the second element
     * @param firstElement  the first element to compare
     * @param secondElement the second element to compare
     * @return true if the first element is equal to the second, false otherwise
     */
    public static <Number extends Comparable<Number>> boolean equal(Number firstElement, Number secondElement){
        return firstElement.compareTo(secondElement) == 0;
    }

    /**
     * Print the elements of a matrix to the standard output
     * @param matrix The matrix to print 
     */
    public static <Number> void print(Number[][] matrix){
        for (Number[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    /**
     * Multiply method for the Number class
     * 
     * @param a first number
     * @param b second number
     */
    public static Number multiply(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            return a.doubleValue() * b.doubleValue();
        }
        if (a instanceof Float || b instanceof Float) {
            return a.floatValue() * b.floatValue();
        }
        if (a instanceof Long || b instanceof Long) {
            return a.longValue() * b.longValue();
        }
        return a.intValue() * b.intValue();
    }

    /**
     * Add method for the Number class
     * 
     * @param a first number
     * @param b second number
     */
    public static Number add(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            return a.doubleValue() + b.doubleValue();
        }
        if (a instanceof Float || b instanceof Float) {
            return a.floatValue() + b.floatValue();
        }
        if (a instanceof Long || b instanceof Long) {
            return a.longValue() + b.longValue();
        }
        return a.intValue() + b.intValue();
    }
}