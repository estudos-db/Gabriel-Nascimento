import br.tec.db.ProdutoArray;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProdutoArrayTest {

    ProdutoArray produtoArray;

    @BeforeEach
    public void iniciar(){
        produtoArray = new ProdutoArray();
    }

    @Test
    void dadoUmArrayEspecificoRetornaUmNovoComOprodutoDeCadaElementoExetoOproprio(){

        Integer[] arrayDado = {1, 2, 3, 4, 5};
        Integer[] arrayEsperado = {120, 60, 40, 30, 24};

        Assertions.assertArrayEquals(arrayEsperado, produtoArray.produtoDoArray(arrayDado));
    }

    @Test
    void dadoUmArrayVazioLancaUmaException(){

        Integer[] arrayVazio = new Integer[0];

        Assertions.assertThrows(IllegalArgumentException.class, () -> produtoArray.produtoDoArray(arrayVazio));

    }
}
