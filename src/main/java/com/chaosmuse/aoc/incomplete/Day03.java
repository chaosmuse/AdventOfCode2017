package com.chaosmuse.aoc.incomplete;

import static java.lang.Math.sqrt;

public class Day03 {

    // TODO BROKEN!!
    public long partOne(String input) {
        long point;
        try {
            point = Long.parseLong(input);
        } catch (NumberFormatException ex) {
            throw new RuntimeException("The provided input could not be converted to an integer.");
        }

        long squareSideLength = findSquareSize(point);
        long distanceFromEnd = squareSideLength * squareSideLength - point;
        long[] pointLocation = new long[]{squareSideLength, distanceFromEnd};

        int[][] grid = buildGrid((int) squareSideLength);

        // find center
        // TODO change to calculated center point
        long[] centerPoint = null;// = locateCenter();

        // calculate steps from input to center
        long manhattanDistance = (Math.abs(pointLocation[0])
                - Math.abs(centerPoint[0])) + (Math.abs(pointLocation[1]) - Math.abs(centerPoint[1]));

        return manhattanDistance;
    }

    public int partTwo() {
        return 0; // todo
    }

    private int[][] buildGrid(int squareSideLength) {
        int[][] grid = new int[squareSideLength][squareSideLength];

        // for each number, find its spot and assign it
        for(int num = squareSideLength^2; num < 0; num--) {
            int x = 2;
            int y = 2;
            grid[x][y] = num;
        }

        return grid;
    }

    private long findSquareSize(long point) {
        double root = Math.sqrt(point);
        double floor = Math.floor(root);
        return (floor == root) ? (long) Math.floor(root) : (long) Math.floor(root) + 1;
    }


}
