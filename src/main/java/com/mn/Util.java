package com.mn;

import java.util.stream.IntStream;

public class Util {
    static boolean testCousin   = true;

    public static boolean isPrime(int numberTest) {
        testCousin  = true;

        if( numberTest == 1 )
            return true;

        int maxNumberTest   = new Double(Math.ceil(Math.sqrt(numberTest))).intValue();
        IntStream.range(2, maxNumberTest).forEach(numberCalc ->{

            if (numberTest % numberCalc == 0) {
                testCousin  = false;
                return;
            }
        });

        System.out.println("Primo:"+numberTest);

        return testCousin;
    }

}
