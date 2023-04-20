package br.com.listatarefatinnova.domain.logica;

public class MultiplosTresOuCinco {
    private Integer numero;

    public MultiplosTresOuCinco() {
    }

    public MultiplosTresOuCinco(Integer numero) {
        this.numero = numero;
    }

    public Integer calcularSomaMultiplosTresOuCinco() {
        Integer total = 0;
        for (int i = 0; i < numero; i++) {
            if (i%3==0 || i%5==0) {
                total+=i;
            }
        }
        return total;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}
