package br.tec.db;

import java.util.ArrayList;
import java.util.List;

public class ListaDeCompras {

    private Double totalDaLista;
    private Double limiteDeCompras;
    private List<Produto> produtos;

    public ListaDeCompras(Double limiteDeCompras){
        this.totalDaLista = 0.0;
        this.limiteDeCompras = limiteDeCompras;
        produtos = new ArrayList<>();
    }

    public Double getTotalDaLista() {
        return totalDaLista;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public Boolean verificaLimite(Produto produto){
        return totalDaLista + produto.getValor() <= limiteDeCompras;
    }

    public void adicionaProduto(Produto produto){
        if(verificaLimite(produto)){
            produtos.add(produto);
            this.totalDaLista = produto.getValor();
        }else{
            throw new SemLimiteException("Sem limite para compra!");
        }
    }

    public void removeProduto(Produto produto){
        if(produtos.contains(produto)){
            produtos.remove(produto);
            this.totalDaLista -= produto.getValor();
        }else{
            throw new IllegalArgumentException("O produto não existe!");
        }
    }


}

