package br.com.leonardoferreira.reactive_api;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("users") // tabela que o record representa ("nome_da_tabela")
public record User (
    @Id
    Long id,
    String username,
    String password,
    String email
){


}
