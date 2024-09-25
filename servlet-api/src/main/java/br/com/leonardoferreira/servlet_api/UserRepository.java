package br.com.leonardoferreira.servlet_api;

import org.springframework.data.repository.CrudRepository;

// estendendo de CrudRepository, obtemos uma série de operações úteis para manipularmos os dados
public interface UserRepository extends CrudRepository<User, Long>{
    
}

/*
 * 
 CrudRepository é uma interface genérica do Spring Data que fornece métodos de CRUD para a entidade. Ao estender essa interface, o UserRepository ganha automaticamente esses métodos:
save(User user): Para salvar ou atualizar um usuário.
findById(Long id): Para buscar um usuário por seu ID.
findAll(): Para listar todos os usuários.
deleteById(Long id): Para deletar um usuário pelo seu ID.
E outros métodos padrão para CRUD.
<User, Long>: São os parâmetros genéricos da interface:
User: A entidade que o repositório manipula.
Long: O tipo do identificador único (id) da entidade User, que no caso é um Long.
 */
