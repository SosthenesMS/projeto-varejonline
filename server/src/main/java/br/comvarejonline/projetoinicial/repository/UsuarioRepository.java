package br.comvarejonline.projetoinicial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.comvarejonline.projetoinicial.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}
