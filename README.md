## Teste dos númerico mágicos

Este algoritmo calcula a quantidade de números mágicos em N intervalos de números 

## Entrada de dados
 
* Exemplo: [[8,27], [49,49]]

### Restrições
* Não aceita mais de 2 elementos em cada intervalo
* Não aceita letras
* Não aceita números negativos
* Somente aceita números inteiros
* [A,B] B não pode ser menor que A

## Observações

* Está sendo considerado o número 1 como primo
* Seria melhor para a performece trocar os loops de Java 8 por "for"

## Build manual com Testes
```bash
mvn clean install -Dmaven.test.skip=false
cd target/classes/
java com.mn.Main [[8,27],[49,49]]
```

## Build manual sem Testes
```bash
mvn clean install -Dmaven.test.skip=true
cd target/classes/
java com.mn.Main [[8,27],[49,49]]
```