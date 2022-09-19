package com.tecs.bpa.stringhandling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringServiceTest {

    private StringService stringService = new StringService();

    @Test
    void testConcatWithPlus() {
        String actual = stringService.concatWithPlusInLoop();
    }

    @Test
    void testConcatWithBuilder() {
        String actual = stringService.concatWithBuilderInLoop();
    }













    @Test
    void allResultsAreEqual() {
        String concatResult = stringService.concatWithConcatInLoop();
        String builderResult = stringService.concatWithBuilderInLoop();
        String plusResult = stringService.concatWithPlusInLoop();
        String utilsResult = stringService.concatWithApacheStringUtils();
        assertEquals(concatResult, builderResult);
        assertEquals(builderResult, plusResult);
        assertEquals(plusResult, utilsResult);
    }
}









