import br.tec.db.Carro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarroTest {

    Carro carro;

    @BeforeEach
    void inicializar(){
        carro = new Carro("BMW", "320I", "2020", "Azul", 60.0);
    }

    @Test
    void acelerarAteAVelocidadeMaxima(){
        for(int i = 0; i < 15; i++){
            carro.acelerar();
        }
        Assertions.assertEquals(carro.getVelocidadeMaxima(), carro.getVelocidadeAtual());
    }

    @Test
    void frearAteAVelocidade0NaoPodeFicarNegativa(){
        carro.acelerar();
        carro.frear();
        carro.frear();
        Assertions.assertEquals(0.0, carro.getVelocidadeAtual());
    }
}
