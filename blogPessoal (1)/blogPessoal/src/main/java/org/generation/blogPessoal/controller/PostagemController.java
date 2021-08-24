package org.generation.blogPessoal.controller;

import java.util.List;

import org.generation.blogPessoal.model.Postagem;
import org.generation.blogPessoal.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//informa que a classe se trata de controlador
@RestController
//informa por qual URI a classe sera acessada, qualquer requisição /postagens vai consumir essa classe
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

}
