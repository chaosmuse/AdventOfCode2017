package com.chaosmuse.aoc;

import java.util.Arrays;

public class Day01 {

    public int partOne(String input) {
        return calculateSumByModLocation(input.toCharArray(), 1);
    }

    public int partTwo(String input) {
        return calculateSumByModLocation(input.toCharArray(), input.length() / 2);
    }

    private Integer calculateSumByModLocation(char[] digits, int steps) {
        Integer result = 0;

        for (int i = 0; i < digits.length; i++) {
            int curDigit = Character.getNumericValue(digits[i]);
            int nextDigit = Character.getNumericValue(digits[(i + steps) % digits.length]);
            result += (curDigit == nextDigit)  ? nextDigit : 0;
        }

        return result;
    }
}
