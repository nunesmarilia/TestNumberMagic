package com.mn;

import java.util.stream.IntStream;

public class MagicalNumber {
    static double   resultFirstSqrt     = 0;

    public static int isMagicalNumber(int periodInitial, int periodFinal ){

        if( periodFinal < periodInitial ){
            // Lançar excpetion de não pode ser o fim menor que o inicio
            System.out.println("Período: ["+periodInitial+','+periodFinal+"] encontra-se com inconformidade com a regra B < A ");
            throw new IllegalArgumentException("Período: ["+periodInitial+','+periodFinal+"] encontra-se com inconformidade com a regra B < A ");
        }

        int      countNumberMagic    = 0;

        // Encontrar a primeira raiz quadrada
        resultFirstSqrt = new Double(Math.ceil(Math.sqrt(periodInitial))).intValue();

        for (int numberInterval = (int) (resultFirstSqrt*resultFirstSqrt); (resultFirstSqrt*resultFirstSqrt) < periodFinal; numberInterval++) {
            if( Util.isPrime((int) Math.sqrt(numberInterval)) ){
                countNumberMagic++;
            }

            resultFirstSqrt++;
            numberInterval  = (int) (resultFirstSqrt*resultFirstSqrt)-1;
        }

        return countNumberMagic;
    }
}
