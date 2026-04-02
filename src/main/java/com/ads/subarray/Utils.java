package com.ads.subarray;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    public static <T extends Comparable<T>> boolean less(T firstElement, T secondElement){
        return firstElement.compareTo(secondElement) < 0;
    }

    /**
     * Comparse two elements and returns true if the first element is greater than the second element
     * @param firstElement  the first element to compare
     * @param secondElement the second element to compare
     * @return true if the first element is greater than the second, false otherwise
     */
    public static <T extends Comparable<T>> boolean greater(T firstElement, T secondElement){
        return firstElement.compareTo(secondElement) > 0;
    }

    /**
     * Comparse two elements and returns true if the first element is greater or equal than the second element
     * @param firstElement  the first element to compare
     * @param secondElement the second element to compare
     * @return true if the first element is greater or equal than the second, false otherwise
     */
    public static <T extends Comparable<T>> boolean greaterOrEqual(T firstElement, T secondElement){
        return firstElement.compareTo(secondElement) >= 0;
    }

    /**
     * Comparse two elements and returns true if the first element is equal to the second element
     * @param firstElement  the first element to compare
     * @param secondElement the second element to compare
     * @return true if the first element is equal to the second, false otherwise
     */
    public static <T extends Comparable<T>> boolean equal(T firstElement, T secondElement){
        return firstElement.compareTo(secondElement) == 0;
    }

    /**
     * Print the element of an array to the standard output
     * @param array The array to print 
     */
    public static <T> void print(T[] array){
        System.out.println(Arrays.toString(array));
    }

    public static <T> void results(Map<String, T> map){
        System.out.println("maxL" + " " + map.get("maxL").toString());
        System.out.println("maxR" + " " + map.get("maxR").toString());
        System.out.println("maxSum" + " " + map.get("maxSum").toString());
    }
}