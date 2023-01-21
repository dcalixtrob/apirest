package org.techtestbackend.notas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.techtestbackend.notas.domain.User;
import org.techtestbackend.notas.repository.UserRepository;


@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public String getIdAlumnoByUsername(String username) {
		User user = userRepository.findByUsername(username);
		if(user == null) {
			return "";
		}
		return user.getCodigo();
	}
	
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	public void save(User user) {
		userRepository.save(user);
	}
}
