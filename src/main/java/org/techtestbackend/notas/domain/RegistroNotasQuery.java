package org.techtestbackend.notas.domain;

import javax.persistence.Entity;

@Entity
public class RegistroNotasQuery extends RegistroNotas{

	public RegistroNotasQuery(Integer idRegistroNota, String periodo, String idCurso, String idSeccion, String idAlumno, String tipoNota, double nota) {
		super(idRegistroNota, periodo, idCurso, idSeccion, idAlumno, tipoNota, nota);
	}
	
}
