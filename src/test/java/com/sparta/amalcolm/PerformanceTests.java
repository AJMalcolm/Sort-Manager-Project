package com.sparta.amalcolm;

import com.sparta.amalcolm.Interfaces.BinaryTree;
import com.sparta.amalcolm.Interfaces.Sorter;
import com.sparta.amalcolm.factory.SorterFactory;
import com.sparta.amalcolm.factory.SorterTypes;
import com.sparta.amalcolm.util.TimeTakenCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class PerformanceTests {

    public static final Logger logger = LogManager.getLogger(PerformanceTests.class);

    private static int[][] arraysToSort = new int[3][];
    private static int[][] unsortedArrays;

    @BeforeAll
    public static void arrayTestsSetup(){
        Random random = new Random();
        arraysToSort[0] = new int[10];
        for(int i = 0; i < 10; i++){
            arraysToSort[0][i] = random.nextInt(1000);
        }
        arraysToSort[1] = new int[100];
        for(int j = 0; j < 100; j++){
            arraysToSort[1][j] = random.nextInt(1000);
        }
        arraysToSort[2] = new int[1000];
        for(int k = 0; k < 1000; k++){
            arraysToSort[2][k] = random.nextInt(1000);
        }
    }

    @BeforeEach
    public void arrayPrep(){
        unsortedArrays = arraysToSort.clone();
    }

    @Test
    @DisplayName("Bubble Sort Performance Test")
    public void BubbleSortTest(){
        for (int[] unsortedArray : unsortedArrays){
            logger.info("Unsorted Array: " + Arrays.toString(unsortedArray));
            Sorter myBubbleSort = SorterFactory.getSorter(SorterTypes.BUBBLE);
            long start = System.nanoTime();
            int[] sortedArray = myBubbleSort.sortArray(unsortedArray);
            long end = System.nanoTime();
            logger.info("Bubble Sorted Array: " + Arrays.toString(sortedArray));
            String timeTaken = TimeTakenCalculator.TimeTakenCalculation(start, end);
            logger.info("Time taken: " + timeTaken);
            System.out.println("Time taken for Bubble Size " + unsortedArray.length + ": " + timeTaken + "ms");
        }
    }

    @Test
    @DisplayName("Merge Sort Performance Test")
    public void MergeSortTest(){
        for (int[] unsortedArray : unsortedArrays) {
            logger.info("Unsorted Array: " + Arrays.toString(unsortedArray));
            Sorter myMergeSort = SorterFactory.getSorter(SorterTypes.MERGE);
            long start = System.nanoTime();
            int[] sortedArray = myMergeSort.sortArray(unsortedArray);
            long end = System.nanoTime();
            logger.info("Merge Sorted Array: " + Arrays.toString(sortedArray));
            String timeTaken = TimeTakenCalculator.TimeTakenCalculation(start, end);
            logger.info("Time taken: " + timeTaken);
            System.out.println("Time taken for Merge Size " + unsortedArray.length + ": " + timeTaken + "ms");
        }
    }

    @Test
    @DisplayName("Binary Tree Sort Performance Test")
    public void BinaryTreeSortTest(){
        for (int[] unsortedArray : unsortedArrays) {
            logger.info("Unsorted Array: " + Arrays.toString(unsortedArray));
            BinaryTree myBinaryTreeSort = SorterFactory.getSorter(SorterTypes.BINARYTREE, unsortedArray);
            long start = System.nanoTime();
            int[] sortedArray = myBinaryTreeSort.getSortedTreeAsc();
            long end = System.nanoTime();
            logger.info("Binary Tree Sorted Array: " + Arrays.toString(sortedArray));
            String timeTaken = TimeTakenCalculator.TimeTakenCalculation(start, end);
            logger.info("Time taken: " + timeTaken);
            System.out.println("Time taken for Binary Tree Size " + unsortedArray.length + ": " + timeTaken + "ms");
        }
    }
}