package br.comvarejonline.projetoinicial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.comvarejonline.projetoinicial.model.TipoDeMovimento;

public interface TipoDeMovimentoRepository extends JpaRepository<TipoDeMovimento, Integer> {

}
