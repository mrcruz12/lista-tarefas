package br.com.listatarefatinnova.veiculos.domain.enums;

public enum Marca {
    CHEVROLET("Chevrolet"),
    FORD("Ford"),
    HONDA("Honda"),
    VOLKSWAGEM("Volkswagem");

    private String descricao;

    private Marca(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
