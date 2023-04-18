package br.tec.db;

public class NinjaDeGenjutsu extends Personagem implements Ninja{

    public NinjaDeGenjutsu(String nome, int idade, String aldeia, int chakra){
        super(nome, idade, aldeia,chakra);
    }

    @Override
    public void usarJutsu() {
        System.out.println("Usando um jutsu de Genjutsu");
    }

    @Override
    public void desviar() {
        System.out.println("Desviando de um ataque usando Genjutsu");
    }
}
