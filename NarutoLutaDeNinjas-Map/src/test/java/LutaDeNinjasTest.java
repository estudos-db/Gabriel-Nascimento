import br.tec.db.Jutsu;
import br.tec.db.NinjaDeNinjutsu;
import br.tec.db.NinjaDeTaijutsu;
import br.tec.db.Personagem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LutaDeNinjasTest {

    NinjaDeTaijutsu lee;
    NinjaDeNinjutsu naruto;

    Jutsu furacaoDaFolha;
    Jutsu rasengan;

    @BeforeEach
    void inicializa() {
        lee = new NinjaDeTaijutsu("Lee", 100);
        naruto = new NinjaDeNinjutsu("Naruto", 100);

        furacaoDaFolha = new Jutsu(25, 10);
        rasengan = new Jutsu(25, 10);

        lee.adicionarJutsus("furacaoDaFolha", furacaoDaFolha);
        naruto.adicionarJutsus("rasengan", rasengan);
    }

    @Test
    void umNinjaAtacaOutroEPerdeChakra() {
        int chakraEsperado = lee.getChakra() - lee.getJutsus().get("furacaoDaFolha").getConsumoDeChakra();

        lee.usarJutsu("furacaoDaFolha", naruto);

        Assertions.assertEquals(chakraEsperado, lee.getChakra());
    }

    @Test
    void ninjaAtacadoPerdeVida() {
        int vidaPerdidaEsperada = naruto.getVida() - lee.getJutsus().get("furacaoDaFolha").getDano();

        Personagem.setPossibilidadeDeDesviar(1);
        lee.usarJutsu("furacaoDaFolha", naruto);

        Assertions.assertEquals(vidaPerdidaEsperada, naruto.getVida());
    }

    @Test
    void ninjaAtacaEOutroDesvia() {
        int vidaEsperada = naruto.getVida();
        int chakraEsperado = lee.getChakra() - lee.getJutsus().get("furacaoDaFolha").getConsumoDeChakra();

        Personagem.setPossibilidadeDeDesviar(2);
        lee.usarJutsu("furacaoDaFolha", naruto);

        Assertions.assertEquals(vidaEsperada, naruto.getVida());
        Assertions.assertEquals(chakraEsperado, lee.getChakra());
    }

    @Test
    void ninjaAtacadoFicaComZeroDeVidaMesmoSeForDanoAlto() {
        int vidaEsperada = 0;

        Personagem.setPossibilidadeDeDesviar(1);
        lee.getJutsus().get("furacaoDaFolha").setDano(1000);
        lee.usarJutsu("furacaoDaFolha", naruto);

        Assertions.assertEquals(vidaEsperada, naruto.getVida());
    }
}
