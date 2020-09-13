package com.mn;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    static int      countNumberMagic    = 0;

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

        try {
            listPeriods.forEach(period -> {
                String[] arrayPeriod = period.split(",");
                int periodInitial = Integer.parseInt(arrayPeriod[0]);
                int periodFinal = Integer.parseInt(arrayPeriod[1]);

                countNumberMagic += MagicalNumber.isMagicalNumber(periodInitial, periodFinal);
            });
        }catch (NumberFormatException numberException){
            throw new NumberFormatException("O paramêtro contêm um número maior que o suportado no tipo inteiro");
        }

        return countNumberMagic;
    }

}
