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
    void atacaOutroNinjaEEleDesvia(){
        int vidaOutroNinjaEsperada = naruto.getVida();
        int chakraPerdidoDeQuemAtacou = lee.getChakra() - lee.getJutsus().get("furacaoDaFolha").getConsumoDeChakra();

        Personagem.setPossibilidadeDeDesviar(2);
        lee.usarJutsu("furacaoDaFolha", naruto);

        Assertions.assertEquals(vidaOutroNinjaEsperada, naruto.getVida());
        Assertions.assertEquals(chakraPerdidoDeQuemAtacou, lee.getChakra());
    }

    @Test
    void atacaOutroNinja(){
        int vidaOutroNinjaEsperada = naruto.getVida() - lee.getJutsus().get("furacaoDaFolha").getDano();
        int chakraPerdidoDeQuemAtacou = lee.getChakra() - lee.getJutsus().get("furacaoDaFolha").getConsumoDeChakra();

        Personagem.setPossibilidadeDeDesviar(1);
        lee.usarJutsu("furacaoDaFolha", naruto);

        Assertions.assertEquals(vidaOutroNinjaEsperada, naruto.getVida());
        Assertions.assertEquals(chakraPerdidoDeQuemAtacou, lee.getChakra());
    }
    @Test
    void atacaOutroNinjaAteZerarAVida(){
        int vidaOutroNinjaEsperada = 0;

        Personagem.setPossibilidadeDeDesviar(1);
        lee.getJutsus().get("furacaoDaFolha").setDano(101);
        lee.usarJutsu("furacaoDaFolha", naruto);

        Assertions.assertEquals(vidaOutroNinjaEsperada, naruto.getVida());
    }

    @Test
    void ninjaTentaAtacarSemChakraSuficiente(){
        int chakraEsperado = lee.getChakra();

        Personagem.setPossibilidadeDeDesviar(1);
        lee.getJutsus().get("furacaoDaFolha").setConsumoDeChakra(101);
        lee.usarJutsu("furacaoDaFolha", naruto);

        Assertions.assertEquals(chakraEsperado, lee.getChakra());
    }
}
