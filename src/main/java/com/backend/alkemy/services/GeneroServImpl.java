package com.backend.alkemy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.backend.alkemy.model.Genero;
import com.backend.alkemy.repositories.GeneroRepo;

@Service
public class GeneroServImpl implements GeneroServ{
   @Autowired
   private GeneroRepo repo;
   
   @Override
   public Genero listarId(int id){
	   return repo.findBygenID(id);
   }
   
   @Override
   public Genero add(Genero g) {
	   return repo.save(g);
   }
   
   @Override
   public Genero editG(Genero g) {
	   return repo.save(g);
   }
   
   @Override
	public Genero deleteG(int id) {
		Genero g=repo.findBygenID(id);
		if (g!=null) {
			repo.delete(g);
		}
		return g;
	}
}
