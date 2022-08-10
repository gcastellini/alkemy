package com.backend.alkemy.services;

import com.backend.alkemy.model.Genero;

public interface GeneroServ {
	   Genero listarId (int id);
	   Genero add(Genero g);
	   Genero editG(Genero g);
	   Genero deleteG(int id);
}
