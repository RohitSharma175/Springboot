package com.jpa.test;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.jpa.test.dao.UserRepository;
import com.jpa.test.entities.User;

@SpringBootApplication
public class BootjpaexampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);
		
//		create user object
//		User u = new User(1, "Rohit", "Delhi", "I am Java Developer");
//		User save = userRepository.save(u);
		
		
//		save multiple object
//		User u = new User(2, "Avnish", "UP", "I am Python Developer");
//		User u1 = new User(3, "Ashish", "MP", "I am UI Developer");
//		
//		Iterable<User> saveAll = userRepository.saveAll(List.of(u,u1));
//		saveAll.forEach(System.out::println);
//		System.out.println("Done");
		
		
//		update the user of id 3
//		Optional<User> findById = userRepository.findById(3);
//		User user = findById.get();
//		user.setName("Redmi Note 5 Pro");
//		User save = userRepository.save(user);
//		System.out.println(save);
		
//		find all 
//		Iterable<User> findAll = userRepository.findAll();
//		findAll.forEach(System.out::println);
		
//		delete the user
//		userRepository.deleteAll();
		
//		userRepository.deleteById(3);
		
//		Iterable<User> findAll = userRepository.findAll();
//		userRepository.deleteAll(findAll);
		
//		Custome finder method or drived query method  
//		List<User> findByName = userRepository.findByName("Rohit");
//		System.out.println(findByName);
	 
//		List<User> user = userRepository.findByNameStartingWith("r");
//		System.out.println(user);
		
//		List<User> user = userRepository.findByNameAndCity("Rohit", "Delhi");
//		System.out.println(user);
		
//		Native query or JPQl (java persistant query language)
//		List<User> user = userRepository.getAllUser();
//		user.forEach(System.out::println);
		
//		List<User> user = userRepository.getUserByName("Rohit");
//		user.forEach(System.out::println);
		
		userRepository.getUsers().forEach(System.out::println);
		
		
		
	}

}
