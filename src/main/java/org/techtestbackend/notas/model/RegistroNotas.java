package org.techtestbackend.notas.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class RegistroNotas{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRegistroNota;

	@NotNull
	@Size(min=4, max=4, message="IdAlumno debe ser de 4 caracteres")
	private String idAlumno;
	
	@NotNull
	@Size(min=4, max=4, message="IdCurso debe ser de 4 caracteres")
	private String idCurso;
	
	@NotNull
	@DecimalMax(value="20.0", message="Nota debe ser menor o igual a 20")
	@DecimalMin(value="0.0", message="Nota debe ser mayor o igual a 0")
	private double nota;
	
	public RegistroNotas(String idAlumno, String idCurso, double nota) {
		super();
		this.idAlumno = idAlumno;
		this.idCurso = idCurso;
		this.nota = nota;
	}

	public Integer getIdRegistroNota() {
		return idRegistroNota;
	}

	public void setIdRegistroNota(Integer idRegistroNota) {
		this.idRegistroNota = idRegistroNota;
	}

	public String getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	
}
