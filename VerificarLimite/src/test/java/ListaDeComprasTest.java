import br.tec.db.Produto;
import br.tec.db.SemLimiteException;
import br.tec.db.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ListaDeComprasTest {

    User user;
    Produto produto;

    @BeforeEach
    void inicializa(){
        user = new User("Gabriel", 100.0);
        produto = new Produto("Cadeira", 10.00);
    }

    @Test
    void comLimiteAdicionaProdutosNaLista(){

        user.adicionaProdutoNaLista(produto);
        Assertions.assertTrue(user.getListaDeCompras().getProdutos().contains(produto));
    }

    @Test
    void semLimiteTentaAdicionaProdutosNaLista(){

        Produto produtoCaro = new Produto("Cadeira Grande", 101.00);
        Assertions.assertThrows(SemLimiteException.class, () -> user.adicionaProdutoNaLista(produtoCaro));
    }

    @Test
    void removeProdutosDaLista(){

        user.adicionaProdutoNaLista(produto);
        user.removeProdutoDaLista(produto);
        Assertions.assertFalse(user.getListaDeCompras().getProdutos().contains(produto));
    }

    @Test
    void tentaRemoverProdutoQueNaoExisteNaLista(){

        Produto produtoForaDaLista = new Produto("teste", 5.00);
        Assertions.assertThrows(IllegalArgumentException.class, () -> user.removeProdutoDaLista(produtoForaDaLista));
    }
}
