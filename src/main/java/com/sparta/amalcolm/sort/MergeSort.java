package com.sparta.amalcolm.sort;
import com.sparta.amalcolm.Interfaces.Sorter;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.ArrayList;

public class MergeSort implements Sorter {

    public static final Logger logger = LogManager.getLogger(MergeSort.class);

    @Override
    public int[] sortArray(int[] inputArray) {

        if(inputArray != null){
            if(inputArray.length <= 1){
                return inputArray;
            }

            ArrayList<int[]> splitArrays = new ArrayList<>();
            splitArrays = ArraySplitter.ArraySplitter(inputArray);

            int[] leftArray = new int[splitArrays.get(0).length];
            int[] rightArray = new int[splitArrays.get(1).length];

            for (int i = 0; i < leftArray.length; i++){
                leftArray[i] = splitArrays.get(0)[i];
            }
            for (int j = 0; j < rightArray.length; j++){
                rightArray[j] = splitArrays.get(1)[j];
            }

            //Recursively sort through the 2 sides of each subsequent array.
            leftArray = sortArray(leftArray);
            rightArray = sortArray(rightArray);


            int[] finalArray = new int[inputArray.length];

            finalArray = MergeSortArray(leftArray, rightArray);

            return finalArray;
        }
        else{
            logger.error("The MergeSort class has received a null array.");
            return null;
        }
    }

    private int[] MergeSortArray(int[] leftInputArray, int[] rightInputArray){

        int[] resultArray = new int[leftInputArray.length + rightInputArray.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while(leftIndex < leftInputArray.length || rightIndex < rightInputArray.length){
            if (leftIndex < leftInputArray.length && rightIndex < rightInputArray.length){
                if (leftInputArray[leftIndex] < rightInputArray[rightIndex]){
                    resultArray[resultIndex] = leftInputArray[leftIndex];
                    resultIndex++;
                    leftIndex++;
                }
                else{
                    resultArray[resultIndex] = rightInputArray[rightIndex];
                    resultIndex++;
                    rightIndex++;
                }
            }
            else if(leftIndex < leftInputArray.length){
                resultArray[resultIndex] = leftInputArray[leftIndex];
                resultIndex++;
                leftIndex++;
            }
            else{
                resultArray[resultIndex] = rightInputArray[rightIndex];
                resultIndex++;
                rightIndex++;
            }
        }

        return resultArray;
    }
}
