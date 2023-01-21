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
public class DocenteCursoSeccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDocenteCursoSeccion;
	
	@NotNull
	private Integer idPeriodoCursoSeccion;
	
	@NotNull(message="idDocente no debe ser nulo")
	@Size(min=4, max=4, message="idDocente debe ser de 4 caracteres")
	private String idDocente;
	
	@NotNull
	private String estado;
	
}
