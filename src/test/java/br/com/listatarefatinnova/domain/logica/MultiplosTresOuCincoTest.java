package br.com.listatarefatinnova.domain.logica;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MultiplosTresOuCincoTest {

    private static MultiplosTresOuCinco multiplosTresOuCinco;
    private static Map<Integer, Integer> mapa;

    @BeforeAll
    public static void setup() {
        multiplosTresOuCinco = new MultiplosTresOuCinco();
        mapa = new HashMap<>();
        mapa.put(10, 23);
        mapa.put(15, 45);
        mapa.put(20, 78);
        mapa.put(25, 143);
    }

    @Test
    public void testMultiplosTresOuCinco() {
        for (Integer chave : mapa.keySet()) {
            multiplosTresOuCinco.setNumero(chave);
            assertEquals(mapa.get(chave), multiplosTresOuCinco.calcularSomaMultiplosTresOuCinco());
        }
    }

}
