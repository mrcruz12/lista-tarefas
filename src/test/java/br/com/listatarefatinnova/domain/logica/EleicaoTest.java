package br.com.listatarefatinnova.domain.logica;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EleicaoTest {

    private static Eleicao eleicao;

    @BeforeAll
    public static void setup() {
        eleicao = new Eleicao(800, 150, 50);
    }

    @Test
    public void testVotosValidos() {
        float porcentagemVotosValidos = eleicao.getPercentualVotosValidos();
        assertEquals(80.0, porcentagemVotosValidos);
    }

    @Test
    public void testVotosValidos$2() {
        Eleicao eleicaoCopia = new Eleicao(200, eleicao.getVotosBrancos(), eleicao.getVotosNulos());
        float porcentagemVotosValidos = eleicaoCopia.getPercentualVotosValidos();
        assertEquals(50.0, porcentagemVotosValidos);
    }

    @Test
    public void testVotosBrancos() {
        float porcentagemVotosBrancos = eleicao.getPercentualVotosBrancos();
        assertEquals(15.0, porcentagemVotosBrancos);
    }

    @Test
    public void testVotosNulos() {
        float porcentagemVotosNulos = eleicao.getPercentualVotosNulos();
        assertEquals(5.0, porcentagemVotosNulos);
    }

}
