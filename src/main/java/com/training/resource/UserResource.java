package com.training.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.bean.User;
import com.training.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserResource {
	
	@Autowired
	private UserRepository userRepository;
	//http://localhost:8001/api/users
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserId(@PathVariable Long id){
		return userRepository.findById(id);
	}
	@GetMapping("/users/address/{address}")
	public List<User> getUserByAddress(@PathVariable String address){
		
		return userRepository.findByAddress(address);
	}
	
	@DeleteMapping
	public void deleteUser(@PathVariable Long id) {
		
		userRepository.deleteById(id);
	}
	
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		User savedUser=userRepository.save(user);
		return savedUser;
		
		
	}

}
