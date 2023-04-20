package br.com.listatarefatinnova.veiculos.service;

import br.com.listatarefatinnova.veiculos.domain.Veiculo;

import java.util.List;
import java.util.Map;

/**
 * @author Matheus Rodrigues da Cruz
 * @version 1.0
 */
public interface VeiculoService {

    /**
     * metódos para salvar um novo veiculo
     * @param veiculoDTO
     * @return {@link Veiculo} que foi salvo
     */
    Veiculo salvar(Veiculo veiculoDTO) throws Exception;

    /**
     * Método que faz a deleção de um veiculo pelo id.
     * @param id
     */
    void deletarPorId(Long id);

    /**
     * Buscar todos os veiculos
     * @return lista de veiculos
     */
    List<Veiculo> findAll();

    /**
     * Buscar veiculo pelo Id
     * @param id
     * @return veiculo encontrado
     */
    Veiculo findById(Long id);

    List<Veiculo> findBy(String marca, String cor, Integer ano);
    Veiculo atualizar(Long id, Veiculo veiculo);
    Veiculo atualizarVendido(Long id, Veiculo veiculo);
    Integer countTotalDisponiveis();
    List<Veiculo> findRegistradoUltimaSemana();
    Map<String, String> findTotalVeiculosPorFabricante();
    Integer buscarTotalVeiculosPorDecadaByAno(Integer ano);
}
