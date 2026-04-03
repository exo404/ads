package com.ads.subarray;

import com.ads.subarray.MaxSubArrayAlgorithm;
import com.ads.subarray.Utils;
import com.ads.subarray.UtilsRandomGenerator;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Maximum sub-array Kadan generic algorithm
 * 
 * This class provides methods for the Kadan version of the
 * maximum sub-array problem algorithm.
 * 
 * Time Complexity:
 *  O(n)
 *
 * Space Complexity: 
 *  O(1) 
 *  
 * @see MaxSubArrayAlgorithm
 */
class Kadan implements MaxSubArrayAlgorithm {

    @Override
    public Map<String, Integer> find(Integer[] array, int l, int r){
        return kadanFind(array, l, r);
    }

    /**
     * Kadan method to find the maximum sub-array
     * @param A The array
     * @param l The first index of the subarray to analyze
     * @param r The last index of the subarray to analyze
     * @return a map containing the first and last index of the sub-array (maxL, maxR) and the maxSum sum of its elements
     */
    public static Map<String, Integer> kadanFind(Integer[] A, int l, int r) {
        int maxSum = 0;
        int tempSum = 0;
        int maxL = l;
        int tempL = l;
        int maxR = l;

        for (int i = l; i <= r; i++) {
            tempSum += A[i];
    
            if (tempSum > maxSum) {
                maxSum = tempSum;
                maxR = i;
                maxL = tempL;
            }
            else if (tempSum < 0) {
                tempSum = 0;
                tempL = i + 1;
            }
        }
        Map<String, Integer> results = new HashMap<>();
        results.put("maxL", maxL);
        results.put("maxR", maxR);
        results.put("maxSum", maxSum);
        return results;
    }
    
    public static void main(String[] args) {
        final Kadan maxSubArray = new Kadan();
        final Integer[] A = Arrays.stream(UtilsRandomGenerator.generateIntArray(10, 100))
            .boxed()
            .toArray(Integer[]::new);
        for (int i = 0; i < A.length; i = i + 2) {
            A[i] = -A[i]; 
        }
        Utils.print(A);
        Utils.results(maxSubArray.find(A, 0, A.length - 1));
    }
}