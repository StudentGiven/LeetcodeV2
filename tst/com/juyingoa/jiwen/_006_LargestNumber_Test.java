package com.juyingoa.jiwen;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _006_LargestNumber_Test {

    @Test
    public void test01() {
        _006_LargestNumber myClass = new _006_LargestNumber();
        int expected_result = 972;
        assertEquals(expected_result, myClass.solution(762, 3));
    }



}
