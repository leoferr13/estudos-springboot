package br.com.leonardoferreira.reactive_api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ReactiveApiApplicationTests {

	@Autowired
	private WebTestClient webTestClient; //teste Web

	@Test
	void contextLoads() {
		User user = new User(null, "user", "123456", "user@email.com");
		
		//lembrando que estamos testando de forma assincrona, ou seja, precisamos colocar o que vamos testar
		webTestClient.post().uri("/users").bodyValue(user) //criando requisição POST, na rui .users e com o corpo user
		.exchange() //faça a requisição
		.expectStatus().is2xxSuccessful() // esperando um resposta 200
		.expectBody(User.class) //esperamos um corpo de resposta do tipo USER
		.value(postResponse -> { //retorno do item
			assertNotNull(postResponse.id()); 
			assertEquals(user.username(), postResponse.username()); 
			assertEquals(user.password(), postResponse.password());
			assertEquals(user.email(), postResponse.email());
		});

		webTestClient.get().uri("/users")
		.exchange()
		.expectStatus().is2xxSuccessful()
		.expectBodyList(User.class) //trazendo uma lista de usuários
		.value(getResponses -> { //retorno da lista
			User getResponse = getResponses.get(0); // pegando o primeiro item da lista, que basta.
			assertNotNull(getResponse.id()); // 
			assertEquals(user.username(), getResponse.username()); 
			assertEquals(user.password(), getResponse.password());
			assertEquals(user.email(), getResponse.email());
		});

	}
 
}
