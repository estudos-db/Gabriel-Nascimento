package br.tec.db;

public class NinjaDeTaijutsu extends Personagem implements Ninja {

    public NinjaDeTaijutsu(String nome, int idade, String aldeia, int chakra) {
        super(nome, idade, aldeia, chakra);
    }

    @Override
    public void usarJutsu() {
        System.out.println("Usando um jutsu de Taijutsu");
    }

    @Override
    public void desviar() {
        System.out.println("Desviando de um ataque usando Taijutsu");
    }
}
