package com.luisn.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.luisn.crudspring.model.Cliente;
import com.luisn.crudspring.repository.ClienteRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}



	@Bean
	CommandLineRunner initDataBase(ClienteRepository clienteRepository){
		return args -> {
			clienteRepository.deleteAll();
			Cliente c = new Cliente();
			c.setName("Luis");
			c.setIdade(19);
			c.setCidade("Colatina");
			c.setCategoria("Estudante");

			clienteRepository.save(c);
		};
	}
}
