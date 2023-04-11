import br.tec.db.SomaElementos;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SomaElementosTest {

    List<Integer> lista;
    Integer K;
    SomaElementos somaElementos;

    @BeforeEach
    void inicializa(){
        lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        somaElementos = new SomaElementos();
    }

    @Test
    void deveRetornarTrue(){
        K = 6;

        Assertions.assertTrue(somaElementos.somaElementos(lista, K));
    }

    @Test
    void deveRetornarFalse(){
        K = 10;

        Assertions.assertFalse(somaElementos.somaElementos(lista, K));
    }
}
