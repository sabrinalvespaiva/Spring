package org.generation.blogPessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//declara que a classe se trata de uma entidade
@Entity
//cria a tabela dentro do banco de dados
@Table(name = "postagem")
public class Postagem {

	//esse atributo sera uma chave primaria
	@Id
	//como esse id se comportara na base de dados, sera um auto_increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	//determina quantos caracteres o usuario pode enviar como titulo
	@Size(min = 5, max = 100)
	private String titulo;
	
	@NotNull
	//determina quantos caracteres o usuario pode enviar como texto
	@Size(min = 10, max = 500)
	private String texto;
	
	
	//salva a data exata e os minutos da postagem
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new java.sql.Date(System.currentTimeMillis());
	
	//anotaçoes para fazer a classe tema conversar com o atributo tema
	//tema é um objeto entao é declarado como um objeto Json(entre chaves)
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	//criação dos metodos getters(pegar) e setters(definir)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
}
