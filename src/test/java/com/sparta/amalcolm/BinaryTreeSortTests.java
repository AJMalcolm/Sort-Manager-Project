package com.sparta.amalcolm;

import com.sparta.amalcolm.binarytreesort.BinarySortImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BinaryTreeSortTests {

    @Test
    @DisplayName("BTST: Basic 5-value disordered array to Asc Array")
    public void bTST5InputDescArraytoAscArray(){
        int[] inputArray = {5,4,3,2,1};
        int[] sortedArray = {1,2,3,4,5};

        BinarySortImpl myBinaryTreeSort = new BinarySortImpl(inputArray);
        Assertions.assertArrayEquals(sortedArray, myBinaryTreeSort.getSortedTreeAsc());
    }

    @Test
    @DisplayName("BTST: Basic 5-value disordered array to Desc Array")
    public void bTST5InputDescArraytoDescArray(){
        int[] inputArray = {5,4,3,2,1};
        int[] sortedArray = {5,4,3,2,1};

        BinarySortImpl myBinaryTreeSort = new BinarySortImpl(inputArray);
        Assertions.assertArrayEquals(sortedArray, myBinaryTreeSort.getSortedTreeDesc());
    }

    @Test
    @DisplayName("BTST: Basic 5-value ordered array to Asc Array.")
    public void bTST5InputAscArrayToAscArray(){
        int[] inputArray = {1,2,3,4,5};
        int[] sortedArray = {1,2,3,4,5};

        BinarySortImpl myBinaryTreeSort = new BinarySortImpl(inputArray);
        Assertions.assertArrayEquals(sortedArray, myBinaryTreeSort.getSortedTreeAsc());
    }

    @Test
    @DisplayName("BTST: Basic 5-value ordered array to Desc Array.")
    public void bTST5InputAscArrayToDescArray(){
        int[] inputArray = {1,2,3,4,5};
        int[] sortedArray = {5,4,3,2,1};

        BinarySortImpl myBinaryTreeSort = new BinarySortImpl(inputArray);
        Assertions.assertArrayEquals(sortedArray, myBinaryTreeSort.getSortedTreeDesc());
    }

    @Test
    @DisplayName("BTST: Null Input Array to Asc Array - Expect the process to finish.")

    public void bTSTnullArrayExpClosure(){
        int[] inputArray = null;
        int[] sortedArray = null;

        BinarySortImpl myBinaryTreeSort = new BinarySortImpl(inputArray);
        Assertions.assertArrayEquals(sortedArray, myBinaryTreeSort.getSortedTreeAsc());
    }
}
