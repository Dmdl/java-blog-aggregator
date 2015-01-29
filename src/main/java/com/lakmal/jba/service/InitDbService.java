package com.lakmal.jba.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lakmal.jba.entity.Blog;
import com.lakmal.jba.entity.Role;
import com.lakmal.jba.entity.User;
import com.lakmal.jba.repository.BlogRepository;
import com.lakmal.jba.repository.ItemRepository;
import com.lakmal.jba.repository.RoleRepository;
import com.lakmal.jba.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BlogRepository blogRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private UserRepository userRepository;

	@Transactional
	@PostConstruct
	public void init() {
		if (roleRepository.findByName("ROLE_ADMIN") == null) {
			Role roleUser = new Role();
			roleUser.setName("ROLE_USER");
			roleRepository.save(roleUser);

			Role roleAdmin = new Role();
			roleAdmin.setName("ROLE_ADMIN");
			roleRepository.save(roleAdmin);

			User userAdmin = new User();
			userAdmin.setName("admin");
			userAdmin.setEnabled(true);
			BCryptPasswordEncoder encorder = new BCryptPasswordEncoder();
			userAdmin.setPassword(encorder.encode("admin"));
			List<Role> roles = new ArrayList<Role>();
			roles.add(roleAdmin);
			roles.add(roleUser);
			userAdmin.setRoles(roles);
			userRepository.save(userAdmin);

			Blog javavids = new Blog();
			javavids.setName("javavids");
			javavids.setUrl("http://feeds.feedburner.com/javavids?format=xml");
			javavids.setUser(userAdmin);
			blogRepository.save(javavids);

			// Item item1 = new Item();
			// item1.setBlog(javavids);
			// item1.setTitle("first");
			// item1.setLink("http://www.javavids.com/");
			// item1.setPublishedDate(new Date());
			// itemRepository.save(item1);
			//
			// Item item2 = new Item();
			// item2.setBlog(javavids);
			// item2.setTitle("second");
			// item2.setLink("http://www.javavids.com/");
			// item2.setPublishedDate(new Date());
			// itemRepository.save(item2);

		}
	}
}
