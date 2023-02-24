package br.comvarejonline.projetoinicial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.comvarejonline.projetoinicial.model.MovimentacoesEstoque;

public interface MovimentacoesEstoqueRepository extends JpaRepository<MovimentacoesEstoque, Integer> {
    
}
