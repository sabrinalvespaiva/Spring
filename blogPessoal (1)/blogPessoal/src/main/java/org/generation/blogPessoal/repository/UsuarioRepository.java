package org.generation.blogPessoal.repository;

import java.util.List;
import java.util.Optional;

import org.generation.blogPessoal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, List>{
	//procure pelo nome do atributo usuario, optional poiq os valores podem vir nulos
	public Optional<Usuario> findByUsuario(String usuario);

}
