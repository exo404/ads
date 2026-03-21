package com.ads.sorting;

import com.ads.sorting.SortAlgorithm;
import com.ads.sorting.SortUtils;
import com.ads.sorting.SortUtilsRandomGenerator;
import java.util.Arrays;


/**
 * Generic Selection Sort algorithm.
 *
 * Selection sort repeatedly selects the minimum element from the unsorted portion of the array
 * and swaps it with the first unsorted element until the entire array is sorted.
 *
 * Time Complexity:
 * - Selection sort always requires O(n^2) comparisons
 * - Best case = Average case = Worst case = O(n^2)  
 *
 * Space Complexity: O(1) – in-place sorting
 *
 * @see SortAlgorithm
 */
class SelectionSort implements SortAlgorithm {
   
    /**
     * Sorts the given array using the Selection Sort algorithm.
     *
     * @param array The array to be sorted
     * @param <T>   The type of elements in the array, which must be comparable
     * @return The sorted array
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        return sort(array, 0, array.length);
    }

    /**
     * Sorts the given array using the Selection Sort algorithm
     * 
     * @param array The array to be sorted
     * @param <T> The type of elements in the array, which must be comparable
     * @param startIndex First index of the sub-array to be sorted
     * @param endIndex Last index of the sub-array to be sorted
     * @return The sorted array
     */
    public <T extends Comparable<T>> T[] sort(T[] array, int startIndex, int endIndex) {
        if (array == null || startIndex >= endIndex) {
            return array;
        }

        for (int i = startIndex; i < endIndex - 1; i++) {
            int min = i;
            for (int j = i + 1; j < endIndex; j++) {
                if (SortUtils.less(array[j], array[min])) {
                    min = j;
                }
            }
            SortUtils.swap(array, i, min);
        }

        return array;
    }

    /**
     * Main method to test the Selection Sort algorithm.
     *
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        final SelectionSort selectionSort = new SelectionSort();
        /**
         * Generates an array of random integers, converts each int to an Integer object,
         * and collects them into a new Integer array.
         *
         * <p>
         * - {@code SortUtilsRandomGenerator.generateIntArray(10, 100)} creates an array of 10 random integers,
         *   each in the range [0, 100).
         * - {@code Arrays.stream(...)} creates a stream from the generated int array.
         * - {@code .boxed()} converts each primitive int in the stream to an Integer object.
         * - {@code .toArray(Integer[]::new)} collects the stream elements into a new Integer array.
         * </p>
         *
         * @return a new Integer array containing 10 random values between 0 (inclusive) and 100 (exclusive)
         */
        final Integer[] randomArray = Arrays.stream(SortUtilsRandomGenerator.generateIntArray(10, 100))
                .boxed()
                .toArray(Integer[]::new);
        System.out.println("Original array:");
        SortUtils.print(randomArray);
        System.out.println("Sorted array");
        SortUtils.print(selectionSort.sort(randomArray));
    }


}
