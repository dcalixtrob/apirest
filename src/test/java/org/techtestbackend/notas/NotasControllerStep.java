package org.techtestbackend.notas;

import static org.junit.Assert.assertEquals;

import java.net.URISyntaxException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.techtestbackend.CucumberSpringConfig;
import org.techtestbackend.notas.model.RegistroNotas;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NotasControllerStep extends CucumberSpringConfig{
	
	private static final Logger logger = LoggerFactory.getLogger(NotasControllerStep.class);
	
	private String urlRegistroNotas;
	private RegistroNotas registroNotas;

	ResponseEntity<?> response;

	@Given("el usuario necesite registrar notas")
	public void el_usuario_necesite_registrar_notas() {
		urlRegistroNotas = "http://localhost:8090/notas/registrar";
	}

	@Given("enviamos el idCurso {string}, el idAlumno {string} y el valor de nota {double}")
	public void enviamos_el_id_curso_el_id_alumno_y_el_valor_de_nota(String idCurso, String idAlumno, Double nota) {
		registroNotas = new RegistroNotas(idAlumno, idCurso, nota);
	}

	@When("Se invoque al servicio de notas")
	public void se_invoque_al_servicio_de_notas() throws URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBasicAuth("admin", "password");
		
		HttpEntity<RegistroNotas> request = new HttpEntity<>(registroNotas, headers);
		
		response = this.invokeRESTCallPOST(urlRegistroNotas, request);
		
		logger.info("response {} :", response);
	}

	@Then("valida el estado de ejecucion {int}, el codigo de respuesta {int} y mensaje {string}")
	public void recibe_el_codigo_de_respuesta_del_servicio_y_mensaje(int statusCode, Integer codRespuesta, String msgRespuesta) throws Throwable {

		logger.info("state :");
		logger.info(response.getStatusCode().toString());
		logger.info("body :");
		logger.info(response.getBody().toString());
		
		if(response != null && response.getStatusCode().is2xxSuccessful()) {
			String responseBody = (String) response.getBody();
			ObjectMapper mapper = new ObjectMapper();

			@SuppressWarnings("unchecked")
			Map<String, String> responseMap = mapper.readValue(responseBody, Map.class);

			assertEquals(statusCode, response.getStatusCode().value());
			assertEquals(codRespuesta, responseMap.get("codRespuesta"));
			assertEquals(msgRespuesta, responseMap.get("mensajeRespuesta"));
		}
		
	}
	
}
