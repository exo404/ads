package com.ads.subarray;

import com.ads.subarray.MaxSubArrayAlgorithm;
import com.ads.subarray.Utils;
import com.ads.subarray.UtilsRandomGenerator;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Maximum sub-array divide et impera generic algorithm
 * 
 * This class provides methods for the divide et impera version of the
 * maximum sub-array problem algorithm.
 * 
 * Time Complexity:
 *  O(nlogn)  
 *
 * Space Complexity: 
 *  O(logn) 
 *  
 * @see MaxSubArrayAlgorithm
 */
class DivideEtImpera implements MaxSubArrayAlgorithm{
    
    @Override
    public Map<String, Integer> find(Integer[] array, int l, int r){
        return divideEtImperaFind(array, l, r);
    }
    
    /**
     * Divide et impera method to find the maximum sub-array
     * @param A The array
     * @param l The first index of the subarray to analyze
     * @param r The last index of the subarray to analyze
     * @return a map containing the first and last index of the sub-array (maxL, maxR) and the maxSum sum of its elements
     */
    public static Map<String, Integer> divideEtImperaFind (Integer[] A, int l, int r) {
        if (Utils.isNegative(A, l, r)) {
            Map<String, Integer> results = new HashMap<>();
            results.put("maxL", -1);
            results.put("maxR", -1);
            results.put("maxSum", 0);
            return results;
        }
        if (l >= r){
            Map<String, Integer> results = new HashMap<>();
            results.put("maxL", l);
            results.put("maxR", r);
            results.put("maxSum", A[l]);
            return results;
        }
        int m = (l+r)/2;
        Map<String, Integer> resultsL = divideEtImperaFind(A, l, m);
        Map<String, Integer> resultsR = divideEtImperaFind(A, m + 1, r);
        Map<String, Integer> resultsCross = crossFind(A, l, m, r);

        if(resultsL.get("maxSum") >= resultsR.get("maxSum") && resultsL.get("maxSum") >= resultsCross.get("maxSum")) {
            return resultsL;
        }
        else if(resultsR.get("maxSum") >= resultsL.get("maxSum") && resultsR.get("maxSum") >= resultsCross.get("maxSum")) {
            return resultsR;
        }
        else {
            return resultsCross;
        }
    }

    public static Map<String, Integer> crossFind(Integer[] A, int l, int m, int r) {
        int leftSum = -Integer.MAX_VALUE;
        int sum = 0;
        int maxL = 0;
        int maxR = 0;

        for(int i = m; i >= l; i--) {
            sum += A[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxL = i;
            }
        }

        int rightSum = -Integer.MAX_VALUE;
        sum = 0;

        for(int j = m+1; j <= r; j++) {
            sum += A[j];
            if (sum > rightSum) {
                rightSum = sum;
                maxR = j;
            }
        }

        int maxSum = leftSum + rightSum;
        Map<String, Integer> results = new HashMap<>();
        results.put("maxL", maxL);
        results.put("maxR", maxR);
        results.put("maxSum", maxSum);
        return results;
    }
    
    public static void main(String[] args) {
        final DivideEtImpera maxSubArray = new DivideEtImpera();
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