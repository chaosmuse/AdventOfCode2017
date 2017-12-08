package com.chaosmuse.aoc;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Day06 {

    public int partOne(String input) {
        int cycleCounts = 0;
        int[] blocks = buildBlocks(input);
        Set<String> blockSnapshots = new HashSet<>();

        String currentState;
        while (!blockSnapshots.contains(currentState = buildStringVersionOfBlocks(blocks))) {
            System.out.println(currentState);

            blockSnapshots.add(currentState);
            blocks = distributeBlocks(blocks);
            cycleCounts++;
        }

        return cycleCounts;
    }

    public int partTwo(String input) {
        int cycleCounts = 0;
        int[] blocks = buildBlocks(input);
        Set<String> blockSnapshots = new LinkedHashSet<>();

        String currentState;
        while (!blockSnapshots.contains(currentState = buildStringVersionOfBlocks(blocks))) {
            System.out.println(currentState);

            blockSnapshots.add(currentState);
            blocks = distributeBlocks(blocks);
            cycleCounts++;
        }
        int indexOfFirstOccurrence = findDuplicatedState(currentState, blockSnapshots);
        return cycleCounts - indexOfFirstOccurrence;
    }

    private int findDuplicatedState(String currentState, Set<String> blockSnapshots) {
        int indexOfFirstOccurrence = 0;
        for(String block : blockSnapshots) {
            if(currentState.equals(block)) {
                return indexOfFirstOccurrence;
            } else {
                indexOfFirstOccurrence++;
            }
        }
        return -1; // not found!
    }

    private int[] distributeBlocks(int[] blocks) {
        int[] newBlocks = blocks.clone();
        int biggestBlockIndex = 0;
        int biggestBlock = 0;

        for (int i = 0; i < newBlocks.length; i++) {
            if (newBlocks[i] > biggestBlock) {
                biggestBlockIndex = i;
                biggestBlock = newBlocks[i];
            }
        }

        int blocksToDistribute;
        int remainingBlocks;

        if (biggestBlock < newBlocks.length) {
            blocksToDistribute = 1;
            remainingBlocks = 0;
        } else {
            blocksToDistribute = biggestBlock / (newBlocks.length - 1);
            remainingBlocks = biggestBlock % (newBlocks.length - 1);
        }

        int blocksDistributed = 0;
        newBlocks[biggestBlockIndex] = remainingBlocks;
        for (int i = (biggestBlockIndex + 1) % newBlocks.length; blocksDistributed < (biggestBlock - remainingBlocks); i = (i + 1) % newBlocks.length) {
            if (i != biggestBlockIndex) {
                newBlocks[i] += blocksToDistribute;
                blocksDistributed += blocksToDistribute;
            }
        }

        return newBlocks;
    }

    public String buildStringVersionOfBlocks(int[] blocks) {
        StringBuilder builder = new StringBuilder();
        for (int block : blocks) {
            builder.append(block).append("\t");
        }
        return builder.toString();
    }

    private int[] buildBlocks(String input) {
        String[] rawBlockValues = input.split(" ");
        int[] blocks = new int[rawBlockValues.length];

        for (int i = 0; i < rawBlockValues.length; i++) {
            try {
                blocks[i] = Integer.parseInt(rawBlockValues[i]);
            } catch (NumberFormatException ex) {
                throw new RuntimeException("Could not convert " + blocks[i] + " into an int value.");
            }
        }
        return blocks;
    }

}
