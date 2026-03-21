package com.ads.sorting;

import com.ads.sorting.SortAlgorithm;
import com.ads.sorting.SortUtils;
import com.ads.sorting.SortUtilsRandomGenerator;
import java.util.Arrays; 
import java.util.List; 
import java.util.ArrayList;

/**
 * Generic Merge Sort algorithm.
 *
 * Standard merge use recursion to solve 2 sub-problems and merge the sorted sub-arrays.
 *
 * Time Complexity:
 * - Worst case: O(nlogn)
 *
 * @see SortAlgorithm
 */
public class MergeSort implements SortAlgorithm {

    /**
     * Sorts the given array using the Merge Sort algorithm.
     *
     * @param array The array to be sorted
     * @param <T>   The type of elements in the array, which must be comparable
     * @return The sorted array
     */
    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) {
        if (array == null){
            return array;
        }
        sort(array, 0, array.length-1);
        return array;
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
    public <T extends Comparable<T>> void sort(T[] array, int startIndex, int endIndex) {
        if (startIndex >= endIndex){
            return;
        }
        int midIndex = (endIndex + startIndex) / 2;
        sort(array, startIndex, midIndex);
        sort(array, midIndex + 1, endIndex);
        merge(array, startIndex, midIndex, endIndex);
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
    public <T extends Comparable<T>> void sortInversioni(T[] array, int startIndex, int endIndex, Integer[] inversioni) {
        if (startIndex >= endIndex){
            return;
        }
        int midIndex = (endIndex + startIndex) / 2;
        sortInversioni(array, startIndex, midIndex, inversioni);
        sortInversioni(array, midIndex + 1, endIndex, inversioni);
        inversioni(array, startIndex, midIndex, endIndex, inversioni);
    }

    /**
     * Merge 2 sorted sub-arrays 
     * 
     * @param <T> The type of elements in the array, which must be comparable
     * @param startIndex First index of the sub-array to be sorted
     * @param midIndex Index of the array middle element
     * @param endIndex Last index of the sub-array to be sorted
     */
    public <T extends Comparable<T>> void merge(T[] array, int startIndex, int midIndex, int endIndex) {
        int n1 = midIndex + 1 - startIndex;
        int n2 = endIndex - midIndex;
        List<T> L = new ArrayList<>(n1);
        List<T> R = new ArrayList<>(n2);
        int i, j;
        for (i = startIndex; i < midIndex + 1; i++){
            L.add(array[i]);
        }
        for (j = midIndex + 1; j <= endIndex; j++){
            R.add(array[j]);
        }

        i = 0; 
        j = 0;
        int k;
        for (k = startIndex; k <= endIndex; k++){
            if (i < L.size() && j < R.size()){
                if(SortUtils.less(L.get(i), R.get(j))){
                    array[k] = L.get(i);
                    i++;
                }else{
                    array[k] = R.get(j);
                    j++;
                }
            }
            else{
                break;
            }
        }  
        if (i >= n1 && j < n2) {
            while (j < n2) {
                array[k] = R.get(j);
                k++;
                j++;
            }
         } else if (j >= n2 && i < n1){
            while (i < n1) {
                array[k] = L.get(i);
                k++;
                i++;
            } 
        }
    }

    public <T extends Comparable<T>> void inversioni(T[] array, int startIndex, int midIndex, int endIndex, Integer[] inversioni){
        int n1 = midIndex + 1 - startIndex;
        int n2 = endIndex - midIndex;
        List<T> L = new ArrayList<>(n1);
        List<T> R = new ArrayList<>(n2);
        int i, j;
        for (i = startIndex; i < midIndex + 1; i++){
            L.add(array[i]);
        }
        for (j = midIndex + 1; j <= endIndex; j++){
            R.add(array[j]);
        }

        i = 0; 
        j = 0;
        int k;

        for (k = startIndex; k <= endIndex; k++){
            if (i < L.size() && j < R.size()){
                if(SortUtils.greater(L.get(i), R.get(j))){
                    array[k] = R.get(j);
                    j++;
                    inversioni[0] = inversioni[0] + (L.size()-i);
                }else{
                    array[k] = L.get(i);
                    i++;
                }
            }
            else{
                break;
            }
        }  
        if (i >= n1 && j < n2) {
            while (j < n2) {
                array[k] = R.get(j);
                k++;
                j++;
            }
         } else if (j >= n2 && i < n1){
            while (i < n1) {
                array[k] = L.get(i);
                k++;
                i++;
            } 
        }
    }
    
    /*
    public <T extends Comparable<T>> void optMerge(T[] array, int startIndex, int midIndex, int endIndex) {
        List<T> temp = new ArrayList<>(array);
        int i = startIndex;
        int j = midIndex + 1;
        for (int k = startIndex; k <= endIndex; k++){
            if (j > endIndex){
                array[k] = temp.get(i++);
            }
            else if (i > midIndex) {
                array[k] = temp.get(i++);
            }
            else if (SortUtils.less(temp.get(i), temp.get(j))) {
                array[k] = temp.get(i++);
            }
            else {
                array[k] = temp.get(j++);
            }
        }
    }
    */


    public static void main(String[] args) {
        final MergeSort mergeSort = new MergeSort();
        Integer[] randomArray = Arrays.stream(SortUtilsRandomGenerator.generateIntArray(10, 100))
            .boxed()
            .toArray(Integer[]::new);
        Integer[] inversioni = {0};
        System.out.println("Original array");
        SortUtils.print(randomArray);;
        System.out.println("Sorted array");
        mergeSort.sortInversioni(randomArray, 0, 9, inversioni);
        SortUtils.print(inversioni); 
    }
}