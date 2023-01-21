package org.techtestbackend.notas.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
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
public class RegistroNotas{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idRegistroNota;

	@NotNull(message="periodo no debe ser nulo")
	@Size(min=6, max=6, message="periodo debe ser de 6 caracteres")
	private String periodo;
	
	
	@NotNull(message="idCurso no debe ser nulo")
	@Size(min=4, max=4, message="IdCurso debe ser de 4 caracteres")
	private String idCurso;
	
	@NotNull(message="idSeccion no debe ser nulo")
	@Size(min=4, max=4, message="idSeccion debe ser de 4 caracteres")
	private String idSeccion;
	
	@NotNull(message="IdAlumno no debe ser nulo")
	@Size(min=4, max=4, message="IdAlumno debe ser de 4 caracteres")
	private String idAlumno;
	
	@NotNull(message="tipoNota no debe ser nulo")
	@Size(min=2, max=2, message="tipoNota debe ser de 2 caracteres")
	private String tipoNota;
	
	
	@NotNull(message="nota no debe ser nulo")
	@DecimalMax(value="20.0", message="Nota debe ser menor o igual a 20")
	@DecimalMin(value="0.0", message="Nota debe ser mayor o igual a 0")
	private double nota;
	
}
