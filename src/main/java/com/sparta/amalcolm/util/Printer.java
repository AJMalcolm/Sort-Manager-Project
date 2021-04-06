package com.sparta.amalcolm.util;

public class Printer {

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static void printIntArray(int[] array){
        for (int i = 0; i < array.length; i++){
            printIntValue(array[i]);
        }
        printNewLine();
    }

    public static void printStringArray(String[] array){
        for (int i = 0; i < array.length; i++){
            if(i == array.length - 1){
                System.out.printf("%s.\n", array[i]);
            }
            else{
                System.out.printf("%s, ", array[i]);
            }
        }
    }

    public static void printIntValue(int value){
        System.out.printf("%d ", value);
    }

    public static void printNewLine(){
        System.out.println();
    }

    public static void printTimeTaken(String time){
        System.out.println("This operation took: " + time + " seconds.");
    }
}
