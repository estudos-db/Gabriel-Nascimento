package br.tec.db;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public abstract class Personagem {

    private String nome;
    private Map<String, Jutsu> jutsus;
    private int chakra;
    private int vida;

    public static int possibilidadeDeDesviar;

    public Personagem(String nome, int vida) {
        this.nome = nome;
        this.jutsus = new HashMap<>();
        this.chakra = 100;
        this.vida = vida;
    }

    public String getNome() {
        return nome;
    }

    public Map<String, Jutsu> getJutsus() {
        return jutsus;
    }

    public int getChakra() {
        return chakra;
    }

    public int getVida() {
        return vida;
    }

    public void perdeVida(int dano) {
        this.vida -= dano;
    }

    public void perdeChakra(int chakra) {
        this.chakra -= chakra;
    }

    public void adicionarJutsus(String nomeJutsu, Jutsu jutsu) {
        jutsus.put(nomeJutsu, jutsu);
    }

    public static void setPossibilidadeDeDesviar(int posibilidade) {
        possibilidadeDeDesviar = posibilidade;
    }

    public int chanceDeDesviar() {
        if (possibilidadeDeDesviar == 1) {
            return 1;
        } else if (possibilidadeDeDesviar == 2) {
            return 2;
        } else {
            Random numeroAleatorio = new Random();
            return numeroAleatorio.nextInt(5) + 1;
        }
    }

    public boolean validaAVidaAposDano(Jutsu jutsu) {
        if (getVida() <= jutsu.getDano()) {
            vida = 0;
            System.out.println(this.getNome() + " sem vida\n");
            return false;
        }
        return true;
    }

    public boolean verificaSeTemChakra(Jutsu jutsu) {
        return jutsu.getConsumoDeChakra() <= this.getChakra();
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + " | Jutsus: " + getJutsus() +
                "\nVida: " + getVida() + " | Chakra: " + getChakra() + "\n";
    }
}
