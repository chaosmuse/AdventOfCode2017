package com.chaosmuse.aoc;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;
import static junitparams.JUnitParamsRunner.$;

@RunWith(JUnitParamsRunner.class)
public class Day07Test {

    @Test
    @Parameters
    public void testPartOne(String input, String expected) {
        assertEquals(expected, new Day07().partOne(input));
    }

    public Object[] parametersForTestPartOne() {
        return $(
                $("pbga (66)\n" +
                                "xhth (57)\n" +
                                "ebii (61)\n" +
                                "havc (66)\n" +
                                "ktlj (57)\n" +
                                "fwft (72) -> ktlj, cntj, xhth\n" +
                                "qoyq (66)\n" +
                                "padx (45) -> pbga, havc, qoyq\n" +
                                "tknk (41) -> ugml, padx, fwft\n" +
                                "jptl (61)\n" +
                                "ugml (68) -> gyxo, ebii, jptl\n" +
                                "gyxo (61)\n" +
                                "cntj (57)",
                        "tknk") //
        );
    }
}
