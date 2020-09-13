package com.mn;

import java.util.stream.IntStream;

public class MagicalNumber {

    public static int isMagicalNumber(int periodInitial, int periodFinal ){

        if( periodFinal < periodInitial ){
            // Lançar excpetion de não pode ser o fim menor que o inicio
            System.out.println("Período: ["+periodInitial+','+periodFinal+"] encontra-se com inconformidade com a regra B < A ");
            throw new IllegalArgumentException("Período: ["+periodInitial+','+periodFinal+"] encontra-se com inconformidade com a regra B < A ");
        }

        int countNumberMagic       = 0;
        int resultFirstSqrt;

        // Encontrar a primeira raiz quadrada
        resultFirstSqrt = new Double(Math.ceil(Math.sqrt(periodInitial))).intValue();

        while ((resultFirstSqrt*resultFirstSqrt) <= periodFinal) {
            if( Util.isPrime(resultFirstSqrt) ){
                countNumberMagic++;
            }
            resultFirstSqrt++;
        }

        return countNumberMagic;
    }
}
