package com.mn;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestNumberMagicTest {
    @Test
    @DisplayName("Teste sucesso do número mágico utilizando o conjunto [[8,27],[49,49]]")
    void testNumberMagicExampleSuccess() {
        String[] param  = new String[1];
        param[0]        = "[[8,27],[49,49]]";

        int resultNumberMagic   = Main.validNumberMagic(param);
        Assertions.assertEquals(3, resultNumberMagic);
    }

    @Test
    @DisplayName("Teste sucesso parêmetro inválido: negativo - Entrada [[-8,27],[49,49]]")
    void testParamInvalidNegative() {
        String[] param  = new String[1];
        param[0]        = "[[-8,27],[49,49]]";

        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.validNumberMagic(param));
    }

    @Test
    @DisplayName("Teste sucesso parêmetro inválido: B < A - Entrada [[30,27]]")
    void testParamInvalidBBeforeA() {
        String[] param  = new String[1];
        param[0]        = "[[30,27]]";

        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.validNumberMagic(param));
    }

    @Test
    @DisplayName("Teste sucesso parêmetro inválido: Número não inteiro - Entrada [[30.5,27]]")
    void testParamInvalidNumberNotInteger() {
        String[] param  = new String[1];
        param[0]        = "[[30.5,27]]";

        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.validNumberMagic(param));
    }

    @Test
    @DisplayName("Teste sucesso parêmetro inválido: Letras - Entrada [[B,A]]")
    void testParamInvalidLetter() {
        String[] param  = new String[1];
        param[0]        = "[[B,A]]";

        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.validNumberMagic(param));
    }

    @Test
    @DisplayName("Teste sucesso parêmetro inválido: Espaços - Entrada [[ 30,27 ]]")
    void testParamInvalidSpace() {
        String[] param  = new String[1];
        param[0]        = "[[ 30,27 ]]";

        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.validNumberMagic(param));
    }

    @Test
    @DisplayName("Teste sucesso parêmetro inválido: Vazio - Entrada {}")
    void testParamInvalidEmpty() {
        String[] param  = new String[1];
        param[0]        = "";

        Assertions.assertThrows(IllegalArgumentException.class, () -> Main.validNumberMagic(param));
    }
}