package br.comvarejonline.projetoinicial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.comvarejonline.projetoinicial.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
