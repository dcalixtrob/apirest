package org.techtestbackend.notas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.techtestbackend.notas.domain.RegistroNotas;

@Repository
public interface RegistroNotasRepository extends JpaRepository<RegistroNotas, Integer>{
	
	@Query(value = "select NEW org.techtestbackend.notas.domain.RegistroNotasQuery(r.idRegistroNota, r.periodo, r.idCurso, r.idSeccion, r.idAlumno, r.tipoNota, r.nota) "
			+ " from RegistroNotas r where r.idAlumno = ?1")
    List<RegistroNotas> getNotasByIdAlumno(String idAlumno);
}
