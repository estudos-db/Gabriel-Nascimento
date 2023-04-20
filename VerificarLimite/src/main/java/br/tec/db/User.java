package br.tec.db;

public class User {

    private String nome;
    private ListaDeCompras listaDeCompras;
    private Double limiteDeCompras;

    public User(String nome, Double limiteDeCompras){
        this.nome = nome;
        this.limiteDeCompras = limiteDeCompras;
        listaDeCompras = new ListaDeCompras();
    }

    public String getNome() {
        return nome;
    }

    private Boolean verificaLimite(Produto produto){
        return listaDeCompras.getTotalDaLista() + produto.getValor() <= limiteDeCompras;
    }

    public ListaDeCompras getListaDeCompras() {
        return listaDeCompras;
    }

    public void adicionaProdutoNaLista(Produto produto){
        if(verificaLimite(produto)){
            listaDeCompras.getProdutos().add(produto);
            listaDeCompras.setTotalDaLista(produto.getValor());
        }else{
            throw new SemLimiteException("Sem limite para compra!");
        }
    }

    public void removeProdutoDaLista(Produto produto){
        if(listaDeCompras.getProdutos().contains(produto)){
            listaDeCompras.getProdutos().remove(produto);
            listaDeCompras.setTotalDaLista(listaDeCompras.getTotalDaLista() - produto.getValor());
        }else{
            throw new IllegalArgumentException("O produto não existe!");
        }
    }
}
