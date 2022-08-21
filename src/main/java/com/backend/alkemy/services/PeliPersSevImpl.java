package com.backend.alkemy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.alkemy.model.Peliculas;
import com.backend.alkemy.model.PeliculasPersonaje;
import com.backend.alkemy.repositories.PeliPersonajeRepo;

@Service
public class PeliPersSevImpl implements PeliPersServ {
	@Autowired
	private PeliPersonajeRepo repo;
	
	@Override
	public PeliculasPersonaje add(PeliculasPersonaje pp) {
		return repo.save(pp);
	}
	
    @Override
	public PeliculasPersonaje deletePP(int id) {
		PeliculasPersonaje pp=repo.findBypk(id);
		if (pp!=null) {
			repo.delete(pp);
		}
		return pp;
	}
	


}
