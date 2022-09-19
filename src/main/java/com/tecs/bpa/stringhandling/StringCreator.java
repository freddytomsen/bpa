package com.tecs.bpa.stringhandling;

import java.util.ArrayList;
import java.util.List;

public class StringCreator {

    //5, 10, 20, 1000, 65000
    private static final int nrOfStrings = 65000;

    static List<String> createALotOfStrings() {
        List<String> listOfStrings = new ArrayList<>();
        for(int i = 1; i <= nrOfStrings; i++) {
            listOfStrings.add(" String number " + i);
        }
        return listOfStrings;
    }

}





