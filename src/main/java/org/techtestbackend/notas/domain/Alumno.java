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
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idAlumno;
	
	@NotNull
	@Size(min=2, max=150, message="nombres debe contener de 2 a 150 caracteres")
	private String nombres;
	
	@NotNull
	@Size(min=2, max=150, message="apepateno debe contener de 2 a 150 caracteres")
	private String apepateno;
	
	private String apematerno;
	
}
