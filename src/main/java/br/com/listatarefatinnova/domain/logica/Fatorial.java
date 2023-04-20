package br.com.listatarefatinnova.domain.logica;

public class Fatorial {
    private Integer numero;

    public Fatorial() {
    }

    public Fatorial(Integer numero) {
        this.numero = numero;
    }

    public Long calcularFatorial() {
        Long fatorial = 1L;
        for (int i = 1; i <= numero; i++) {
            fatorial *= i;
        }
        return fatorial;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

}
