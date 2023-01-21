package org.techtestbackend.notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.techtestbackend.notas.domain.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, String>{

}
