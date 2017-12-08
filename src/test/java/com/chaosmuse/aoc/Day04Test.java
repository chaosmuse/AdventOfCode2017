package com.chaosmuse.aoc;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;
import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class Day04Test {

    @Test
    @Parameters
    public void testPartOne(String input, int expected) {
        assertEquals(expected, new Day04().partOne(input));
    }

    private Object[] parametersForTestPartOne() {
        return $(
                $("aa bb cc dd ee", 1), //
                $("aa bb cc dd aa", 0), //
                $("aa bb cc dd aaa", 1) //
        );
    }

    @Test
    @Parameters
    public void testPartTwo(String input, int expected) {
        assertEquals(expected, new Day04().partTwo(input));
    }

    private Object[] parametersForTestPartTwo() {
        return $( //
                $("abcde fghij", 1), //
                $("abcde xyz ecdab", 0), //
                $("a ab abc abd abf abj", 1), //
                $("iiii oiii ooii oooi oooo", 1), //
                $("oiii ioii iioi iiio", 0) //
        );
    }

}
