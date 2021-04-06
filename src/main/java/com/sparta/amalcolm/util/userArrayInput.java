package com.sparta.amalcolm.util;

import com.sparta.amalcolm.exceptions.EmptyArrayException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import java.util.Scanner;

public class userArrayInput {

    public static final Logger logger = LogManager.getLogger(userArrayInput.class);

    public static int[] userArrayInput() throws EmptyArrayException {

        Scanner userArrayInput = new Scanner(System.in);
        Printer.printMessage("Please enter your array here. The array may only contain Integer values and each value must be separated by a space.");
        String userInput = userArrayInput.nextLine();

        String[] userInputStringArray = userInput.split(" ");

        if (userInputStringArray.length == 0 || userInputStringArray == null) {
            logger.error("The user has entered either an empty or null array.");
            throw new EmptyArrayException("You cannot use an empty or null array!");
        }

        int[] userInputArray = userArrayProcessing(userInputStringArray);
        return userInputArray;
    }

    public static int[] userArrayProcessing(String[] userInputStringArray){

        if(userInputStringArray == null){
            logger.error("The user Array Input class has received a null input Array.");
            return null;
        }

        boolean exceptionThrown = false;
        int arraySize = userInputStringArray.length;

        int[] userInputIntArray = new int[arraySize];
        for(int i = 0; i < arraySize; i++) {
            try {
                userInputIntArray[i] = Integer.parseInt(userInputStringArray[i]);
            }
            catch (NumberFormatException e){
                logger.error("Your array was entered incorrectly, please ensure that you only enter Integer values and that there is only 1 space between values.", e);
                exceptionThrown = true;
                break;
            }
        }

        if(exceptionThrown == true){
            return null;
        }
        else{
            Printer.printMessage("\nThe input array is: ");
            Printer.printIntArray(userInputIntArray);

            return userInputIntArray;
        }
    }
}
