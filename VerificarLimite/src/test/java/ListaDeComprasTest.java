import br.tec.db.ListaDeCompras;
import br.tec.db.Produto;
import br.tec.db.SemLimiteException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListaDeComprasTest {

    ListaDeCompras listaDeCompras;
    Produto produto;

    @BeforeEach
    void inicializa(){
        listaDeCompras = new ListaDeCompras(100.00);
        produto = new Produto("Cadeira", 10.00);
    }

    @Test
    void comLimiteAdicionaProdutosNaLista(){

        listaDeCompras.adicionaProduto(produto);
        Assertions.assertTrue(listaDeCompras.getProdutos().contains(produto));
    }

    @Test
    void semLimiteTentaAdicionaProdutosNaLista(){

        Produto produtoCaro = new Produto("Cadeira Grande", 101.00);
        Assertions.assertThrows(SemLimiteException.class, () -> listaDeCompras.adicionaProduto(produtoCaro));
    }

    @Test
    void removeProdutosDaLista(){

        listaDeCompras.adicionaProduto(produto);
        listaDeCompras.removeProduto(produto);
        Assertions.assertFalse(listaDeCompras.getProdutos().contains(produto));
    }

    @Test
    void tentaRemoverProdutoQueNaoExisteNaLista(){

        Produto produtoForaDaLista = new Produto("teste", 5.00);
        Assertions.assertThrows(IllegalArgumentException.class, () -> listaDeCompras.removeProduto(produtoForaDaLista));
    }
}
