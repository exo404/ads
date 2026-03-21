package com.ads.search;

import java.util.Arrays;
import java.util.List;

interface SearchAlgorithm {

    /**
     * Main method for search algorithms
     * 
     * @param array to search
     * @return the element index if found  
     */
    <T extends Comparable<T>> int search(T[] array, T value);
}