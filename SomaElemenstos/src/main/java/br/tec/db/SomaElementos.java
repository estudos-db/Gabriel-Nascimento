package br.tec.db;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SomaElementos {

    public Boolean somaCombinacaoElementos(List<Integer> lista, int k){

        if (lista.size() == 0){
            return false;
        }

        for (List<Integer> l : geraListaComCombinaoesParaSoma(lista)){
            int soma = 0;
            for (int i = 0; i < l.size(); i++){
                soma += l.get(i);
                if (soma == k){
                    System.out.println(l);
                    return true;
                }
            }
        }
        return false;
    }

    private static List<List<Integer>> geraListaComCombinaoesParaSoma(List<Integer> lista) {

        List<List<Integer>> listasCombinacaoElementos = new ArrayList<>();

        for (Integer l : lista){
            listasCombinacaoElementos.add(new ArrayList<>(List.of(l)));
        }

        for (int i = 0; i < lista.size(); i++){
            List<List<Integer>> listasTemp = new ArrayList<>(listasCombinacaoElementos);
            for (List<Integer> n : listasTemp){
                List<Integer> listaComb = new ArrayList<>(n);
                if (!listaComb.contains(lista.get(i))){
                    listaComb.add(lista.get(i));
                }
                if (!listasCombinacaoElementos.contains(listaComb)) {
                    listaComb.sort(Integer::compare);
                    listasCombinacaoElementos.add(listaComb);
                }
            }
        }
        listasCombinacaoElementos.sort(Comparator.comparingInt(List::size));
        System.out.println(listasCombinacaoElementos);
        return listasCombinacaoElementos;
    }
}
