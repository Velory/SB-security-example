package com.security.springbootapp.securitySpringBoot.repository;

import com.security.springbootapp.securitySpringBoot.model.Users;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users, Integer> {

  Optional<Users> findByName(String username);
}
