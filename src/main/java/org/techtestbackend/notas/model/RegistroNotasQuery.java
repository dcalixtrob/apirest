package org.techtestbackend.notas.model;

import javax.persistence.Entity;

@Entity
public class RegistroNotasQuery extends RegistroNotas{

	public RegistroNotasQuery(Integer idRegistroNota, String idAlumno, String idCurso, double nota) {
		super(idAlumno, idCurso, nota);
		this.setIdRegistroNota(idRegistroNota);
	}
	
}
