package com.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.bean.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findByAddress(String address);
	User findByUserName(String username);

}
