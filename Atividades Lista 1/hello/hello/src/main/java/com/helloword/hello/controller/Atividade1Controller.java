package com.helloword.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class Atividade1Controller {
	
	@GetMapping
	public String hello() {
		return "Mentalidades: mentalidade de crescimento - Habilidades: Atenção aos detalhes";
	}

}


