/*package org.isj.ing.annuarium.webapp.Annuarium.service;


import org.isj.ing.annuarium.webapp.Annuarium.model.entities.Role;
import org.isj.ing.annuarium.webapp.Annuarium.model.entities.User;
import org.isj.ing.annuarium.webapp.Annuarium.repository.RoleRepository;
import org.isj.ing.annuarium.webapp.Annuarium.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;


@Service("userService")
public class UserService {

	private final UserRepository userRepository;
	private final RoleRepository roleRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired //injection de dépendance en fonction du constructeur
	public UserService(UserRepository userRepository,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public User saveUser(User user) {//manipule a partir des dto normalement
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));//encrytage de mdp
		user.setActive(1);

		final Role userRole = roleRepository.findByRole("ADMIN");

		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));


		return userRepository.save(user);
	}

}*/