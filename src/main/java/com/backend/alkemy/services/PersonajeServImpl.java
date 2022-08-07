package com.backend.alkemy.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.alkemy.model.*;
import com.backend.alkemy.repositories.PersonajeRepo;

@Service
public class PersonajeServImpl implements PersonajeServ{

	  @Autowired
	  private PersonajeRepo repo;
	  
	  @Override
	  public Personaje listarId(int id) {
		  return repo.findBypersId(id);
	  }

	  
	  @Override 
	  public Personaje add(Personaje p) {
		  return repo.save(p);
		  
	  }

	@Override
	public Personaje editP(Personaje p) {
		return repo.save(p);
	}

	@Override
	public Personaje deleteP(int id) {
		Personaje p=repo.findBypersId(id);
		if (p!=null) {
			repo.delete(p);
		}
		return p;
	}
}


