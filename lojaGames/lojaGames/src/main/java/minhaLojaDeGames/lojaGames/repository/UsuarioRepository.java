package minhaLojaDeGames.lojaGames.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import minhaLojaDeGames.lojaGames.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, List>{
	
	//optional pode retornar nulo
	public Optional<Usuario> findByUsuario(String usuario);
}
