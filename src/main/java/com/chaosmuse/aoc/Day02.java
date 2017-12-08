package com.chaosmuse.aoc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day02 {

    public int partOne(String input) {
        // expected format: [#, #, #], [#, #], ...
        int checksum = 0;

        for (String line : input.split("],")) {
            String items = line.trim().replaceAll("\\]", "").replaceAll("\\[", "").trim();
            int[] matrixLine = Arrays.stream(items.split(",")).mapToInt(Integer::parseInt).toArray();
            int largest = 0;
            int smallest = -1;
            checksum += partOnePerLineCalc(largest, smallest, matrixLine);
        }
        return checksum;
    }

    private int partOnePerLineCalc(int largest, int smallest, int[] itemset) {
        for(int item : itemset) {
        largest = largest < item ? item : largest;

        // first time handling
        if(smallest == -1) {
            smallest = largest;
        }
        smallest = item < smallest ? item : smallest;
    }
    return largest-smallest;

    }

    public int partTwo(String input) {
        // expected format: [#, #, #], [#, #], ...
        int checksum = 0;

        for (String line : input.split("],")) {
            String items = line.trim().replaceAll("\\]", "").replaceAll("\\[", "").trim();
            int[] matrixLine = Arrays.stream(items.split(",")).mapToInt(Integer::parseInt).toArray();
            checksum += partTwoPerLineCalc(matrixLine);
        }
        return checksum;
    }

    private int partTwoPerLineCalc(int[] itemset) {
        for(int i : itemset) {
            for(int j : itemset) {
                if(i == j) {
                    continue;
                }else if(i % j == 0) {
                    return i/j;
                } else if(j % i == 0) {
                    return j/i;
                }
            }
        }
        return 0;
    }

}
