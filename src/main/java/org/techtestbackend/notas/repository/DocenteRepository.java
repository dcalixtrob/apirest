package org.techtestbackend.notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.techtestbackend.notas.domain.Docente;

public interface DocenteRepository extends JpaRepository<Docente, String>{

}
