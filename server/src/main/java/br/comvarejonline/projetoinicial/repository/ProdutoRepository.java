package br.comvarejonline.projetoinicial.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import br.comvarejonline.projetoinicial.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    Page<Produto> findAll(Pageable pageable);
}
