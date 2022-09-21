package com.tecs.bpa.stringhandling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringContainsServiceTest {

    private StringContainsService service = new StringContainsService();

    @Test
    void testContainsByJava() {
        boolean contains = service.containsByJava();
        assertTrue(contains);
    }

    @Test
    void containsByStringUtils() {
        boolean containsByStringUtils = service.containsByStringUtils();
        assertTrue(containsByStringUtils);
    }
}