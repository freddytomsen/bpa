package com.tecs.bpa.stringhandling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringReplaceServiceTest {

    private final StringReplaceService stringReplaceService = new StringReplaceService();


    @Test
    void resultsAreEquals() {
        String byUtils = stringReplaceService.replaceByUtils();
        String byString = stringReplaceService.replaceByString();
        assertEquals(byUtils, byString);
    }

}





