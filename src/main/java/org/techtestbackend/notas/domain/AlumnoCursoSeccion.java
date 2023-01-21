package org.techtestbackend.notas.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoCursoSeccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAlumnoCursoSeccion;
	
	@NotNull
	private Integer idPeriodoCursoSeccion;
	
	@NotNull(message="IdAlumno no debe ser nulo")
	@Size(min=4, max=4, message="IdAlumno debe ser de 4 caracteres")
	private String idAlumno;
	
	@NotNull
	private String estado;
	
}
