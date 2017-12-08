package com.chaosmuse.aoc;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;
import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class Day06Test {

    @Test
    @Parameters
    public void testPartOne(String input, int expected) {
        assertEquals(expected, new Day06().partOne(input));
    }

    private Object[] parametersForTestPartOne() {
        return $(
                $("0 2 7 0", 5), //
                $("0 5 10 0 11 14 13 4 11 8 8 7 1 4 12 11", 7864) //
        );
    }

    @Test
    @Parameters
    public void testPartTwo(String input, int expected) {
        assertEquals(expected, new Day06().partTwo(input));
    }

    private Object[] parametersForTestPartTwo() {
        return $(
                $("0 2 7 0", 4), //
                $("0 5 10 0 11 14 13 4 11 8 8 7 1 4 12 11", 1695) //
         );
    }
}
