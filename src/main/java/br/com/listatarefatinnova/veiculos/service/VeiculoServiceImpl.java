package br.com.listatarefatinnova.veiculos.service;

import br.com.listatarefatinnova.veiculos.domain.Veiculo;
import br.com.listatarefatinnova.veiculos.domain.enums.Marca;
import br.com.listatarefatinnova.veiculos.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Essa classe é responsável pela implementação da interface {@link VeiculoService}
 *
 * @author Matheus Rodrigues da Cruz
 * @version 1.0
 */
@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Override
    public Veiculo salvar(Veiculo veiculo) throws Exception {
        validarMarca(veiculo);
        return veiculoRepository.save(veiculo);
    }

    @Override
    public void deletarPorId(Long id) {
        this.veiculoRepository.deleteById(id);
    }

    @Override
    public List<Veiculo> findAll() {
        return this.veiculoRepository.findAll();
    }

    @Override
    public Veiculo findById(Long id) {
        Optional<Veiculo> optionalVeiculo = this.veiculoRepository.findById(id);
        return optionalVeiculo.isPresent() ? optionalVeiculo.get() : null;
    }

    @Override
    public List<Veiculo> findBy(String marca, String cor, Integer ano) {
        if (marca.isEmpty() && cor.isEmpty() && ano == 0) {
            return this.findAll();
        }
        String filtro = montarFiltro(marca, cor, ano);
        return null; //this.veiculoRepository.findBy(filtro);
    }

    @Override
    public Veiculo atualizar(Long id, Veiculo veiculo) {
        Veiculo veiculoParaAtualzar = findById(id);
        atualizarVeiculo(veiculoParaAtualzar, veiculo);
        return this.veiculoRepository.save(veiculoParaAtualzar);
    }

    @Override
    public Veiculo atualizarVendido(Long id, Veiculo veiculo) {
        Veiculo veiculoParaAtualzar = findById(id);
        veiculoParaAtualzar.setVendido(veiculo.getVendido());
        return this.veiculoRepository.save(veiculoParaAtualzar);
    }

    @Override
    public Integer countTotalDisponiveis() {
        return this.veiculoRepository.countTotalDisponiveis();
    }

    @Override
    public List<Veiculo> findRegistradoUltimaSemana() {
        Calendar cal = new GregorianCalendar();
        cal.add(Calendar.DAY_OF_MONTH , -7);
        Date ultimaSemana = cal.getTime();
        return veiculoRepository.findByCreatedGreaterThan(ultimaSemana);
    }

    @Override
    public Map<String, String> findTotalVeiculosPorFabricante() {
        Map<String, String> totalPorFabricante = new HashMap();
        for (Marca marca: Marca.values()) {
            Integer totalMarca = veiculoRepository.countByMarca(marca);
            totalPorFabricante.put(marca.getDescricao(), totalMarca.toString());
        }
        return totalPorFabricante;
    }

    @Override
    public Integer buscarTotalVeiculosPorDecadaByAno(Integer ano) {
        Integer anoInicioDecada = (ano / 10) * 10;
        return countByAno(anoInicioDecada, anoInicioDecada + 9);
    }

    private Integer countByAno(Integer anoInicio, Integer anoFim) {
        return veiculoRepository.countByAnoBetween(anoInicio, anoFim);
    }

    private void atualizarVeiculo(Veiculo veiculoParaAtualzar, Veiculo veiculo) {
        veiculoParaAtualzar.setVeiculo(veiculo.getVeiculo());
        veiculoParaAtualzar.setMarca(veiculo.getMarca());
        veiculoParaAtualzar.setAno(veiculo.getAno());
        veiculoParaAtualzar.setDescricao(veiculo.getDescricao());
        veiculoParaAtualzar.setVendido(veiculo.getVendido());
    }

    private String montarFiltro(String marca, String cor, Integer ano) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!marca.isEmpty()) {
            stringBuilder.append("marca = " + marca + " ");
        }
        if (!cor.isEmpty()) {
            stringBuilder.append("cor = " + cor + " ");
        }
        if (ano != 0) {
            stringBuilder.append("ano = " + ano);
        }
        return stringBuilder.toString();
    }

    private void validarMarca(Veiculo veiculo) throws Exception {
        for (Marca marca: Marca.values()) {
            if (marca.equals(veiculo.getMarca())) {
                return;
            }
        }
        throw new Exception("Marca inválida!");
    }
}
