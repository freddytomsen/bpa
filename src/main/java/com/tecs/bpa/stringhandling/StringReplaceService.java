package com.tecs.bpa.stringhandling;

import org.apache.commons.lang3.StringUtils;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1, warmups = 1)
@Measurement(batchSize = 10, iterations = 1)
@Warmup(batchSize = 10, iterations = 1)
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
