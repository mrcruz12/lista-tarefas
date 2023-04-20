package br.com.listatarefatinnova.domain.logica;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SpringBootTest
public class BubbleSortTest {

    private static BubbleSort bubbleSort;

    @BeforeAll
    public static void setup() {
        int [] vetor = {5, 3, 2, 4, 7, 1, 0, 6};
        bubbleSort = new BubbleSort(vetor);
    }

    @Test
    public void testBubbleSort() {
        int [] vetorOrdenado = {0, 1, 2, 3, 4, 5, 6, 7};
        bubbleSort.ordernarVetor();
        assertArrayEquals(vetorOrdenado, bubbleSort.getVetor());
    }
}
