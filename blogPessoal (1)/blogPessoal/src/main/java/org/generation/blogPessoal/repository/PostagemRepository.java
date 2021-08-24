package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//cria a classe repositorio que se comunica com db
@Repository
//JPA é uma interface que permite selecionar tudo, selecionar um dado pelo id, salvar e deletar
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
	//busca todos pelo titulo(atributo da minha entidade)
	public List <Postagem> findAllByTituloContainingIgnoreCase (String titulo);
}
