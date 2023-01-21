package org.techtestbackend.notas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;
import org.techtestbackend.CucumberSpringConfig;
import org.techtestbackend.notas.domain.RegistroNotas;
import org.techtestbackend.notas.domain.User;
import org.techtestbackend.notas.service.RegistroNotasService;
import org.techtestbackend.notas.service.UserService;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ListarNotasStep extends CucumberSpringConfig{
	
	private static final Logger logger = LoggerFactory.getLogger(ListarNotasStep.class);
	
	private String urlRegistroNotas;
	private RegistroNotas registroNotas;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RegistroNotasService registroNotasService;

	ResponseEntity<?> response;

	@Given("se necesita listar notas")
	public void se_necesita_listar_notas() {
		urlRegistroNotas = "http://localhost:8090/notas/listar";
	}
	@When("Se invoque al servicio de notas con las credenciales del usuario {string} con el password {string}")
	public void se_invoque_al_servicio_de_notas_con_las_credenciales_del_usuario_con_el_password(String usuario, String password) throws URISyntaxException {
		
		/* Precargar data  - Hay mejores formas pero por tiempo se hace asi*/
		User user = new User("usrdocente", "$2a$10$IKr5gwaHaIxPXv9g6tRJW.5fo2NQj11mij1iD9ScqSAIXQ8yI9fuK", "D001", "D");
		userService.save(user);
		user = new User("usralumno", "$2a$10$IKr5gwaHaIxPXv9g6tRJW.5fo2NQj11mij1iD9ScqSAIXQ8yI9fuK", "A001", "A");
		userService.save(user);

		user = new User("usralumno2", "$2a$10$IKr5gwaHaIxPXv9g6tRJW.5fo2NQj11mij1iD9ScqSAIXQ8yI9fuK", "A002", "A");
		userService.save(user);
		
		registroNotas = new RegistroNotas(null, "202301", "C002", "S001", "A003", "P1", 14.0);
		registroNotasService.registrarNota(registroNotas);

		registroNotas = new RegistroNotas(null, "202301", "C002", "S001", "A001", "P1", 12.0);
		registroNotasService.registrarNota(registroNotas);
		
		
		/* Se obtiene el token */
		
		String token = this.getToken(usuario, password);
		System.out.println(token);
		
		/* Se consulta servicio */
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(token);
		
		HttpEntity<RegistroNotas> request = new HttpEntity<>(registroNotas, headers);
		
		response = this.invokeRESTCallGET(urlRegistroNotas, request);
		
		logger.info("response {} :", response);

	}

	@Then("validamos el estado de ejecucion {int} y mensaje {string}")
	public void recibe_el_codigo_de_respuesta_del_servicio_y_mensaje(int statusCode, String msgRespuesta) throws Throwable {

		logger.info("state :");
		logger.info(response.getStatusCode().toString());
		logger.info("body :");
		logger.info(response.getBody().toString());

		String responseBody = (String) response.getBody();
		ObjectMapper mapper = new ObjectMapper();

		@SuppressWarnings("unchecked")
		Map<String, Object> responseMap = mapper.readValue(responseBody, Map.class);

		if(response != null && response.getStatusCode().is2xxSuccessful()) {
			assertEquals(statusCode, response.getStatusCode().value());
			assertEquals(msgRespuesta, responseMap.get("mensajeRespuesta"));
			List<RegistroNotas> data = (List<RegistroNotas>)(responseMap.get("data"));
			assertTrue(data.size()>0);
		} else {
			assertEquals(statusCode, response.getStatusCode().value());
			assertEquals(msgRespuesta, responseMap.get("message"));
		}
		
	}
	
}
