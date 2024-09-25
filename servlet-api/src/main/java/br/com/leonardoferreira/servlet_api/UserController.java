package br.com.leonardoferreira.servlet_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //expoe os endpoints REST / todos os seus dados são convertido para JSON
@RequestMapping("/users") //caminho base para a leitura das urls
public class UserController {
    
    @Autowired //trás todas as dependências da UserRepository
    UserRepository userRepository;

    @PostMapping //normalmente usado para criar novos recursos
    User create(@RequestBody User user){ //RequestBody espera um corpo de requisição
        return userRepository.save(user); //crio o um novo usuário através de um JSON e salvo no banco de dados
    }

    @GetMapping//normalmente retorna os dados
    Iterable<User> list(){
        return userRepository.findAll(); //retornando a lista

    }
}
