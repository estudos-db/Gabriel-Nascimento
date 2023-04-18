package br.tec.db;

public class Produto {

    private String nome;
    private Double valor;

    public Produto(String nome, Double valor){
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public Double getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object obj) {

        if(obj == null || this.getClass() != obj.getClass()) return false;
        if(this == obj) return true;

        Produto produto = (Produto) obj;
        return produto.getNome() != null && this.getNome().compareTo(produto.getNome()) == 0;
    }
}
