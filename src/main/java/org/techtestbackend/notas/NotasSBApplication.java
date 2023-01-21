package org.techtestbackend.notas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.techtestbackend.notas.domain.RegistroNotas;
import org.techtestbackend.notas.domain.User;
import org.techtestbackend.notas.repository.RegistroNotasRepository;
import org.techtestbackend.notas.repository.UserRepository;

@SpringBootApplication
public class NotasSBApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotasSBApplication.class, args);
		
	}
	
	@Bean
    public CommandLineRunner bootstrapData(UserRepository userRepository, RegistroNotasRepository registroNotasRepository) {
        return (args) -> {
        	User user = new User("usrdocente", "$2a$10$IKr5gwaHaIxPXv9g6tRJW.5fo2NQj11mij1iD9ScqSAIXQ8yI9fuK", "D001", "D");
        	userRepository.save(user);
    		user = new User("usralumno", "$2a$10$IKr5gwaHaIxPXv9g6tRJW.5fo2NQj11mij1iD9ScqSAIXQ8yI9fuK", "A001", "A");
    		userRepository.save(user);

    		user = new User("usralumno2", "$2a$10$IKr5gwaHaIxPXv9g6tRJW.5fo2NQj11mij1iD9ScqSAIXQ8yI9fuK", "A002", "A");
    		userRepository.save(user);
    		
    		RegistroNotas registroNotas = new RegistroNotas(null, "202301", "C003", "S001", "A003", "P1", 14.0);
    		registroNotasRepository.save(registroNotas);

    		registroNotas = new RegistroNotas(null, "202301", "C003", "S001", "A001", "P1", 12.0);
    		registroNotasRepository.save(registroNotas);
        };
    }
}
