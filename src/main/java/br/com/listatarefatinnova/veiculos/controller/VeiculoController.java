package br.com.listatarefatinnova.veiculos.controller;

import br.com.listatarefatinnova.veiculos.domain.Veiculo;
import br.com.listatarefatinnova.veiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

/**
 * @author Matheus Rodrigues da Cruz
 * @version 1.0
 */
@RestController
@RequestMapping("/veiculos")
@CrossOrigin
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public ResponseEntity<List<Veiculo>> buscarVeiculosBy(
            @RequestParam(value = "marca", defaultValue = "") String marca,
            @RequestParam(value = "cor", defaultValue = "") String cor,
            @RequestParam(value = "ano", defaultValue = "0") Integer ano) {
        return ResponseEntity.ok().body(this.veiculoService.findBy(marca, cor, ano));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarVeiculoById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.veiculoService.findById(id));
    }

    @GetMapping("/total-disponiveis")
    public ResponseEntity<Integer> buscarTotalVeiculosDisponiveis() {
        return ResponseEntity.ok().body(this.veiculoService.countTotalDisponiveis());
    }

    @GetMapping("/ultima-semana")
    public ResponseEntity<List<Veiculo>> buscarRegistradoUltimaSemana() {
        return ResponseEntity.ok().body(this.veiculoService.findRegistradoUltimaSemana());
    }

    @GetMapping("/total-por-fabricante")
    public ResponseEntity<Map<String, String>> buscarTotalVeiculosPorTodosFabricante() {
        return ResponseEntity.ok().body(this.veiculoService.findTotalVeiculosPorFabricante());
    }

    @GetMapping("/{ano}/total-por-decada")
    public ResponseEntity<Integer> buscarTotalVeiculosPorDecadaByAno(@PathVariable Integer ano) {
        return ResponseEntity.ok().body(this.veiculoService.buscarTotalVeiculosPorDecadaByAno(ano));
    }

    @PostMapping
    public ResponseEntity<Veiculo> criarVeiculo(@RequestBody Veiculo veiculo) throws Exception {
        Veiculo veiculoSalvo = veiculoService.salvar(veiculo);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(veiculoSalvo.getId())
                .toUri();
        return ResponseEntity.created(uri).body(veiculoSalvo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        return ResponseEntity.ok().body(veiculoService.atualizar(id, veiculo));
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Veiculo> patchatualizarVeiculo(@PathVariable Long id, @RequestBody Veiculo veiculo) {
        return ResponseEntity.ok().body(veiculoService.atualizarVendido(id, veiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        this.veiculoService.deletarPorId(id);
        return ResponseEntity.ok().build();
    }
}
