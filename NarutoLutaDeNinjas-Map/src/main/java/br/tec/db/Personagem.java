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
        if (this.getVida() < 0) {
            this.vida = 0;
            System.out.println("O ninja atacado perdeu a luta");
        }
    }

    public void perdeChakra(int chakra) {
        this.chakra -= chakra;
        if (getChakra() < 0) {
            chakra = 0;
        }
    }

    public void adicionarJutsus(String nomeJutsu, Jutsu jutsu) {
        jutsus.put(nomeJutsu, jutsu);
    }

    public static void setPossibilidadeDeDesviar(int posibilidade) {
        possibilidadeDeDesviar = posibilidade;
    }

    public boolean verificaSeTemVida() {
        if (this.getVida() != 0) {
            return true;
        }
        System.out.println("Ninja atacado sem vida");
        return false;
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

    public boolean verificaSeOJutsoExiste(String jutsuKeyMap) {
        if (this.jutsus.containsKey(jutsuKeyMap)) {
            return confirmaSeTemChakra(jutsuKeyMap);
        }
        System.out.println("Ninja não sabe o jutsu");
        return false;
    }

    private boolean confirmaSeTemChakra(String jutsuKeyMap) {
        if (this.getJutsus().get(jutsuKeyMap).getConsumoDeChakra() <= this.getChakra()) {
            return true;
        }
        System.out.println("Ninja não tem chakra suficiente para atacar");
        return false;
    }

    public void atacaOutroNinja(String jutsuKeyMap, Personagem ninjaAtacado) {
        int danoACausar = this.jutsus.get(jutsuKeyMap).getDano();
        ninjaAtacado.perdeVida(danoACausar);
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + " | Jutsus: " + getJutsus() +
                "\nVida: " + getVida() + " | Chakra: " + getChakra() + "\n";
    }
}
