package br.tec.db;

import java.util.ArrayList;
import java.util.List;

public class ListaDeCompras {

    private Double totalDaLista;
    private List<Produto> produtos;

    public ListaDeCompras(){
        this.totalDaLista = 0.0;
        produtos = new ArrayList<>();
    }

    public Double getTotalDaLista() {
        return totalDaLista;
    }

    public void setTotalDaLista(Double totalDaLista) {
        this.totalDaLista = totalDaLista;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

}

