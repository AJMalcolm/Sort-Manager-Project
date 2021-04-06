package com.sparta.amalcolm;

import com.sparta.amalcolm.sort.BubbleSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BubbleSortTests {

    @Test
    @DisplayName("BST: Basic 5-value disordered array.")
    public void bST5InputDisorderedArray(){
        int[] inputArray = {5,4,3,2,1};
        int[] sortedArray = {1,2,3,4,5};

        BubbleSort myBubbleSort = new BubbleSort();
        Assertions.assertArrayEquals(sortedArray, myBubbleSort.sortArray(inputArray));
    }

    @Test
    @DisplayName("BST: Basic 5-value ordered array.")
    public void bST5InputOrderedArray(){
        int[] inputArray = {1,2,3,4,5};
        int[] sortedArray = {1,2,3,4,5};

        BubbleSort myBubbleSort = new BubbleSort();
        Assertions.assertArrayEquals(sortedArray, myBubbleSort.sortArray(inputArray));
    }

    @Test
    @DisplayName("BST: Null Input Array.")
    public void bSTnullArray(){
        int[] inputArray = null;
        int[] sortedArray = null;

        BubbleSort myBubbleSort = new BubbleSort();
        Assertions.assertArrayEquals(sortedArray, myBubbleSort.sortArray(inputArray));
    }
}
