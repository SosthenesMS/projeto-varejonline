package br.comvarejonline.projetoinicial.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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
import br.comvarejonline.projetoinicial.model.TipoDocumento;
import br.comvarejonline.projetoinicial.repository.TipoDocumentoRepository;

@RestController
@RequestMapping(value = "/tipo/documentos")
public class TipoDocumentoController {

    @GetMapping
    public ResponseEntity<List<TipoDocumento>> obterTodosOsTiposDeDocumentos() {
        return ResponseEntity.status(HttpStatus.OK).body(tipoDocumentoRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<TipoDocumento>> obterTipoDocumentoPeloId(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(tipoDocumentoRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> criarTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(tipoDocumentoRepository.save(tipoDocumento));
        } catch (DataIntegrityViolationException d) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro ao criar, tipo já existente! " + d.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar novo tipo de documento! " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<TipoDocumento> atualizarTipoDocumento(@RequestBody TipoDocumento tipoDocumento) {
        return ResponseEntity.status(HttpStatus.OK).body(tipoDocumentoRepository.save(tipoDocumento));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarTipoDocumento(@PathVariable("id") int id) {
        tipoDocumentoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Tipo de documento deletado com sucesso! ");
    }

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;
}
