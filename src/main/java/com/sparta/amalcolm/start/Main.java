package com.sparta.amalcolm.start;

import com.sparta.amalcolm.Interfaces.BinaryTree;
import com.sparta.amalcolm.Interfaces.Sorter;
import com.sparta.amalcolm.factory.SorterFactory;
import com.sparta.amalcolm.factory.SorterTypes;
import com.sparta.amalcolm.util.*;
import com.sparta.amalcolm.exceptions.*;
import com.sparta.amalcolm.performancetesting.PerformanceCheck;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

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
            Printer.printMessage("Can you please enter the corresponding number to the option of your choice:");
            Printer.printMessage("1: Bubble Sort");
            Printer.printMessage("2: Merge Sort");
            Printer.printMessage("3: Binary Tree Sort");
            Printer.printMessage("4: Sort Types Performance Test");
            Printer.printMessage("5: Exit Sort Manager Program");

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
                    inputArray = UserArrayInput.UserArrayInput();
                    // UserArrayInput will return null if a user has entered an incorrect value
                    if(inputArray == null){
                        logger.info("User has entered an incorrect array value (e.g. non-integer or multiple spaces)");
                        break;
                    }
                    BubbleSortSetup(inputArray);
                    break;
                case 2:
                    // User has selected the Merge Sort Option
                    inputArray = UserArrayInput.UserArrayInput();
                    // UserArrayInput will return null if a user has entered an incorrect value
                    if(inputArray == null){
                        logger.info("User has entered an incorrect array value (e.g. non-integer or multiple spaces)");
                        break;
                    }
                    MergeSortSetup(inputArray);
                    break;
                case 3:
                    // User has selected the Binary Tree Sort Option
                    inputArray = UserArrayInput.UserArrayInput();
                    // UserArrayInput will return null if a user has entered an incorrect value
                    if(inputArray == null){
                        logger.info("User has entered an incorrect array value (e.g. non-integer or multiple spaces)");
                        break;
                    }
                    BinaryTreeSortSetup(inputArray);
                    break;
                case 4:
                    //User has selected the Sort Types performance test.
                    PerformanceCheck.PerformanceTest();
                case 5:
                    //User has chosen to exit the program.
                    Printer.printMessage("\nThank you for using my Sort Manager Program!");
                    System.exit(0);
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

        Sorter myBubbleSort = SorterFactory.getSorter(SorterTypes.BUBBLE);
        double start = System.nanoTime();
        int[] bubbleSortedArray = myBubbleSort.sortArray(array);
        double end = System.nanoTime();

        String timeTaken = TimeTakenCalculator.TimeTakenCalculation(start, end);

        if(bubbleSortedArray != null){
            if(bubbleSortedArray.length == 1){
                Printer.printMessage("\nYou are a funny person, an array with 1 element comes out the same as it goes in: " + bubbleSortedArray[0] + "!");
            }
            else{
                Printer.printMessage("\nHere is the bubble sorted array in ascending order: ");
                Printer.printIntArray(bubbleSortedArray);
                Printer.printTimeTaken(timeTaken);
            }
        }
    }

    public static void MergeSortSetup(int[] array){

        Sorter myMergeSort = SorterFactory.getSorter(SorterTypes.MERGE);
        double start = System.nanoTime();
        int[] mergeSortedArray = myMergeSort.sortArray(array);
        double end = System.nanoTime();

        String timeTaken = TimeTakenCalculator.TimeTakenCalculation(start, end);

        if(mergeSortedArray != null){
            if(mergeSortedArray.length == 1){
                Printer.printMessage("\nYou are a funny person, an array with 1 element comes out the same as it goes in: " + mergeSortedArray[0] + "!");
            }
            else{
                System.out.println("\nHere is the merge sorted array in ascending order: ");
                Printer.printIntArray(mergeSortedArray);
                Printer.printTimeTaken(timeTaken);
            }
        }
    }

    public static void BinaryTreeSortSetup(int[] array) {

        double start;
        double end;
        String timeTaken;

        int ascDescChoice = 0;
        int continueChoice = 1;
        BinaryTree myBinarySortImpl = SorterFactory.getSorter(SorterTypes.BINARYTREE, array);

        Scanner userInput = new Scanner(System.in);

        while(continueChoice == 1){
            Printer.printMessage("Can you please enter the corresponding number to the sort option of your choice:");
            Printer.printMessage("1: Ascending Order");
            Printer.printMessage("2: Descending Order");
            ascDescChoice = userInput.nextInt();
            switch(ascDescChoice){
                case 1:
                    //User has chosen an Ascending Order Output
                    start = System.nanoTime();
                    int[] binarySortedArrayAsc = myBinarySortImpl.getSortedTreeAsc();
                    end = System.nanoTime();

                    timeTaken = TimeTakenCalculator.TimeTakenCalculation(start, end);

                    if(binarySortedArrayAsc.length == 1){
                        Printer.printMessage("\nYou are a funny person, an array with 1 element comes out the same as it goes in: " + binarySortedArrayAsc[0] + "!");
                    }
                    else {
                        System.out.println("\nHere is the binary tree sorted array in ascending order: ");
                        Printer.printIntArray(binarySortedArrayAsc);
                        Printer.printTimeTaken(timeTaken);
                    }
                    break;
                case 2:
                    //User has chosen a Descending Order Output
                    start = System.nanoTime();
                    int[] binarySortedArrayDesc = myBinarySortImpl.getSortedTreeDesc();
                    end = System.nanoTime();

                    timeTaken = TimeTakenCalculator.TimeTakenCalculation(start, end);

                    if(binarySortedArrayDesc.length == 1){
                        Printer.printMessage("\nYou are a funny person, an array with 1 element comes out the same as it goes in: " + binarySortedArrayDesc[0] + "!");
                    }
                    else {
                        System.out.println("\nHere is the binary tree  sorted array in descending order: ");
                        Printer.printIntArray(binarySortedArrayDesc);
                        Printer.printTimeTaken(timeTaken);
                    }
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