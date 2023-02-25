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
import br.comvarejonline.projetoinicial.model.TipoUsuario;
import br.comvarejonline.projetoinicial.repository.TipoUsuarioRepository;

@RestController
@RequestMapping(value = "/tipousuarios")
public class TipoUsuarioController {

    @GetMapping
    public ResponseEntity<List<TipoUsuario>> obterTipoUsuario() {
        return ResponseEntity.status(HttpStatus.OK).body(tipoUsuarioRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<TipoUsuario>> obterTipoUsuarioPeloId(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(tipoUsuarioRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> criarTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(tipoUsuarioRepository.save(tipoUsuario));
        } catch (DataIntegrityViolationException d) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Erro, tipo de usuário já existente! " + d.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao criar novo tipo de usuário! " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<TipoUsuario> atualizarTipoUsuario(@RequestBody TipoUsuario tipoUsuario) {
        return ResponseEntity.status(HttpStatus.OK).body(tipoUsuarioRepository.save(tipoUsuario));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarTipoUsuarioPeloId(@PathVariable("id") int id) {
        tipoUsuarioRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Tipo de usuário deletado com sucesso! ");
    }

    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

}
