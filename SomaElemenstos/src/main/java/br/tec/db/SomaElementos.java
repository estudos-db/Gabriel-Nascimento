package br.tec.db;

import java.util.List;

public class SomaElementos {

    public Boolean somaElementos(List<Integer> lista, Integer K){
        for(int i = 0; i < lista.size(); i++){
            for(int j = 0; j < lista.size(); j++){
                if(i != j && lista.get(i) + lista.get(j) == K) {
                    return true;
                }
            }
        }
        return false;
    }
}
