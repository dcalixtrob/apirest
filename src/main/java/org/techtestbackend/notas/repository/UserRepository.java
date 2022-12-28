package org.techtestbackend.notas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.techtestbackend.notas.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
	User findByUsername(String username);
}
