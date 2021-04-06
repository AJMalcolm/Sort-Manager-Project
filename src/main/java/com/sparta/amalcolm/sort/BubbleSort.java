package com.sparta.amalcolm.sort;

import com.sparta.amalcolm.Interfaces.Sorter;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BubbleSort implements Sorter {

    public static final Logger logger = LogManager.getLogger(BubbleSort.class);

    private static BubbleSort bubbleSortInstance = new BubbleSort();

    @Override
    public int[] sortArray(int[] inputArray) {

        // Sorter for an array of integers in ascending order (left to right)

        if(inputArray != null){
            int[] sortingArray = inputArray;
            int placeholder = 0;
            int counter = 0;
            boolean complete = false;

            while (complete == false) {
                for (int j = 0; j < sortingArray.length; j++) {
                    if (j == (sortingArray.length - 1)) {
                        counter++;
                    }
                    else if (sortingArray[j + 1] < sortingArray[j]) {
                        placeholder = sortingArray[j];
                        sortingArray[j] = sortingArray[j + 1];
                        sortingArray[j + 1] = placeholder;
                    } else if (sortingArray[j + 1] >= sortingArray[j]) {
                        counter++;
                    }
                }
                if(counter == (sortingArray.length)) {
                    complete = true;
                }
                else{
                    counter = 0;
                    placeholder = 0;
                }
            }
            return sortingArray;
        }
        else{
            logger.error("The BubbleSort class has received a null array.");
            return null;
        }
    }

    public static BubbleSort getInstance(){
        return bubbleSortInstance;
    }
}
