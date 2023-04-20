package br.tec.db;

public class NinjaDeNinjutsu extends Personagem implements Ninja {

    public NinjaDeNinjutsu(String nome, int vida) {
        super(nome, vida);
    }

    @Override
    public void usarJutsu(String jutsuKeyMap, Personagem personagemAtacado) {
        if (this.getJutsus().containsKey(jutsuKeyMap)) {

            Jutsu jutsu = getJutsus().get(jutsuKeyMap);

            if(verificaSeTemChakra(jutsu)) {
                System.out.println(getNome() + " atacando usando Ninjutsu\n");
                perdeChakra(jutsu.getConsumoDeChakra());

                if (personagemAtacado.validaAVidaAposDano(jutsu)) {
                    if (desviar()) {
                        jutsu.atacaOutroNinja(personagemAtacado);
                    } else {
                        System.out.println(personagemAtacado.getNome() + " desviou\n");
                    }
                }
            }else{
                System.out.println(getNome() + " sem chakra");
            }
        }
    }

    @Override
    public boolean desviar() {
        return chanceDeDesviar() % 2 != 0;
    }
}
