package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public interface JpaUserRepository extends org.springframework.data.jpa.repository.JpaRepository<User, Long>{

	User findByName(String name);

}
