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
import org.techtestbackend.notas.domain.RegistroNotas;
import org.techtestbackend.notas.domain.Response;
import org.techtestbackend.notas.exception.NotFoundException;
import org.techtestbackend.notas.security.SecurityUtils;
import org.techtestbackend.notas.service.RegistroNotasService;
import org.techtestbackend.notas.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/notas")
@Api( tags = "Servicios de Notas")
public class RegistroNotasController {

	private static final Logger logger = LoggerFactory.getLogger(SecurityUtils.class);
	
	private final RegistroNotasService registroNotasService;
	
	@Autowired
	private UserService userService;

	public RegistroNotasController(RegistroNotasService registroNotasService) {
		this.registroNotasService = registroNotasService;
	}

	@ApiOperation(value = "Servicio para registrar notas")
	@PostMapping("/registrar")
	public ResponseEntity<Response> registrarNota(@Valid @RequestBody RegistroNotas registroNotas) {
		logger.info("Servicio registrarNota");
		registroNotasService.registrarNota(registroNotas);
		Response response = new Response(CodigoRespuestas.REGISTRO_EXITOSO_COD, CodigoRespuestas.REGISTRO_EXITOSO_MSG,
				null);
		return ResponseEntity.ok(response);
	}

	@ApiOperation(value = "Servicio para listar las notas de un alumno")
	@GetMapping("/listar/{idAlumno}")
	public ResponseEntity<Response> getNotasByIdAlumno(@PathVariable String idAlumno) {
		logger.info("Servicio getNotasByIdAlumno");
		List<RegistroNotas> listaNotas = registroNotasService.getNotasByIdAlumno(idAlumno);
		CommonsUtils.validarListaVacia(listaNotas, "No existen registros para idAlumno: ".concat(idAlumno));

		Response response = new Response(CodigoRespuestas.CONSULTA_EXITOSA_COD, CodigoRespuestas.CONSULTA_EXITOSA_MSG,
				listaNotas);
		return ResponseEntity.ok(response);
	}
	
	@ApiOperation(value = "Servicio para listar las notas del alumno autentificado")
	@GetMapping("/listar")
	public ResponseEntity<Response> getNotas() {
		logger.info("Servicio getNotas");
		String username = SecurityUtils.getCurrentUsername().get();
		this.validarUser(username);
		
		String idAlumno = userService.getIdAlumnoByUsername(username);
		
		List<RegistroNotas> listaNotas = registroNotasService.getNotasByIdAlumno(idAlumno);
		CommonsUtils.validarListaVacia(listaNotas, "No existen registros para idAlumno: ".concat(idAlumno));

		Response response = new Response(CodigoRespuestas.CONSULTA_EXITOSA_COD, CodigoRespuestas.CONSULTA_EXITOSA_MSG,
				listaNotas);
		return ResponseEntity.ok(response);
	}
	
	void validarUser(String username) {
		if(username.isEmpty()) {
			throw new NotFoundException("usuario no existe");	
		}
		
	}
}
