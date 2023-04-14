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
        lista = new ArrayList<>(List.of(3, 6, 5, 1, 8));
        somaElementos = new SomaElementos();
    }

    @Test
    void deveRetornarTrueExisteCombinacaoQueResultaEmK(){
        K = 16;

        Assertions.assertTrue(somaElementos.somaCombinacaoElementos(lista, K));
    }

    @Test
    void deveRetornarFalseNaoExisteCombinacaoQueResultaEmK(){
        K = 30;

        Assertions.assertFalse(somaElementos.somaCombinacaoElementos(lista, K));
    }

    @Test
    void deveRetornarFalseListaVazia(){
        K = 30;
        lista.clear();

        Assertions.assertFalse(somaElementos.somaCombinacaoElementos(lista, K));
    }
}
