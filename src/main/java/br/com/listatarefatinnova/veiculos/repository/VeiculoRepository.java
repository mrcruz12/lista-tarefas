package br.com.listatarefatinnova.veiculos.repository;

import br.com.listatarefatinnova.veiculos.domain.Veiculo;
import br.com.listatarefatinnova.veiculos.domain.enums.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    @Query("SELECT count(v) FROM Veiculo v WHERE v.vendido = false")
    Integer countTotalDisponiveis();
    List<Veiculo>  findByCreatedGreaterThan(Date ultimaSemana);
    Integer countByMarca(Marca marca);
    Integer countByAnoBetween(Integer anoInicio, Integer anoFim);
}
