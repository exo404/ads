package com.ads.search;

import java.util.Arrays;
import com.ads.search.SearchUtils;
import com.ads.search.SearchUtilsRandomGenerator;

class BinarySearch implements SearchAlgorithm {

    @Override
    public <T extends Comparable<T>> int search(T[] array, T value) {
        return search(array, 0, array.length - 1, value, -1);
    }

    /**
     * Search the given value using the standard Binary Search algorithm.
     *
     * @param array The array to search
     * @param p The first index of the subarray
     * @param r The last index of the subarray
     * @param value The value to find
     * @param f The index of the found element, -1 otherwise
     * @param <T>   The type of elements in the array, which must be comparable
     * @return The index of the value if found, -1 otherwise
     */
    public <T extends Comparable<T>> int search(T[] array, int p, int r, T value, int f) {
        int found = f;
        if (p >= r) {
            if (value == array[r]) {
                found = r;
            }
            return found;
        }
        else if (found == -1)
        {
            int q = (p + r) / 2;
        
            if (SearchUtils.equal(value, array[q])) {
                found = q;
            }
            else if (SearchUtils.greater(value, array[q])) {
                found = search(array, q + 1, r, value, found); 
            }
            else {
                found = search(array, p, q - 1, value, found);
            }
        }
        return found;
    }

    public static void main (String[] args) {
        final BinarySearch binarySearch = new BinarySearch();
        final Integer[] randomArray = Arrays.stream(SearchUtilsRandomGenerator.generateIntArray(10, 100))
                .boxed()
                .toArray(Integer[]::new);
        final Integer find = SearchUtilsRandomGenerator.generateInt(10); 
        System.out.println("Array:");
        SearchUtils.print(randomArray);
        System.out.println("Find:");
        System.out.println(randomArray[find].toString());
        System.out.println("Found:");
        Integer found = binarySearch.search(randomArray, randomArray[find]);
        if (found != -1){
            System.out.println(randomArray[found].toString());
        }
        else{
            System.out.println("Not found");
        }
    }

}