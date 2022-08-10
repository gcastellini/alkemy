package com.backend.alkemy.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.alkemy.model.Genero;
import com.backend.alkemy.model.Personaje;
import com.backend.alkemy.repositories.GeneroRepo;
import com.backend.alkemy.services.GeneroServ;

@RestController
@RequestMapping
public class GeneroController {
  private GeneroRepo genrepo;
  private GeneroServ genserv;
  
  public GeneroController (GeneroRepo genrepo,GeneroServ genserv) {
	  this.genrepo = genrepo;
	  this.genserv = genserv;
  }
  
  @GetMapping("/generos/{id}")
	public Genero listarGeneros(@PathVariable("id") int id) {
	 return  genserv.listarId(id);
}
  
  @PostMapping("/generos")
  public Genero agregar(@RequestBody Genero g){
      return genserv.add(g);
  }
}
