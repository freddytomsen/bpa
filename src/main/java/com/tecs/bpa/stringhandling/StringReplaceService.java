package com.tecs.bpa.stringhandling;

import org.apache.commons.lang3.StringUtils;
import org.openjdk.jmh.annotations.Benchmark;

public class StringReplaceService {


    @Benchmark
    public String benchmarkStringReplace() {
        String mystring = StringCreator.createALongString();
        return mystring.replace("toReplace", "newSubstring");
    }

    @Benchmark
    public String benchmarkStringUtilsReplace() {
        String mystring = StringCreator.createALongString();
        return StringUtils.replace(mystring, "toReplace", "newSubstring");
    }

}
