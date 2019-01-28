package com.codehacks.helper;

import java.util.Random;

/**
 * A class to generate cargo item number
 *
 * @author E238958
 */
public class TrackingNumberGenerator {

    private String trackingNum;
    private final Random r = new Random();

    /**
     * Tracking number of the format: XX-DYX-ZZZ {ZZZ AND D are numbers}
     * @return a tracking code.
     */
    public String getTrackingNumber() {
        trackingNum = processTrackingNumber();
        return trackingNum;
    }

    /** @returns an upper case between A and Z.*/
    private char getUpperCaseLetter() {
        return (char) (65 + r.nextInt(26));
    }

    /**@return a digit between 1 and 9 inclusive. */
    private int getADigit() {
        return 1 + r.nextInt(9);
    }

    /**
     * @return a tracking code
     */
    private String processTrackingNumber() {
        StringBuilder sb = new StringBuilder();

        for (int index = 1; index <= 2; index++) {
            sb.append(getUpperCaseLetter());
        }
        sb.append(getADigit());
        for (int index = 1; index <= 3; index++) {
            sb.append(getUpperCaseLetter());
        }
        for (int index = 1; index <= 2; index++) {
            sb.append(getADigit());
        }

        sb.append(getUpperCaseLetter());
        return sb.toString();
    }
}
