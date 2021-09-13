package com.leetcode.jiwen;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class _1348_TweetCountsPerFrequency_Test {

    @Test
    public void test1() {
        _1348_TweetCountsPerFrequency myClass = new _1348_TweetCountsPerFrequency();
        myClass.recordTweet("tweet3", 0);
        myClass.recordTweet("tweet3", 60);
        myClass.recordTweet("tweet3", 10);
        List<Integer> result1 = myClass.getTweetCountsPerFrequency("minute", "tweet3", 0, 59);
        List<Integer> result2 = myClass.getTweetCountsPerFrequency("minute", "tweet3", 0, 60);
        myClass.recordTweet("tweet3", 120);
        List<Integer> result3 = myClass.getTweetCountsPerFrequency("hour", "tweet3", 0, 210);

        List<Integer> expectedResult1 = new ArrayList<Integer>(){{
            add(2);
        }};
        List<Integer> expectedResult2 = new ArrayList<Integer>(){{
            add(2);
            add(1);
        }};
        List<Integer> expectedResult3 = new ArrayList<Integer>(){{
            add(4);
        }};

        assertEquals(expectedResult1, result1);
        assertEquals(expectedResult2, result2);
        assertEquals(expectedResult2, result3);
    }
}
