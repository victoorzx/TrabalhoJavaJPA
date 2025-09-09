package com.victor.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

	// Executa assim que começar o programa
	@Bean
	CommandLineRunner run(PessoaRepository repo) {
		return args -> {
			// Inserções
			// id é null -> insere o registro ( insert )
			// id não é null -> atualiza o registro ( update )
			repo.save(new Pessoa(null, "João", "Silva"));
			repo.save(new Pessoa(null, "Maria", "Oliveira"));

			// Select
			System.out.println("Lista de pessoas:");
			repo.findAll().forEach(p ->
					System.out.println(p.getId() + " - " + p.getNome() + " " + p.getSobrenome())
			);
		};
	}
}
