package org.techieonthenet.jba.service;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.techieonthenet.jba.entity.Article;
import org.techieonthenet.jba.entity.Blog;

import org.techieonthenet.jba.entity.Role;
import org.techieonthenet.jba.entity.User;

import org.techieonthenet.jba.repository.BlogRepository;

import org.techieonthenet.jba.repository.RoleRepository;
import org.techieonthenet.jba.repository.UserRepository;




@Service
public class InitDbService {

	@Autowired
	private UserRepository userRepository;

	

	@Autowired
	private BlogRepository blogRepository;

	@Autowired
	private RoleRepository roleRepository;

	@PostConstruct
	public void initDb() {
		
		if(roleRepository.findByName("ROLE_ADMIN")== null)
		{
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);

		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);

		User userAdmin = new User();
		userAdmin.setEnabled(true);
		userAdmin.setName("TechieOnTheNet");
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		
		userAdmin.setEmail("sg@gmail.com");
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		roles.add(roleUser);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);

		Blog blogEndy = new Blog();
		blogEndy.setName("TEST BLOG");
		blogEndy.setUrl("http://www.techieonthenet.com");
		blogEndy.setUser(userAdmin);
		blogEndy.setApproved(true);
		Date date = new Date();
		  
		blogEndy.setPublishedDate(date);
		blogRepository.save(blogEndy);

		
		}
		 
	}
}