package com.backend.alkemy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.alkemy.model.Peliculas;
import com.backend.alkemy.repositories.PeliculaRepo;

@Service
public class PeliculasServImpl implements PeliculasServ {
	@Autowired
	private PeliculaRepo repo;
	
	@Override
	public Peliculas listarId(int id) {
		  return repo.findByfilmId(id);
	  }
	
	@Override
	public Peliculas add(Peliculas f) {
		  return repo.save(f);
		  
	  }
	@Override
	public Peliculas editF(Peliculas f) {
		return repo.save(f);
	}
	
	@Override
	public Peliculas deleteF(int id) {
		Peliculas f=repo.findByfilmId(id);
		if (f!=null) {
			repo.delete(f);
		}
		return f;
	}

}
