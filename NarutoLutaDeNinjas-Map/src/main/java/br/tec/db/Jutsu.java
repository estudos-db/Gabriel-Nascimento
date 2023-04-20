package br.tec.db;

public class Jutsu {

    private int dano;
    private int consumoDeChakra;

    public Jutsu(int dano, int consumoDeChakra) {
        this.dano = dano;
        this.consumoDeChakra = consumoDeChakra;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getConsumoDeChakra() {
        return consumoDeChakra;
    }

    public void atacaOutroNinja(Personagem personagem) {
        personagem.perdeVida(this.getDano());
    }

    @Override
    public String toString() {
        return "Dano: " + getDano() + " | Consumo de Chakra: " + consumoDeChakra;
    }
}
