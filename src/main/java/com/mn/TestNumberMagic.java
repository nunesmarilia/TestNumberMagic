package com.mn;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class TestNumberMagic {

    static boolean testCousin   = true;
    static int countCousin      = 0;
    static int countNumberMagic = 0;

    public static void main(String[] args){

        System.out.println("*******************************************");
        System.out.println("Resultado: "+validNumberMagic(args));
        System.out.println("*******************************************");
    }

    public static int validNumberMagic(String[] param){
        /*
         * Validações de entrada
         * - Números positivos
         * - Números em conjuntos (2 elementos)
         * - Números separados por ','
         * - Conjuntos separados por ','
         * - Número não inteiro
         */
        String parseParam       = param[0].toString();

        if( parseParam.isEmpty() )
            throw new IllegalArgumentException("Parêmetro de entrada inválido - Vazio");

        Pattern filerRegx       = Pattern.compile("^\\[[ ]*(\\[(([ ]*[0-9]+[ ]*,[ ]*[0-9]+)[ ]*\\][ ]*[,]?[ ]*)+|[ ]*[0-9]+[ ]*,[ ]*[0-9]+[ ]*)+[ ]*\\]$");
        Matcher regexMatcher    = filerRegx.matcher(parseParam);


        if( !regexMatcher.matches() ){
            System.out.println("Parêmetro de entrada inválido");
            throw new IllegalArgumentException("Parêmetro de entrada inválido");
        }

        /* Formatação dos dados de entrada em lista */
        parseParam  = parseParam.substring (0, parseParam.length() - 1);
        parseParam  = parseParam.replace("[","");
        parseParam  = parseParam.replace("]","\'");
        parseParam  = parseParam+",";

        String[] arrayParse  = parseParam.split("\',");

        List<String> listPeriods = Arrays.asList(arrayParse);

        countNumberMagic    = 0;

        listPeriods.forEach(period->{
            String[] arrayPeriod    = period.split(",");
            int periodInitial       = Integer.parseInt(arrayPeriod[0]);
            int periodFinal         = Integer.parseInt(arrayPeriod[1])+1;

            if( periodFinal < periodInitial ){
                // Lançar excpetion de não pode ser o fim menor que o inicio
                System.out.println("Período: ["+periodInitial+','+periodFinal+"] encontra-se com inconformidade com a regra B < A ");
                throw new IllegalArgumentException("Período: ["+periodInitial+','+periodFinal+"] encontra-se com inconformidade com a regra B < A ");
            }

            IntStream.range(periodInitial, periodFinal).forEach(numberInterval-> {
                // Testar raiz
                double resultSqrt    = Math.sqrt(numberInterval);

                if((Math.pow(resultSqrt,2) == new Integer(numberInterval).doubleValue()) && isCousin(numberInterval) ){
                    countNumberMagic++;
                    System.out.println("Número: "+numberInterval+" - Raiz:"+resultSqrt);
                }
            });

            System.out.println("*******************************************");
        });

        return countNumberMagic;
    }

    private static boolean isCousin(int numberTest) {
        testCousin  = false;
        countCousin = 0;

        if( numberTest == 1 )
            return testCousin;

        IntStream.range(1, numberTest).forEach(numberCalc ->{

            if (numberTest % numberCalc == 0)
                countCousin++;
        });

        if( countCousin == 2 ) {
            System.out.println("Primo:"+numberTest);
            System.out.println("Contador:"+countCousin);
            testCousin = true;
        }
        return testCousin;
    }
}

