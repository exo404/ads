package com.ads.search;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class providing common methods for search algorithms.
 */
final class SearchUtils {
    private SearchUtils() {
    }

    /**
     * Compares two elements to see if the first is less than the second.
     *
     * @param firstElement  the first element to compare
     * @param secondElement the second element to compare
     * @return true if the first element is less than the second, false otherwise
     */
    public static <T extends Comparable<T>> boolean less(T firstElement, T secondElement) {
        return firstElement.compareTo(secondElement) < 0;
    }

    /**
     * Compares two elements to see if the first is greater than the second.
     *
     * @param firstElement  the first element to compare
     * @param secondElement the second element to compare
     * @return true if the first element is greater than the second, false otherwise
     */
    public static <T extends Comparable<T>> boolean greater(T firstElement, T secondElement) {
        return firstElement.compareTo(secondElement) > 0;
    }

    /**
     * Compares two elements to see if the first is greater than or equal to the second.
     *
     * @param firstElement  the first element to compare
     * @param secondElement the second element to compare
     * @return true if the first element is greater than or equal to the second, false otherwise
     */
    static <T extends Comparable<T>> boolean greaterOrEqual(T firstElement, T secondElement) {
        return firstElement.compareTo(secondElement) >= 0;
    }

        /**
     * Compares two elements to see if the first is equal to the second.
     *
     * @param firstElement  the first element to compare
     * @param secondElement the second element to compare
     * @return true if the first element is  equal to the second, false otherwise
     */
    static <T extends Comparable<T>> boolean equal(T firstElement, T secondElement) {
        return firstElement.compareTo(secondElement) == 0;
    }

    /**
     * Prints the elements of an array to standard output.
     *
     * @param array the array to print
     */
    static <T> void print(T[] array) {
        System.out.println(Arrays.toString(array));
    }
}