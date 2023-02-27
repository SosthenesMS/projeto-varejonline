package br.comvarejonline.projetoinicial.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.comvarejonline.projetoinicial.model.MovimentacoesEstoque;
import br.comvarejonline.projetoinicial.repository.MovimentacoesEstoqueRepository;

@RestController
@RequestMapping(value = "/estoque/movimentacoes")
public class MovimentacoesEstoqueController {

    @GetMapping
    public Page<MovimentacoesEstoque> obterMovimentacoesDeEstoque(
            @RequestParam(value = "page", defaultValue = "0") String page,
            @RequestParam(value = "size", defaultValue = "10") String size) {

        Pageable paging = PageRequest.of(Integer.parseInt(page),
                Integer.parseInt(size));

        return movimentacoesEstoqueRepository.findAll(paging);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<MovimentacoesEstoque>> obterMovimentacoesDeEstoquePeloId(
            @PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(movimentacoesEstoqueRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> criarMovimentacaoDeEstoque(@RequestBody MovimentacoesEstoque movimentacoesEstoque) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(movimentacoesEstoqueRepository.save(movimentacoesEstoque));
        } catch (DataIntegrityViolationException d) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Erro ao realizar movimentação de estoque, esta movimentação já foi feita! "
                            + d.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao realizar movimentação de estoque! " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Object> atualizarMovimentacaoDeEstoque(
            @RequestBody MovimentacoesEstoque movimentacoesEstoque) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(movimentacoesEstoqueRepository.save(movimentacoesEstoque));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Erro ao atualizar esta movimentação de estoque! " + e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarMovimentacaoDeEstoque(@PathVariable("id") int id) {
        movimentacoesEstoqueRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Movimentação de estoque deletada com sucesso! ");
    }

    @Autowired
    private MovimentacoesEstoqueRepository movimentacoesEstoqueRepository;
}
