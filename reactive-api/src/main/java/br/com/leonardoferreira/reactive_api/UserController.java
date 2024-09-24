package br.com.leonardoferreira.reactive_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {
    
@Autowired
UserRepository userRepository;

    @PostMapping
    Mono<User> create(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping 
    Flux<User> list() { //Iterable é a mesmo coisa que uma coleção
        return userRepository.findAll();
    }
}

/*
 * Mono : Em algum momento retorna a informação do user, como é assincrono, não sabemos em que momento o dado sera retornado
 * Flux : Retorna uma lista a qualquer momento (assincrono)
 */