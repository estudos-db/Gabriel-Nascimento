package br.tec.db;

public class Carro {

    private String marca;
    private String modelo;
    private String ano;
    private String cor;
    private Double velocidadeMaxima;
    private Double velocidadeAtual = 0.0;

    public Carro(String marca, String modelo, String ano, String cor, Double velocidadeMaxima){
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.cor = cor;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public void mostrarVelocidade(){
        System.out.println("Velocidade atual: " + velocidadeAtual + "Km/h");
    }

    public void acelerar(){
        velocidadeAtual = velocidadeAtual + 10.0;
        if(velocidadeAtual > velocidadeMaxima) {
            this.velocidadeAtual = velocidadeMaxima;
        }
        mostrarVelocidade();
    }

    public void frear(){
        this.velocidadeAtual -= 7.0;
        if(velocidadeAtual < 0){
            this.velocidadeAtual = 0.0;
        }
        mostrarVelocidade();
    }

    public Double getVelocidadeMaxima() {
        return this.velocidadeMaxima;
    }

    public Double getVelocidadeAtual() {
        return this.velocidadeAtual;
    }
}
