package minhaLojaDeGames.lojaGames.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import minhaLojaDeGames.lojaGames.model.Categoria;

public interface CategoriaRepository extends JpaRepository <Categoria, Long> {
	public List<Categoria> findAllByDescricaoContainingIgnoreCase(String descricao);

}
