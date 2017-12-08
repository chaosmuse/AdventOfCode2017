package com.chaosmuse.aoc.incomplete;

import com.chaosmuse.aoc.incomplete.Day03;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;
import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class Day03Test {

    @Test
    @Parameters
    public void testPartOne(String input, long expected) {
        assertEquals(expected, new Day03().partOne(input));
    }

    public Object[] parametersForTestPartOne() {
        return $(
                $("1", 0), //
                $("3", 2), //
                $("12", 3), //
                $("23", 2), //
                $("1024", 31) //
        );
    }
}
