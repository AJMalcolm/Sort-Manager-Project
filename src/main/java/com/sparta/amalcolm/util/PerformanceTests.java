package com.sparta.amalcolm.util;

import com.sparta.amalcolm.binarytreesort.BinarySortImpl;
import com.sparta.amalcolm.sort.BubbleSort;
import com.sparta.amalcolm.sort.MergeSort;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Random;

public class PerformanceTests {

    public static final Logger logger = LogManager.getLogger(PerformanceTests.class);

    private static String[] bubbleSortTimes = new String[4];
    private static String[] mergeSortTimes = new String[4];
    private static String[] binaryTreeSortTimes = new String[4];

    public static void PerformanceTest(){

        try{
        BubbleSortPerformanceTest();
        MergeSortPerformanceTest();
        BinaryTreeSortPerformanceTest();}
        catch(NullPointerException nPE){
            logger.fatal("A null pointer exception has occurred while running the performance test comparison.", nPE);
        }

        Printer.printMessage("So once again for easier comparison:");
        Printer.printMessage("The Bubble Sort Times (in seconds) were:");
        Printer.printStringArray(bubbleSortTimes);
        Printer.printMessage("The Merge Sort Times (in seconds) were:");
        Printer.printStringArray(mergeSortTimes);
        Printer.printMessage("The Binary Tree Sort Times (in seconds) were:");
        Printer.printStringArray(binaryTreeSortTimes);
    }

    public static void BubbleSortPerformanceTest(){

        Random rand = new Random();
        int upperbound = 1000;
        int[] arraySize = {10, 100, 1000, 10000};
        String[] timesTaken = {null, null, null, null};
        int position = 0;

        for(int size : arraySize){

            int[] array = new int[size];
            for (int i = 0; i < size; i++){
                array[i] = rand.nextInt(upperbound);
            }

            BubbleSort myBubbleSort = new BubbleSort();
            double start = System.nanoTime();
            int[] sortedArray = myBubbleSort.sortArray(array);
            double end = System.nanoTime();

            Printer.printMessage("The Bubble Sorted array of size " + arraySize[position] + " is:");
            Printer.printIntArray(sortedArray);
            Printer.printNewLine();
            timesTaken[position] = TimeTakenCalculator.TimeTakenCalculation(start, end);
            bubbleSortTimes[position] = timesTaken[position];

            position++;
        }

        Printer.printMessage("The computation times (in seconds, to the nearest millisecond) for the Bubble Sorted Arrays of sizes " + arraySize[0] + ", " + arraySize[1] + ", " + arraySize[2] + " and " + arraySize[3] + " are:");
        Printer.printStringArray(timesTaken);
        Printer.printNewLine();
    }

    public static void MergeSortPerformanceTest(){

        Random rand = new Random();
        int upperbound = 1000;
        int[] arraySize = {10, 100, 1000, 10000};
        String[] timesTaken = {null, null, null, null};
        int position = 0;

        for(int size : arraySize){

            int[] array = new int[size];
            for (int i = 0; i < size; i++){
                array[i] = rand.nextInt(upperbound);
            }

            MergeSort myMergeSort = new MergeSort();
            double start = System.nanoTime();
            int[] sortedArray = myMergeSort.sortArray(array);
            double end = System.nanoTime();

            Printer.printMessage("The Merge Sorted array of size " + arraySize[position] + " is:");
            Printer.printIntArray(sortedArray);
            Printer.printNewLine();
            timesTaken[position] = TimeTakenCalculator.TimeTakenCalculation(start, end);
            mergeSortTimes[position] = timesTaken[position];

            position++;
        }

        Printer.printMessage("The computation times (in seconds, to the nearest millisecond) for the Merge Sorted Arrays of sizes " + arraySize[0] + ", " + arraySize[1] + ", " + arraySize[2] + " and " + arraySize[3] + " are:");
        Printer.printStringArray(timesTaken);
        Printer.printNewLine();
    }

    public static void BinaryTreeSortPerformanceTest(){

        Random rand = new Random();
        int upperbound = 1000;
        int[] arraySize = {10, 100, 1000, 10000};
        String[] timesTaken = {null, null, null, null};
        int position = 0;

        for(int size : arraySize){

            int[] array = new int[size];
            for (int i = 0; i < size; i++){
                array[i] = rand.nextInt(upperbound);
            }

            BinarySortImpl myBinarySortImpl = new BinarySortImpl(array);

            double start = System.nanoTime();
            int[] sortedArray = myBinarySortImpl.getSortedTreeAsc();
            double end = System.nanoTime();

            Printer.printMessage("The Binary Tree Sorted array of size " + arraySize[position] + " is:");
            Printer.printIntArray(sortedArray);
            Printer.printNewLine();
            timesTaken[position] = TimeTakenCalculator.TimeTakenCalculation(start, end);
            binaryTreeSortTimes[position] = timesTaken[position];

            position++;
        }

        Printer.printMessage("The computation times (in seconds, to the nearest millisecond) for the Binary Tree Sorted Arrays of sizes " + arraySize[0] + ", " + arraySize[1] + ", " + arraySize[2] + " and " + arraySize[3] + " are:");
        Printer.printStringArray(timesTaken);
        Printer.printNewLine();
    }
}
