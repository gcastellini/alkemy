package com.backend.alkemy.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.alkemy.model.User;

public interface UserRepo extends JpaRepository <User,Long>{
  User findByUsername (String Username);
}
