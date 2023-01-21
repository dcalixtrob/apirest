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
public class PeriodoCursoSeccion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPeriodoCursoSeccion;
	
	@NotNull(message="periodo no debe ser nulo")
	@Size(min=6, max=6, message="periodo debe ser de 6 caracteres")
	private String periodo;
	
	
	@NotNull(message="idCurso no debe ser nulo")
	@Size(min=4, max=4, message="IdCurso debe ser de 4 caracteres")
	private String idCurso;
	
	@NotNull(message="idSeccion no debe ser nulo")
	@Size(min=4, max=4, message="idSeccion debe ser de 4 caracteres")
	private String idSeccion;
	
	@NotNull(message="estado no debe ser nulo")
	private String estado;
	
}
