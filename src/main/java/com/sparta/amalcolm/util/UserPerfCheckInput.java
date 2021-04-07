package com.sparta.amalcolm.util;

import com.sparta.amalcolm.exceptions.InvalidValueException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserPerfCheckInput {

    public static final Logger logger = LogManager.getLogger(UserPerfCheckInput.class);

    public static int UserPerfTestInput() {

        int averageRepetitions = 0;

        int continueReading = 0;
        boolean exceptionThrown;

        while (continueReading == 0) {
            exceptionThrown = false;
            Printer.printMessage("Please enter the number of repetitions to be performed during this test.");
            Printer.printMessage("You may only enter Integer numbers above 0 and below 200");
            Printer.printMessage("Warning: more repetitions will incur a longer time for calculations, however less repetitions can lead to unreliable results!");

            Scanner userInput = new Scanner(System.in);

            try {
                averageRepetitions = userInput.nextInt();
            } catch (NumberFormatException nFE) {
                exceptionThrown = true;
                logger.error("The user has entered a non-Integer value.", nFE);
            } catch (InputMismatchException iME) {
                exceptionThrown = true;
                logger.error("The user has entered a non-numeric value.", iME);
            }

            if (averageRepetitions <= 0) {
                try {
                    throw new InvalidValueException("User has entered an invalid value below 1.");
                } catch (InvalidValueException iVE) {
                    logger.error("User has entered an invalid value within Performance Tests.", iVE);
                }

            } else if (averageRepetitions > 200) {
                try {
                    throw new InvalidValueException("User has entered an invalid value above 200.");
                } catch (InvalidValueException iVE) {
                    logger.error("User has entered an invalid value within Performance Tests.", iVE);
                }
            } else if (exceptionThrown == false) {
                continueReading = 1;
            }
        }

        return averageRepetitions;
    }
}
