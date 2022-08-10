package com.backend.alkemy.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.backend.alkemy.model.Genero;


public interface GeneroRepo extends JpaRepository <Genero,Long>{
	List<Genero> findAll();
	Genero findBygenID (int genID);
	Genero save(Genero g);
	void delete(Genero g);

}
