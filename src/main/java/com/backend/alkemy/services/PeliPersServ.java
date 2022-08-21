package com.backend.alkemy.services;

import com.backend.alkemy.model.PeliculasPersonaje;

public interface PeliPersServ {
	   PeliculasPersonaje add(PeliculasPersonaje pp);
	   PeliculasPersonaje deletePP(int id);
}
