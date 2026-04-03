package com.ads.subarray;

import com.ads.subarray.Utils;
import com.ads.subarray.UtilsRandomGenerator;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Maximum sub-array problem class algorithms common interface
 */
public interface MaxSubArrayAlgorithm {

    /**
     * Main method maximum sub-array find algorithms
     *
     * @param array - the array to analyze
     * @return an HashMap containing maxL, maxR, maxSum 
     */
    Map<String, Integer> find(Integer[] array, int l, int rs);
}