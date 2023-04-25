package br.tec.db;

public class NinjaDeNinjutsu extends Personagem implements Ninja {

    public NinjaDeNinjutsu(String nome, int vida) {
        super(nome, vida);
    }

    @Override
    public void usarJutsu(String jutsuKeyMap, Personagem personagemAtacado) {
        if (this.verificaPelaKeySeOJutsoExisteESeTemChakra(jutsuKeyMap)
                && personagemAtacado.verificaSeTemVida(personagemAtacado)) {

            System.out.println(this.getNome() + " atacando o " + personagemAtacado.getNome());
            if (!desviar()) {
                this.atacaOutroNinja(jutsuKeyMap, personagemAtacado);
            }else{
                this.perdeChakra(this.getJutsus().get(jutsuKeyMap).getConsumoDeChakra());
            }
        }
    }

    @Override
    public boolean desviar() {
        if (super.chanceDeDesviar() % 2 == 0) {
            System.out.println("-> Desviou");
            return true;
        }
        return false;
    }
}
