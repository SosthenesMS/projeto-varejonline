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
import br.comvarejonline.projetoinicial.model.Produto;
import br.comvarejonline.projetoinicial.repository.ProdutoRepository;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoController {

    @GetMapping
    public Page<Produto> obterTodosOsProdutos(
            @RequestParam(value = "page", defaultValue = "0") String page,
            @RequestParam(value = "size", defaultValue = "10") String size) {

        Pageable paging = PageRequest.of(Integer.parseInt(page),
                Integer.parseInt(size));

        return produtoRepository.findAll(paging);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Produto>> obterProdutosPeloId(@PathVariable("id") int id) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Object> criarProduto(@RequestBody Produto produto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
        } catch (DataIntegrityViolationException d) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Erro ao criar, este produto já existente! " + d.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar novo produto! " + e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<Object> atualizarProduto(@RequestBody Produto produto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar o produto! " + e.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable("id") int id) {
        produtoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso! ");
    }

    @Autowired
    private ProdutoRepository produtoRepository;
}
