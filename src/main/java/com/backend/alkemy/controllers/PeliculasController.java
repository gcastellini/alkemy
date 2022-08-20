package com.backend.alkemy.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
  
  @PutMapping("/movies/{id}")
	 public Peliculas editarPersonajes(@RequestBody Peliculas f,@PathVariable("id") int id){
	        f.setFilmId(id);
	        return peliserv.editF(f);
	    }

@PostMapping("/movies")
public Peliculas agregar(@RequestBody Peliculas f){
    return peliserv.add(f);
}

@DeleteMapping(path = {"/movies/{id}"})
public Peliculas deleteF(@PathVariable("id") int  id){
    return peliserv.deleteF(id);
}
  @RequestMapping("/movies")
  public List filtrarPeliculas(@RequestParam(required=false) String nombre, @RequestParam(required=false) String idGenero){
	   List peliculas = new ArrayList ();
	   if (nombre == null && idGenero == null) {
		   for (int i = 0 ; i < pelirepo.findAll().size(); i++) {
			 peliculas.add(Arrays.asList(pelirepo.findAll().get(i).getImagen(),pelirepo.findAll().get(i).getTitulo(),pelirepo.findAll().get(i).getFechaCreacion()));
		   }
	   }
		   else {   for (int i = 0 ; i < pelirepo.findAll().size(); i++) {
			   String str = String.valueOf(pelirepo.findAll().get(i).getGenero().getGenID());
			   if ((pelirepo.findAll().get(i).getTitulo().equals(nombre)) || str.equals(idGenero)) {
		peliculas.add(Arrays.asList(pelirepo.findAll().get(i).getImagen(),pelirepo.findAll().get(i).getTitulo(),pelirepo.findAll().get(i).getFechaCreacion()));
			   
  }
	   }
}
	return peliculas;
}
  
}
