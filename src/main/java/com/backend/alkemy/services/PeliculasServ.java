package com.backend.alkemy.services;

import com.backend.alkemy.model.Peliculas;

public interface PeliculasServ {
	   Peliculas listarId (int id);
	   Peliculas add(Peliculas f);
	   Peliculas editF(Peliculas f);
	   Peliculas deleteF(int id);
	   
}
