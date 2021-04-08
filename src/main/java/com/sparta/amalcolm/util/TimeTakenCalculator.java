package com.sparta.amalcolm.util;

import java.text.DecimalFormat;

public class TimeTakenCalculator {

    public static String TimeTakenCalculation(double start, double end){

        double timeTakenValue = (end-start)/1000000;

        DecimalFormat df = new DecimalFormat("#.###");
        String timeTakenWord = df.format(timeTakenValue);

        return timeTakenWord;
    }
}
