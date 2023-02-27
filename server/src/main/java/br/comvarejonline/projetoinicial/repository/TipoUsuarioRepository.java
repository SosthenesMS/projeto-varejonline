package br.comvarejonline.projetoinicial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.comvarejonline.projetoinicial.model.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Integer> {
    
}
