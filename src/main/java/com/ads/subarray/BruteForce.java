package com.ads.subarray;

import com.ads.subarray.MaxSubArrayAlgorithm;
import com.ads.subarray.Utils;
import com.ads.subarray.UtilsRandomGenerator;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Maximum sub-array brute force generic algorithm
 * 
 * This class provides methods for the brute force version of the
 * maximum sub-array problem algorithm.
 * 
 * Time Complexity:
 *  O(n^2)  
 *
 * Space Complexity: 
 *  O(1) 
 * 
 * @see MaxSubArrayAlgorithm
 */
class BruteForce implements MaxSubArrayAlgorithm {

    @Override
    public Map<String, Integer> find(Integer[] array, int l, int r){
        return bruteForceFind(array, l, r);
    }

    /**
     * Brute force method to find the maximum sub-array
     * @param A The array
     * @param l The first index of the subarray to analyze
     * @param r The last index of the subarray to analyze
     * @return a map containing the first and last index of the sub-array (maxL, maxR) and the maxSum sum of its elements
     */
    public static Map<String, Integer> bruteForceFind (Integer[] A, int l, int r) {
        Integer maxSum = -Integer.MAX_VALUE;
        Integer maxL = l;
        Integer maxR = l;
        Integer sum;
        for (int i = l; i <= r; i++) {
            sum = 0;
            for (int j = i; j <= r; j++) {
                sum += A[j];
                if (sum > maxSum){
                    maxSum = sum;
                    maxL = i;
                    maxR = j;
                }
            }
        }
        Map<String, Integer> results = new HashMap<>();
        if (maxSum > 0) {
            results.put("maxL", maxL);
            results.put("maxR", maxR);
            results.put("maxSum", maxSum);
        }
        else {
            results.put("maxL", -1);
            results.put("maxR", -1);
            results.put("maxSum", 0);
        }
        return results;
    }
    
    public static void main(String[] args) {
        final BruteForce maxSubArray = new BruteForce();
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