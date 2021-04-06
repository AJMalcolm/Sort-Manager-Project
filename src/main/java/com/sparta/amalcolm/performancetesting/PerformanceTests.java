package com.sparta.amalcolm.performancetesting;

import com.sparta.amalcolm.binarytreesort.BinarySortImpl;
import com.sparta.amalcolm.sort.BubbleSort;
import com.sparta.amalcolm.sort.MergeSort;

import com.sparta.amalcolm.util.Printer;
import com.sparta.amalcolm.util.UserPerfTestInput;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.text.DecimalFormat;
import java.util.Random;

public class PerformanceTests{

    private static double[] bubbleSortTimes = new double[5];
    private static double[] mergeSortTimes = new double[5];
    private static double[] binaryTreeSortTimes = new double[5];
    private static int averageRepetitions = 1;

    public static final Logger logger = LogManager.getLogger(PerformanceTests.class);

    public static void PerformanceTest(){

        averageRepetitions = UserPerfTestInput.UserPerfTestInput();

        try{
        BubbleSortPerformanceTest();
        MergeSortPerformanceTest();
        BinaryTreeSortPerformanceTest();}
        catch(NullPointerException nPE){
            logger.fatal("A null pointer exception has occurred while running the performance test comparison.", nPE);
        }

        String[] sortComparisonPercentagesBubble = {null, null, null, null, null};
        String[] sortComparisonPercentagesMerge = {null, null, null, null, null};
        String[] sortComparisonPercentagesBinary = {null, null, null, null, null};

        DecimalFormat df = new DecimalFormat("#.###");

        for(int i = 0; i < 5; i++){
            sortComparisonPercentagesBinary[i] = df.format((binaryTreeSortTimes[i]/bubbleSortTimes[i])*100) + "%";
            sortComparisonPercentagesMerge[i] = df.format((mergeSortTimes[i]/bubbleSortTimes[i])*100) + "%";
            sortComparisonPercentagesBubble[i] = df.format((bubbleSortTimes[i]/bubbleSortTimes[i])*100) + "%";
        }

        Printer.printMessage("The results have been normalised to the BubbleSort for easier comparison and with " + averageRepetitions + " repetition(s) performed for reliability.");
        Printer.printMessage("Following are the times taken for each sorting method which were given arrays with 10, 100, 1000, 10000 and 20000 elements respectively:");
        Printer.printMessage("Bubble Sort:");
        Printer.printStringArray(sortComparisonPercentagesBubble);
        Printer.printMessage("Merge Sort:");
        Printer.printStringArray(sortComparisonPercentagesMerge);
        Printer.printMessage("Binary Tree Sort:");
        Printer.printStringArray(sortComparisonPercentagesBinary);
    }

    public static void BubbleSortPerformanceTest(){

        Random rand = new Random();
        int upperbound = 1000;
        int[] arraySize = {10, 100, 1000, 10000, 20000};
        //The timesTakenInt array contains the raw doubles for comparison purposes.
        double[] timesTakenInt = {0,0,0,0,0};
        //The position variable remembers what stage through the following for loop the program has reached.
        int position = 0;

        for(int j = 0; j < averageRepetitions; j++) {
            for (int size : arraySize) {

                int[] array = new int[size];
                for (int i = 0; i < size; i++) {
                    array[i] = rand.nextInt(upperbound);
                }

                BubbleSort myBubbleSort = new BubbleSort();
                double start = System.nanoTime();
                int[] sortedArray = myBubbleSort.sortArray(array);
                double end = System.nanoTime();

                timesTakenInt[position] = (end - start) / 1000000000;
                bubbleSortTimes[position] = bubbleSortTimes[position] + timesTakenInt[position];

                position++;
            }
            position = 0;
        }
    }

    public static void MergeSortPerformanceTest(){

        Random rand = new Random();
        int upperbound = 1000;
        int[] arraySize = {10, 100, 1000, 10000, 20000};
        //The timesTakenInt array contains the raw doubles for comparison purposes.
        double[] timesTakenInt = {0,0,0,0,0};
        //The position variable remembers what stage through the following for loop the program has reached.
        int position = 0;
        for(int j = 0; j < averageRepetitions; j++) {
            for (int size : arraySize) {

                int[] array = new int[size];
                for (int i = 0; i < size; i++) {
                    array[i] = rand.nextInt(upperbound);
                }

                MergeSort myMergeSort = new MergeSort();
                double start = System.nanoTime();
                int[] sortedArray = myMergeSort.sortArray(array);
                double end = System.nanoTime();

                timesTakenInt[position] = (end - start) / 1000000000;
                mergeSortTimes[position] = mergeSortTimes[position] + timesTakenInt[position];

                position++;
            }
            position = 0;
        }
    }

    public static void BinaryTreeSortPerformanceTest(){

        Random rand = new Random();
        int upperbound = 1000;
        int[] arraySize = {10, 100, 1000, 10000, 20000};
        //The timesTakenInt array contains the raw doubles for comparison purposes.
        double[] timesTakenInt = {0,0,0,0,0};
        //The position variable remembers what stage through the following for loop the program has reached.
        int position = 0;

        for(int j = 0; j < averageRepetitions; j++) {
            for (int size : arraySize) {

                int[] array = new int[size];
                for (int i = 0; i < size; i++) {
                    array[i] = rand.nextInt(upperbound);
                }

                BinarySortImpl myBinarySortImpl = new BinarySortImpl(array);

                double start = System.nanoTime();
                int[] sortedArray = myBinarySortImpl.getSortedTreeAsc();
                double end = System.nanoTime();

                timesTakenInt[position] = (end - start) / 1000000000;
                binaryTreeSortTimes[position] = binaryTreeSortTimes[position] + timesTakenInt[position];

                position++;
            }
            position = 0;
        }
    }
}
