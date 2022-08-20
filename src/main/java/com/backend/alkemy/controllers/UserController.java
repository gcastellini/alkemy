package com.backend.alkemy.controllers;



import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.backend.alkemy.model.User;
import com.backend.alkemy.repositories.UserRepo;


@RestController
@RequestMapping
public class UserController {
  private UserRepo repo;
  
  public UserController (UserRepo repo) {
	  this.repo=repo;
  }
  
  @PostMapping("/auth/register")
  public ResponseEntity<?> signUp(@RequestBody User userData) {
  User user=repo.findByUsername(userData.getUsername());
  if (user == null) {	
  	userData.setPassword((userData.getPassword()));
       repo.save(userData);
      return ResponseEntity.ok(user);
  }
  else {
  	return (ResponseEntity<?>) ResponseEntity.internalServerError();
  }
  }
  @PostMapping("/auth/login")
  public ResponseEntity<?> login(@RequestBody User userData) {
  	User user=repo.findByUsername(userData.getUsername());
  	if(user.getPassword().equals(userData.getPassword()))
  		return ResponseEntity.ok(user);
  	return (ResponseEntity<?>) ResponseEntity.internalServerError();
  }
}
