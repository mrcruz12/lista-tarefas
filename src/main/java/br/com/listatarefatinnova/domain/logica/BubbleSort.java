package br.com.listatarefatinnova.domain.logica;

public class BubbleSort {
    private int [] vetor;

    public BubbleSort() {

    }

    public BubbleSort(int [] vetor) {
        this.vetor = vetor;
    }

    public void ordernarVetor() {
        int vetorLength = vetor.length;
        for (int i = 1; i < vetorLength; i++) {
            for (int j = 0; j < (vetorLength - i); j++){
                validarPosicoes(j);
            }
        }
    }

    private void validarPosicoes(int indice) {
         if (vetor[indice] > vetor[indice + 1]) {
            trocarPosicoes(indice);
        }
    }

    private void trocarPosicoes(int indice) {
        int aux = vetor[indice];
        vetor[indice] = vetor[indice + 1];
        vetor[indice + 1] = aux;
    }

    public int[] getVetor() {
        return vetor;
    }

    public void setVetor(int[] vetor) {
        this.vetor = vetor;
    }
}
