package com.tecs.bpa.stringhandling;

import org.apache.commons.lang3.StringUtils;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Measurement(batchSize = 10, iterations = 10)
@Warmup(batchSize = 10, iterations = 5)
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



