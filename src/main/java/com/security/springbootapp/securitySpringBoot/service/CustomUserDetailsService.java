package com.security.springbootapp.securitySpringBoot.service;

import com.security.springbootapp.securitySpringBoot.model.CustomUserDetails;
import com.security.springbootapp.securitySpringBoot.model.Users;
import com.security.springbootapp.securitySpringBoot.repository.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<Users> optionalUsers = userRepository.findByName(username);
    optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
    return optionalUsers.map(CustomUserDetails::new).get();
  }

}
