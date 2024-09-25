package br.com.leonardoferreira.servlet_api;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users") //mapeada para a tabela chamada users
public record User( //com um RECORD não precisamos criar explicitamente um construtor, e os metodos getters, setters, hashCode e toString / Os REDORDS são imutaveis
    @Id //indicando chave primária
    Long id,
    String username,
    String password,
    String email
) {

}