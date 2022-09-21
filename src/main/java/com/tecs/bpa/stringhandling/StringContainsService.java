package com.tecs.bpa.stringhandling;

import org.apache.commons.lang3.StringUtils;
import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Measurement(batchSize = 10, iterations = 10)
@Warmup(batchSize = 10, iterations = 5)
public class StringContainsService {

    public boolean containsByJava() {
        String searchString = getSearchString();
        String searchFrom = getSearchFrom();
        boolean contains = searchFrom.contains(searchString);
        return contains;

    }

    public boolean containsByStringUtils() {
        String searchString = getSearchString();
        String searchFrom = getSearchFrom();
        boolean contains = StringUtils.contains(searchFrom,searchString);
        return contains;
    }

    private String getSearchString() {
        return "best";
    }

    private String getSearchFrom() {
        return "Best Practice Academy";
    }

}
