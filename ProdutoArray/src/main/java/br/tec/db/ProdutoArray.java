package br.tec.db;

public class ProdutoArray {

    public Integer[] produtoDoArray(Integer[] array){

        if(array.length == 0 || array[0] == null){
            throw new IllegalArgumentException("Array Invalido");
        }

        Integer[] novoArray = new Integer[array.length];

        for(int i = 0; i < array.length; i++){
            int multiplica = 1;
            for(int x = 0; x < array.length; x++){
                if(i != x){
                    multiplica *= array[x];
                }
            }
            novoArray[i] = multiplica;
        }

        return novoArray;
    }


}
