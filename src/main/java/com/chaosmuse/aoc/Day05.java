package com.chaosmuse.aoc;

public class Day05 {

    public int partOne(String input) {
        int stepsToExit = 0;
        int[] instructions = buildInstructionSet(input);

        for (int i = 0; i < instructions.length; ) {
            int increment = instructions[i];
            System.out.println("entered at " + i + "; moving " + increment + " steps; ending at " + i+increment);
            instructions[i] += 1;
            i += increment;
            stepsToExit++;
        }

        return stepsToExit;
    }


    private int[] buildInstructionSet(String input) {
        String[] instructions = input.split("\n");
        int[] numericInstructions = new int[instructions.length];

        for (int i = 0; i < instructions.length; i++) {
            try {
                numericInstructions[i] = Integer.parseInt(instructions[i]);
            } catch (NumberFormatException ex) {
                throw new RuntimeException("Could not parse " + instructions[i] + " as a number.");
            }
        }

        return numericInstructions;
    }

    public int partTwo(String input) {
        int stepsToExit = 0;
        int[] instructions = buildInstructionSet(input);

        for (int i = 0; i < instructions.length; ) {
            int increment = instructions[i];
            // System.out.println("entered at " + i + "; moving " + increment + " steps; ending at " + i+increment);
            instructions[i] += instructions[i] >= 3 ? -1 : 1;
            i += increment;
            stepsToExit++;
        }

        return stepsToExit;
    }
}
