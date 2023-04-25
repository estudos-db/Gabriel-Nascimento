import br.tec.db.NinjaDeGenjutsu;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class NinjasTest {

    NinjaDeGenjutsu ninjaGenjutsu;
    private final ByteArrayOutputStream stringMostrada = new ByteArrayOutputStream();

    @BeforeEach
    void inicializa() {
        ninjaGenjutsu = new NinjaDeGenjutsu("Itachi", 18, "Folha", 150);
        System.setOut(new PrintStream(stringMostrada));
    }

    @Test
    void usaOMetodoUsarJutsuEMostraMensagem() {
        ninjaGenjutsu.usarJutsu();
        Assertions.assertEquals("Usando um jutsu de Genjutsu\r\n", stringMostrada.toString());
    }

    @Test
    void usaOMetodoDesviarEMostraMensagem() {
        ninjaGenjutsu.desviar();
        Assertions.assertEquals("Desviando de um ataque usando Genjutsu\r\n", stringMostrada.toString());
    }

    @Test
    void aumentaChakraDoNinja() {
        ninjaGenjutsu.aumentaChakra(50);
        Assertions.assertEquals(200, ninjaGenjutsu.getChakra());
    }

    @Test
    void adicionandoJutsusNoArrayDeJutsus() {
        ninjaGenjutsu.adicionaJutsu("Tsukuyomi");
        Assertions.assertEquals(1, ninjaGenjutsu.getJutsus().length);
    }
}
