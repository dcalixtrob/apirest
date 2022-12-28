package org.techtestbackend.notas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techtestbackend.notas.model.RegistroNotas;
import org.techtestbackend.notas.repository.RegistroNotasRepository;

@Service
@Transactional
public class RegistroNotasService {
	
	@Autowired
	RegistroNotasRepository registroNotasRepository;

	public void registrarNota(RegistroNotas registroNotas) {
		registroNotasRepository.save(registroNotas);
	}
	
	public List<RegistroNotas> getNotasByIdAlumno(String idAlumno) {
		return registroNotasRepository.getNotasByIdAlumno(idAlumno);
	}
}
