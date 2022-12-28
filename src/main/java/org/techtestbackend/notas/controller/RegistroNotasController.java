package org.techtestbackend.notas.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.techtestbackend.notas.commons.CodigoRespuestas;
import org.techtestbackend.notas.commons.CommonsUtils;
import org.techtestbackend.notas.model.RegistroNotas;
import org.techtestbackend.notas.model.Response;
import org.techtestbackend.notas.security.SecurityUtils;
import org.techtestbackend.notas.service.RegistroNotasService;
import org.techtestbackend.notas.service.UserService;

@RestController
@RequestMapping("/notas")
public class RegistroNotasController {

	private static final Logger logger = LoggerFactory.getLogger(SecurityUtils.class);
	
	private final RegistroNotasService registroNotasService;
	
	@Autowired
	private UserService userService;

	public RegistroNotasController(RegistroNotasService registroNotasService) {
		this.registroNotasService = registroNotasService;
	}

	@PostMapping("/registrar")
	public ResponseEntity<Response> registrarNota(@Valid @RequestBody RegistroNotas registroNotas) {

		registroNotasService.registrarNota(registroNotas);
		Response response = new Response(CodigoRespuestas.REGISTRO_EXITOSO_COD, CodigoRespuestas.REGISTRO_EXITOSO_MSG,
				null);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/listar/{idAlumno}")
	public ResponseEntity<Response> getNotasByIdAlumno(@PathVariable String idAlumno) {
		List<RegistroNotas> listaNotas = registroNotasService.getNotasByIdAlumno(idAlumno);
		CommonsUtils.validarListaVacia(listaNotas, "No existen registros para idAlumno: ".concat(idAlumno));

		Response response = new Response(CodigoRespuestas.CONSULTA_EXITOSA_COD, CodigoRespuestas.CONSULTA_EXITOSA_MSG,
				listaNotas);
		return ResponseEntity.ok(response);
	}
	
	@GetMapping("/listar")
	public ResponseEntity<Response> getNotas() {
		String username = SecurityUtils.getCurrentUsername().get();
		logger.debug("*****************************=>");
		logger.debug(username);
		
		String idAlumno = userService.getIdAlumnoByUsername(username);
		logger.debug("*****************************=>");
		logger.debug(idAlumno);
		
		List<RegistroNotas> listaNotas = registroNotasService.getNotasByIdAlumno(idAlumno);
		CommonsUtils.validarListaVacia(listaNotas, "No existen registros para idAlumno: ".concat(idAlumno));

		Response response = new Response(CodigoRespuestas.CONSULTA_EXITOSA_COD, CodigoRespuestas.CONSULTA_EXITOSA_MSG,
				listaNotas);
		return ResponseEntity.ok(response);
	}
}
