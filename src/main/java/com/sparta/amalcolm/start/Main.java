package com.sparta.amalcolm.start;

import com.sparta.amalcolm.util.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import com.sparta.amalcolm.exceptions.*;
import com.sparta.amalcolm.sort.BubbleSort;
import com.sparta.amalcolm.sort.MergeSort;
import com.sparta.amalcolm.binarytreesort.BinarySortImpl;
import com.sparta.amalcolm.util.PerformanceTests;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws EmptyArrayException {

        int[] inputArray;

        int option = 0;
        int continueChoice = 1;

        Printer.printMessage("\nHello and welcome to my Sort Manager Program! - Alasdair Malcolm\n");

        while (continueChoice == 1) {
            Printer.printMessage("Can you please enter the corresponding number to the sort option of your choice:");
            Printer.printMessage("1: Bubble Sort");
            Printer.printMessage("2: Merge Sort");
            Printer.printMessage("3: Binary Tree Sort");
            Printer.printMessage("4: Sort Types Performance Test");

            Scanner userInput = new Scanner(System.in);
            try{
                option = userInput.nextInt();
            }
            catch(InputMismatchException iME){
                option = 10;
                logger.error("User has entered an incorrect (non int) value at the main menu selection.", iME);
            }

            switch (option) {
                case 1:
                    // User has selected the Bubble Sort Option
                    inputArray = userArrayInput.userArrayInput();
                    // userArrayInput will return null if a user has entered an incorrect value
                    if(inputArray == null){
                        logger.info("User has entered an incorrect array value (e.g. non-integer or multiple spaces)");
                        break;
                    }
                    BubbleSortSetup(inputArray);
                    break;
                case 2:
                    // User has selected the Merge Sort Option
                    inputArray = userArrayInput.userArrayInput();
                    // userArrayInput will return null if a user has entered an incorrect value
                    if(inputArray == null){
                        logger.info("User has entered an incorrect array value (e.g. non-integer or multiple spaces)");
                        break;
                    }
                    MergeSortSetup(inputArray);
                    break;
                case 3:
                    // User has selected the Binary Tree Sort Option
                    inputArray = userArrayInput.userArrayInput();
                    // userArrayInput will return null if a user has entered an incorrect value
                    if(inputArray == null){
                        logger.info("User has entered an incorrect array value (e.g. non-integer or multiple spaces)");
                        break;
                    }
                    BinaryTreeSortSetup(inputArray);
                    break;
                case 4:
                    //User has selected the Sort Types performance test.
                    PerformanceTests.PerformanceTest();
                case 10:
                    //User has entered a non integer number previously.
                    break;
                default:
                    logger.error("User entered an unknown (outside of selection) option at the main menu.");
                    throw new IllegalStateException(option + "is not an appropriate option.");
            }
            Printer.printMessage("\nWould you like to run another sort program?");
            Printer.printMessage("1 for YES, any other number for NO");
            try{
                continueChoice = userInput.nextInt();
            }
            catch(InputMismatchException iME){
                logger.fatal("User has entered an incorrect value in the repeat section of the main menu.", iME);
                Printer.printMessage("\nThat is an invalid input, please feel free to run the program again if you wish to continue.");
                break;
            }

        }

        Printer.printMessage("\nThank you for using my Sort Manager Program!");
    }

    public static void BubbleSortSetup(int[] array) {
        BubbleSort myBubbleSort = new BubbleSort();
        double start = System.nanoTime();
        int[] bubbleSortedArray = myBubbleSort.sortArray(array);
        double end = System.nanoTime();

        String timeTaken = TimeTakenCalculator.TimeTakenCalculation(start, end);

        if(bubbleSortedArray != null){
            System.out.println("\nHere is the bubble sorted array in ascending order: ");
            Printer.printIntArray(bubbleSortedArray);
            Printer.printTimeTaken(timeTaken);
        }
    }

    public static void MergeSortSetup(int[] array){
        MergeSort myMergeSort = new MergeSort();
        double start = System.nanoTime();
        int[] mergeSortedArray = myMergeSort.sortArray(array);
        double end = System.nanoTime();

        String timeTaken = TimeTakenCalculator.TimeTakenCalculation(start, end);

        if(mergeSortedArray != null){
            System.out.println("\nHere is the merge sorted array in ascending order: ");
            Printer.printIntArray(mergeSortedArray);
            Printer.printTimeTaken(timeTaken);
        }
    }

    public static void BinaryTreeSortSetup(int[] array) {

        double start;
        double end;
        String timeTaken;

        int ascDescChoice = 0;
        int continueChoice = 1;
        BinarySortImpl myBinarySortImpl = new BinarySortImpl(array);

        Scanner userInput = new Scanner(System.in);

        while(continueChoice == 1){
            Printer.printMessage("Can you please enter the corresponding number to the sort option of your choice:");
            Printer.printMessage("1: Ascending Order");
            Printer.printMessage("2: Descending Order");
            ascDescChoice = userInput.nextInt();
            switch(ascDescChoice){
                case 1:
                    start = System.nanoTime();
                    int[] binarySortedArrayAsc = myBinarySortImpl.getSortedTreeAsc();
                    end = System.nanoTime();

                    timeTaken = TimeTakenCalculator.TimeTakenCalculation(start, end);

                    System.out.println("\nHere is the binary tree sorted array in ascending order: ");
                    Printer.printIntArray(binarySortedArrayAsc);
                    Printer.printTimeTaken(timeTaken);
                    break;
                case 2:
                    start = System.nanoTime();
                    int[] binarySortedArrayDesc = myBinarySortImpl.getSortedTreeDesc();
                    end = System.nanoTime();

                    timeTaken = TimeTakenCalculator.TimeTakenCalculation(start, end);

                    System.out.println("\nHere is the binary tree  sorted array in descending order: ");
                    Printer.printIntArray(binarySortedArrayDesc);
                    Printer.printTimeTaken(timeTaken);
                    break;
                default:
                    throw new IllegalStateException(ascDescChoice + "is not an appropriate option.");
            }
            Printer.printMessage("Would you like to choose a different order?");
            Printer.printMessage("1 for YES, any other number for NO");
            continueChoice = userInput.nextInt();
        }

    }
}