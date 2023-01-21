package org.techtestbackend;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.web.client.RestTemplate;
import org.techtestbackend.notas.NotasSBApplication;
import org.techtestbackend.notas.domain.RegistroNotas;
import org.techtestbackend.notas.domain.User;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = NotasSBApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration
@Sql(scripts = "/data.sql")
public class CucumberSpringConfig {

	@Autowired(required = false)
	private TestRestTemplate testRestTemplate;
	
	@Autowired(required = false)
	private RestTemplate restTemplate;
	
	public TestRestTemplate getTestRestTemplate() {
		return testRestTemplate != null ? testRestTemplate : new TestRestTemplate();
	}

	public void setTestRestTemplate(TestRestTemplate testRestTemplate) {
		this.testRestTemplate = testRestTemplate;
	}
	
	public RestTemplate getRestTemplate() {
		return restTemplate != null ? restTemplate : new RestTemplate();
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	
	public ResponseEntity<?> invokeRESTCallPOST(String url, HttpEntity<?> requestEntity) throws URISyntaxException {
		URI uriUrl = new URI(url);
		return getTestRestTemplate().postForEntity(uriUrl, requestEntity, String.class);
	}

	public ResponseEntity<?> invokeRESTCallGET(String url, HttpEntity<?> requestEntity) throws URISyntaxException {
		URI uriUrl = new URI(url);
		return getTestRestTemplate().exchange(uriUrl, HttpMethod.GET, requestEntity, String.class);
	}
	
	public String getToken(String usuario, String password) throws URISyntaxException {
		String urlLogin = "http://localhost:8090/user/login";
		User user = new User(usuario, password, null, null);
		HttpEntity<User> request = new HttpEntity<>(user);
		URI uriUrl = new URI(urlLogin);
		ResponseEntity<?> response = getRestTemplate().postForEntity(uriUrl, request, String.class);
		return response.getBody().toString();
	}
}
