package br.com.listatarefatinnova.domain.logica;

public class Eleicao {
    private Integer votosValidos;
    private Integer votosBrancos;
    private Integer votosNulos;

    public Eleicao() {

    }

    public Eleicao(Integer votosValidos, Integer votosBrancos, Integer votosNulos) {
        this.votosValidos = votosValidos;
        this.votosBrancos = votosBrancos;
        this.votosNulos = votosNulos;
    }

    public float getPercentualVotosValidos() {
        return calcularPercentual(votosValidos);
    }

    public float getPercentualVotosBrancos() {
        return calcularPercentual(votosBrancos);
    }

    public float getPercentualVotosNulos() {
        return calcularPercentual(votosNulos);
    }

    private float calcularPercentual(Integer votos) {
        return votos / getUmPorcentoTotalEleitores();
    }

    private float getUmPorcentoTotalEleitores() {
        return getTotalEleitores() / 100;
    }

    public Integer getTotalEleitores() {
        return (votosBrancos + votosNulos + votosValidos);
    }

    public Integer getVotosValidos() {
        return votosValidos;
    }

    public void setVotosValidos(Integer votosValidos) {
        this.votosValidos = votosValidos;
    }

    public Integer getVotosBrancos() {
        return votosBrancos;
    }

    public void setVotosBrancos(Integer votosBrancos) {
        this.votosBrancos = votosBrancos;
    }

    public Integer getVotosNulos() {
        return votosNulos;
    }

    public void setVotosNulos(Integer votosNulos) {
        this.votosNulos = votosNulos;
    }
}
