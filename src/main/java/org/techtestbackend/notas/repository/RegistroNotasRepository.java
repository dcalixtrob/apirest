package org.techtestbackend.notas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.techtestbackend.notas.model.RegistroNotas;

@Repository
public interface RegistroNotasRepository extends JpaRepository<RegistroNotas, Integer>{
	
	@Query(value = "select NEW org.techtestbackend.notas.model.RegistroNotasQuery(r.idRegistroNota, r.idAlumno, r.idCurso, r.nota) "
			+ " from RegistroNotas r where r.idAlumno = ?1")
    List<RegistroNotas> getNotasByIdAlumno(String idAlumno);
}
