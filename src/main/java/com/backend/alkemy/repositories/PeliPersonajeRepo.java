package com.backend.alkemy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.alkemy.model.PeliculasPersonaje;

public interface PeliPersonajeRepo extends JpaRepository <PeliculasPersonaje,Long>{
	List<PeliculasPersonaje> findAll();
	
}
