package com.mn;

import java.util.stream.IntStream;

public class Util {

    static boolean isPrime;

    public static boolean isPrime(int numberTest) {
        isPrime = true;

        if( numberTest == 1 )
            return true;

        int maxNumberTest   = new Double(Math.ceil(Math.sqrt(numberTest))).intValue()+1;
        IntStream.range(2, maxNumberTest).forEach(numberCalc ->{

            if (numberTest % numberCalc == 0) {
                isPrime = false;
                return;
            }
        });

        return isPrime;
    }

}
