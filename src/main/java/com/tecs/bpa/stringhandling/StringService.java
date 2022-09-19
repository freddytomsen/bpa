package com.tecs.bpa.stringhandling;
import org.apache.commons.lang3.StringUtils;
import org.openjdk.jmh.annotations.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static com.tecs.bpa.stringhandling.StringCreator.createALotOfStrings;








@BenchmarkMode(Mode.SingleShotTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 1, warmups = 1)
@Measurement(batchSize = 10, iterations = 3)
@Warmup(batchSize = 10, iterations = 1)
public class StringService {


    public String concatWithPlusInLoop() {
        List<String> aLotOfStrings = createALotOfStrings();

        String result = "";
        for (String currentString : aLotOfStrings) {
            result = result + currentString;
        }
        return result;
    }


    public String concatWithConcatInLoop() {
        List<String> aLotOfStrings = createALotOfStrings();
        String result = "";
        for (String currentString : aLotOfStrings) {
            result = result.concat(currentString);
        }
        return result;
    }


    public String concatWithBuilderInLoop() {
        List<String> aLotOfStrings = createALotOfStrings();
        StringBuilder stringBuilder = new StringBuilder(aLotOfStrings.size());
        for (String currentString : aLotOfStrings) {
            stringBuilder.append(currentString);
        }
        return stringBuilder.toString();
    }

    public String concatWithApacheStringUtils() {
        List<String> aLotOfStrings = createALotOfStrings();
        return StringUtils.join(aLotOfStrings,"");
    }

}
