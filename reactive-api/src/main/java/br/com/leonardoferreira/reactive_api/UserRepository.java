package br.com.leonardoferreira.reactive_api;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

//ReactiveCrudRepository : Acessando o banco de forma reativa
public interface UserRepository extends ReactiveCrudRepository<User, Long>{
    
}
