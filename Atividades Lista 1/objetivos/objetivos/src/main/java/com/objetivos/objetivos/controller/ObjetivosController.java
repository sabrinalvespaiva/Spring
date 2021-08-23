package com.objetivos.objetivos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/objetivos")

public class ObjetivosController {
	
	@GetMapping
	public String objetivo() {
		return "Meus objetivos de aprendizagem dessa semana são: acompanhar o conteudo das aulas, "
				+ "ter atenção aos detalhes, manter o foco";
	}

}
