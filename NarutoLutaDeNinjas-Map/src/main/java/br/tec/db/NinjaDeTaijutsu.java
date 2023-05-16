package br.tec.db;

public class NinjaDeTaijutsu extends Personagem implements Ninja {

    public NinjaDeTaijutsu(String nome, int vida) {
        super(nome, vida);
    }

    @Override
    public void usarJutsu(String jutsuKeyMap, Personagem personagemAtacado) {
        if (super.verificaSeOJutsoExiste(jutsuKeyMap) && personagemAtacado.verificaSeTemVida()) {

            super.perdeChakra(super.getJutsus().get(jutsuKeyMap).getConsumoDeChakra());

            System.out.println(super.getNome() + " atacando o " + personagemAtacado.getNome());

            if (desviar()) {
                super.atacaOutroNinja(jutsuKeyMap, personagemAtacado);
            }
        }
    }

    @Override
    public boolean desviar() {
        if (super.chanceDeDesviar() % 2 != 0) {
            System.out.println("-> Desviou");
            return true;
        }
        return false;
    }
}
