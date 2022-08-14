package com.backend.alkemy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.alkemy.model.Peliculas;

public interface PeliculaRepo extends JpaRepository <Peliculas,Long>{
	List <Peliculas> findAll();
	Peliculas findByfilmId (int filmId);
	Peliculas save(Peliculas f);
	void delete(Peliculas f);

}
