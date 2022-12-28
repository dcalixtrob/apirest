package org.techtestbackend;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.techtestbackend.notas.NotasSBApplication;

import io.cucumber.spring.CucumberContextConfiguration;

@CucumberContextConfiguration
@SpringBootTest(classes = NotasSBApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ContextConfiguration
public class CucumberSpringConfig {

	@Autowired(required = false)
	private TestRestTemplate restTemplate;
	
	public TestRestTemplate getRestTemplate() {
		return restTemplate != null ? restTemplate : new TestRestTemplate();
	}

	public void setRestTemplate(TestRestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public ResponseEntity<?> invokeRESTCallPOST(String url, HttpEntity<?> requestEntity) throws URISyntaxException {
		URI uriUrl = new URI(url);
		return getRestTemplate().postForEntity(uriUrl, requestEntity, String.class);
	}

}
