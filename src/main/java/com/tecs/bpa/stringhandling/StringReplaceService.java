package com.tecs.bpa.stringhandling;
import org.apache.commons.lang3.StringUtils;
import org.openjdk.jmh.annotations.*;



public class StringReplaceService {


    @Benchmark
    public String replaceByString() {
        String myString = StringCreator.createALongString();
        return myString.replace("toReplace", "newSubstring");
    }

    @Benchmark
    public String replaceByUtils() {
        String myString = StringCreator.createALongString();
        return StringUtils.replace(myString, "toReplace", "newSubstring");
    }

}



