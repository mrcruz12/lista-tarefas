package br.com.listatarefatinnova.domain.logica;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class FatorialTest {

    private static Fatorial fatorial;
    private static Map<Integer, Long> mapaFatoriais;

    @BeforeAll
    public static void setup() {
        fatorial = new Fatorial();
        mapaFatoriais = new HashMap<>();
        mapaFatoriais.put(0, 1L);
        mapaFatoriais.put(1, 1L);
        mapaFatoriais.put(2, 2L);
        mapaFatoriais.put(3, 6L);
        mapaFatoriais.put(4, 24L);
        mapaFatoriais.put(5, 120L);
        mapaFatoriais.put(6, 720L);
        mapaFatoriais.put(7, 5040L);
    }

    @Test
    public void testFatoriais() {
        for (Integer chave : mapaFatoriais.keySet()) {
            fatorial.setNumero(chave);
            assertEquals(mapaFatoriais.get(chave), fatorial.calcularFatorial());
        }
    }
}
