package br.tec.db;

import java.util.Arrays;

public class Personagem {

    private String nome;
    private int idade;
    private String aldeia;
    public String[] jutsus;
    private int chakra;

    private int totalDeJutsus = 0;

    public Personagem(String nome, int idade, String aldeia, int chakra){
        this.nome = nome;
        this.idade = idade;
        this.aldeia = aldeia;
        jutsus = new String[0];
        this.chakra = chakra;
    }

    public void adicionaJutsu(String jutsu){

        if(jutsus.length <= totalDeJutsus){
            jutsus = Arrays.copyOf(jutsus, jutsus.length + 1);
        }

        this.jutsus[totalDeJutsus] = jutsu;
        totalDeJutsus++;
    }

    public void aumentaChakra(int valorAumento){
        this.chakra += valorAumento;
    }

    public int getChakra() {
        return chakra;
    }

    public String[] getJutsus() {
        return jutsus;
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                " | Idade: " + idade +
                " | aldeia: " + aldeia +
                " | jutsus: " + Arrays.toString(jutsus) +
                " | Chakra: " + chakra;
    }
}





