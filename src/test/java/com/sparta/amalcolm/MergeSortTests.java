package com.sparta.amalcolm;

import com.sparta.amalcolm.sort.MergeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MergeSortTests {
    @Test
    @DisplayName("MST: Basic 5-value disordered array.")
    public void mST5InputDisorderedArray(){
        int[] inputArray = {5,4,3,2,1};
        int[] sortedArray = {1,2,3,4,5};

        MergeSort myMergeSort = new MergeSort();
        Assertions.assertArrayEquals(sortedArray, myMergeSort.sortArray(inputArray));
    }

    @Test
    @DisplayName("MST: Basic 5-value ordered array.")
    public void mST5InputOrderedArray(){
        int[] inputArray = {1,2,3,4,5};
        int[] sortedArray = {1,2,3,4,5};

        MergeSort myMergeSort = new MergeSort();
        Assertions.assertArrayEquals(sortedArray, myMergeSort.sortArray(inputArray));
    }

    @Test
    @DisplayName("MST: Null Input Array.")
    public void mSTnullArray(){
        int[] inputArray = null;
        int[] sortedArray = null;

        MergeSort myMergeSort = new MergeSort();
        Assertions.assertArrayEquals(sortedArray, myMergeSort.sortArray(inputArray));
    }
}
