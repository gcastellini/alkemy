package com.backend.alkemy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.alkemy.model.Peliculas;
import com.backend.alkemy.model.PeliculasPersonaje;
import com.backend.alkemy.model.Personaje;

public interface PeliPersonajeRepo extends JpaRepository <PeliculasPersonaje,Long>{
	List<PeliculasPersonaje> findAll();
	PeliculasPersonaje findBypk (int pk);
	PeliculasPersonaje save(PeliculasPersonaje pp);
	void delete(PeliculasPersonaje pp);
	
}
