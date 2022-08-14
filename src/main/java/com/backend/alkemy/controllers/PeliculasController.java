package com.backend.alkemy.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.alkemy.model.Peliculas;
import com.backend.alkemy.model.Personaje;
import com.backend.alkemy.repositories.PeliculaRepo;
import com.backend.alkemy.services.PeliculasServ;

@RestController
@RequestMapping
public class PeliculasController {
  private PeliculasServ peliserv;
  private PeliculaRepo pelirepo;
  
  public PeliculasController (PeliculasServ peliserv, PeliculaRepo pelirepo) {
	  this.peliserv=peliserv;
	  this.pelirepo=pelirepo;
  }
  
  @GetMapping("/movies/{id}")
	public Peliculas listarPeliculas(@PathVariable("id") int id) {
	 return  peliserv.listarId(id);
}
  @RequestMapping("/movies")
  public List filtrarPeliculas(@RequestParam(required=false) String nombre, @RequestParam(required=false) int idGenero ){
	   List peliculas = new ArrayList ();
	   if (nombre == null && idGenero == 0) {
		   for (int i = 0 ; i < pelirepo.findAll().size(); i++) {
			 peliculas.add(Arrays.asList(pelirepo.findAll().get(i).getImagen(),pelirepo.findAll().get(i).getTitulo()));
		   }
	   }
		   else {   for (int i = 0 ; i < pelirepo.findAll().size(); i++) {
			   if ((pelirepo.findAll().get(i).getTitulo().equals(nombre)) || (pelirepo.findAll().get(i).getGenero().getGenID().equals(idGenero))) {
		peliculas.add(Arrays.asList(pelirepo.findAll().get(i).getTitulo(),pelirepo.findAll().get(i).getTitulo()));
			   
  }
	   }
}
	return peliculas;
}
  
}
