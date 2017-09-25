package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/users")
public class DemoProjectController {

	@Autowired
	private JpaUserRepository jpaUserRepository;
	
	
	@RequestMapping(value="/hello")
	public String helloWorld(){
		return "HelloWorld";
	}
	
	@GetMapping(value="/allUsers")
	public List<User> findAllUsers(){
		return jpaUserRepository.findAll();
	}
	
	@PostMapping(value="/loadData")
	public User loadData(@RequestBody User user){
		jpaUserRepository.save(user);
		return jpaUserRepository.findByName(user.getName());
	}
	
}
