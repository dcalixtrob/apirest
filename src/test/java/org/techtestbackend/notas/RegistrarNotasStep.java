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
import org.techtestbackend.notas.domain.RegistroNotas;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrarNotasStep extends CucumberSpringConfig{
	
	private static final Logger logger = LoggerFactory.getLogger(RegistrarNotasStep.class);
	
	private String urlRegistroNotas;
	private RegistroNotas registroNotas;

	ResponseEntity<?> response;

	@Given("el usuario necesite registrar notas")
	public void el_usuario_necesite_registrar_notas() {
		urlRegistroNotas = "http://localhost:8090/notas/registrar";
	}
	
	@Given("enviamos el periodo {string}, idCurso {string}, el idAlumno {string}, idSeccion {string}, tipoNota {string} y el valor de nota {double}")
	public void enviamos_el_id_curso_el_id_alumno_id_seccion_y_el_valor_de_nota(String periodo, String idCurso, String idAlumno, String idSeccion, String tipoNota, Double nota) {
		registroNotas = new RegistroNotas(null, periodo, idCurso, idSeccion, idAlumno, tipoNota, nota);
	}

	@When("Se invoque al servicio de notas con las credenciales")
	public void se_invoque_al_servicio_de_notas_con_las_credenciales() throws URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJwcnVlYmEiLCJleHAiOjE2NzUwNjExNDh9.kKxOcvR2nRQEdge2MnlWmcwwFgeYTHktts-3ihZDE3h2A0Pzvoxylw2L_gEOtSn2-tqZ2t6s-QOI6aB2oJ-b_Q");
		
		HttpEntity<RegistroNotas> request = new HttpEntity<>(registroNotas, headers);

		response = this.invokeRESTCallPOST(urlRegistroNotas, request);
		
		logger.info("response {} :", response);
	}

	@Then("valida el estado de ejecucion {int} y mensaje {string}")
	public void recibe_el_codigo_de_respuesta_del_servicio_y_mensaje(int statusCode, String msgRespuesta) throws Throwable {

		logger.info("state :");
		logger.info(response.getStatusCode().toString());
		logger.info("body :");
		logger.info(response.getBody().toString());

		String responseBody = (String) response.getBody();
		ObjectMapper mapper = new ObjectMapper();

		@SuppressWarnings("unchecked")
		Map<String, String> responseMap = mapper.readValue(responseBody, Map.class);

		if(response != null && response.getStatusCode().is2xxSuccessful()) {
			assertEquals(statusCode, response.getStatusCode().value());
			assertEquals(msgRespuesta, responseMap.get("mensajeRespuesta"));
		} else {
			assertEquals(statusCode, response.getStatusCode().value());
			assertEquals(msgRespuesta, responseMap.get("details"));
		}
		
	}
	
}
