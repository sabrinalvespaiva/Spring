package org.generation.blogPessoal.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


//caso a porta 8080 esteja rodando outra aplicação, ira procurar outra porta 
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class UsuarioTest {

	public Usuario usuario;
	public Usuario usuarioErro = new Usuario();
	//public Usuario usuarioNulo = new Usuario();

	//injeção de dependencia autowired da classe validatorfactory
	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	
	Validator validator = factory.getValidator();
	
	//tem a função de inicializar os objetos antes de inciar os testes
	//esse metodo sera executado antes de todos os metodos testes criados por conta na anotação @beforeeach
	@BeforeEach
	public void start() {
		
		usuario = new Usuario(0L, "Sabrina Alves", "sabrima.mfn@gmail.com", "13465278"); 
		
	}
	
	@Test
	@DisplayName("✔ Valida Atributos Não Nulos")
	void testValidaAtributos() {

		//recebe a lista de erros capturado pelo objeto validator criante anteriormente
		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuario);

		System.out.println(violacao.toString());

		//verifica se a lista de violação esta vazia, se um dos atributos nao corresponder as anotations inseridas na classe de usuario 
		///insere erros nessa lista, se ela estiver vazia significa q nenhum erro foi encontrado e o teste vai passar 
		assertTrue(violacao.isEmpty());
	}
	
	@Test
	@DisplayName("✖ Não Valida Atributos Nulos")
	void testNaoValidarAtributos() {

		Set<ConstraintViolation<Usuario>> violacao = validator.validate(usuarioErro);
		System.out.println(violacao.toString());

		//aqui vai objeto usuario nulo que nao tem nenhum objeto criado
		//nesse caso, o teste espera que a lista esteja vazia mas ela nao esta pois passamos atributos nulos
		//o meu usuario erro esta vazio/nulo
		assertTrue(violacao.isEmpty());
	}
}
