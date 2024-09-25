package br.com.leonardoferreira.servlet_api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT) //criando um ambiante web com uma porta aleatória
class ServletApiApplicationTests {

	@Autowired
	TestRestTemplate restTemplate; //template próprio para testes

	@Test
	void test() {
		User user = new User(null, "user", "123456", "user@email.com");
		User postResponse = restTemplate.postForObject("/users", user, User.class); //criando um post com base na [chamando o usuário cadastrado, pegando apenas 1, tipo_do_retorno], retornando a resposta do post

		//como meu usuário não tem ID, tenho que verificar um por um
		assertNotNull(postResponse.id()); //verificando se o meu usuário tem ID
		assertEquals(user.username(), postResponse.username()); //verifica se meu usuário tem um user
		assertEquals(user.email(), postResponse.email());
		assertEquals(user.password(), postResponse.password());

		User[] getResponses = restTemplate.getForObject("/users", User[].class); //pegando um item usuário e colocando em uma lista
		User getResponse = getResponses[0];
	
		assertNotNull(getResponse.id()); //verificando se o meu usuário tem ID
		assertEquals(user.username(), getResponse.username()); //verifica se meu usuário tem um user
		assertEquals(user.email(), getResponse.email());
		assertEquals(user.password(), getResponse.password());}
	

}
