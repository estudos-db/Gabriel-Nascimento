package br.tec.db;

public class NinjaDeNinjutsu extends Personagem implements Ninja {

    public NinjaDeNinjutsu(String nome, int idade, String aldeia, int chakra) {
        super(nome, idade, aldeia, chakra);
    }

    @Override
    public void usarJutsu() {
        System.out.println("Usando um jutsu de Ninjutsu");
    }

    @Override
    public void desviar() {
        System.out.println("Desviando de um ataque usando Ninjutsu");
    }
}
