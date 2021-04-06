package com.sparta.amalcolm;

import com.sparta.amalcolm.util.UserArrayInput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserArrayInputTests {

    @Test
    @DisplayName("UAIT: Basic 5-value String Array to Int Array")
    public void uAITBasic5ValueStrArrayToIntArray(){
        String[] inputArray = {"1", "2", "3", "4", "5"};
        int[] sortedArray = {1,2,3,4,5};

        Assertions.assertArrayEquals(sortedArray, UserArrayInput.userArrayProcessing(inputArray));
    }

    @Test
    @DisplayName("UAIT: Null Input Array")
    public void uAITNullInputArray(){
        String[] inputArray = null;
        int[] sortedArray = null;

        Assertions.assertArrayEquals(sortedArray, UserArrayInput.userArrayProcessing(inputArray));
    }
}
