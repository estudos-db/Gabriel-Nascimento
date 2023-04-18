import br.tec.db.ValidadorCPF;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidadorCPFTest {

    ValidadorCPF validadorCPF = new ValidadorCPF();

    @Test
    void verificandoUmCPFCerto(){

        //CPF gerado para TESTE, mas que passa na verificação pois é uma combinação valida
        Assertions.assertTrue(validadorCPF.valida("80204582040"));
    }

    @Test
    void verificandoUmCPFErrado(){

        Assertions.assertFalse(validadorCPF.valida("84867325051"));
    }

    @Test
    void passandoUmCPFInvalido(){

        Assertions.assertThrows(IllegalArgumentException.class, () -> validadorCPF.valida("111111"));
    }
}
