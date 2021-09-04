package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//informa que a classe se trata de controlador
@RestController

//informa por qual URI a classe sera acessada, qualquer requisição/postagens vai consumir essa classe
//nome que usarei para ver essas informaçoes no postman
@RequestMapping("/postagens")

//informa que a classe vai aceitar requisiçoes de qualquer origem
@CrossOrigin("*")
public class PostagemController {
	
	//injeção de dependecia do Spring
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Postagem>>GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	//assim que for feita uma requisiçao do tipo get em postagem e passado um valor(id), esse metodo sera acessado
	//e ira localizar essa variavel atraves do @pathVariable q ira devolver o objeto dentro desse id ou um not found caso ele nao exista
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	//METODOS DO CRUD
	
	//seria meu READ, a leitura/pesquisa do meu CRUD 
	@GetMapping ("/titulo/{titulo}")
	public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}

	//esse recurso sera pego pelo body, cria uma nova postagem, CREATE 
	//endPoint com a função de gravar um novo produto no banco de dados
	@PostMapping
	public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	//atualização do post/dado, UPDATE
	@PutMapping
	//put atualiza o objeto inteiro, ex se for atualizar a postagem e a data uso o PUT, se fosse atualizar apenas a data seria PATCH
	//normalmente usa o PUT 
	public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
	}
	
	//DELETE
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
