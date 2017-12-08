package com.chaosmuse.aoc;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;
import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class Day05Test {

    @Test
    @Parameters
    public void testPartOne(String input, int expected) {
        assertEquals(expected, new Day05().partOne(input));
    }

    private Object[] parametersForTestPartOne() {
        return $(
                $("0\n3\n0\n1\n-3", 5) //
        );
    }

    @Test
    @Parameters
    public void testPartTwo(String input, int expected) {
        assertEquals(expected, new Day05().partTwo(input));
    }

    private Object[] parametersForTestPartTwo() {
        return $(
                $("0\n3\n0\n1\n-3", 10) //
         );
    }
}
