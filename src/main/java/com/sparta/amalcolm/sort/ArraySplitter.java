package com.sparta.amalcolm.sort;
import com.sparta.amalcolm.exceptions.EmptyArrayException;
import com.sparta.amalcolm.util.Printer;

import java.util.ArrayList;

public class ArraySplitter {

    public static ArrayList ArraySplitter(int[] inputArray){

        boolean arrayEven = true;
        int[] arrayLengths = {0,0};

        int ArraySplitPoint = ((inputArray.length)/2);

        if(inputArray.length % 2 != 0){
            ArraySplitPoint++;
            arrayEven = false;
        }

        if(arrayEven == false){
            arrayLengths[0] = inputArray.length - (ArraySplitPoint - 1);
        }
        else{
            arrayLengths[0] = inputArray.length - (ArraySplitPoint);
        }
        arrayLengths[1] = inputArray.length - (ArraySplitPoint);


        ArrayList<int[]> outputArrays = new ArrayList<>();

        int[] leftOutputArray = new int[arrayLengths[0]];
        int[] rightOutputArray = new int[arrayLengths[1]];

        for (int i = 0; i < ArraySplitPoint; i++){
            leftOutputArray[i] = inputArray[i];
        }

        for (int j = 0; j < rightOutputArray.length; j++) {
            rightOutputArray[j] = inputArray[j+ArraySplitPoint];
        }

        outputArrays.add(leftOutputArray);
        outputArrays.add(rightOutputArray);

        return outputArrays;
    }

}
