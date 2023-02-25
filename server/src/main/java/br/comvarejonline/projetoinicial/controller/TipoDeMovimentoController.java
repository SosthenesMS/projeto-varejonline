package br.comvarejonline.projetoinicial.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.comvarejonline.projetoinicial.model.TipoDeMovimento;
import br.comvarejonline.projetoinicial.repository.TipoDeMovimentoRepository;

@RestController
@RequestMapping(value = "/tipo/movimentos")
public class TipoDeMovimentoController {

    @GetMapping
    public ResponseEntity<List<TipoDeMovimento>> obterTodosOsTiposDeMovimento() {
        return ResponseEntity.status(HttpStatus.OK).body(tipoDeMovimentoRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<TipoDeMovimento>> ObterTipoDeMovimentoPeloId(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(tipoDeMovimentoRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> criarTipoDeMovimento(@RequestBody TipoDeMovimento tipoDeMovimento) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(tipoDeMovimentoRepository.save(tipoDeMovimento));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao criar novo tipo de movimento! " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<TipoDeMovimento> atualizarTipoDeMovimento(@RequestBody TipoDeMovimento tipoDeMovimento) {
        return ResponseEntity.status(HttpStatus.OK).body(tipoDeMovimentoRepository.save(tipoDeMovimento));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarTipoDeMovimento(@PathVariable("id") int id) {
        tipoDeMovimentoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Tipo de movimento deletado com sucesso! ");
    }

    @Autowired
    private TipoDeMovimentoRepository tipoDeMovimentoRepository;

}
