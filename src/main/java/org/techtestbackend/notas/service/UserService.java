package org.techtestbackend.notas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techtestbackend.notas.model.User;
import org.techtestbackend.notas.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public String getIdAlumnoByUsername(String username) {
		User user = userRepository.findByUsername(username);
		return user.getIdAlumno();
	}
}
