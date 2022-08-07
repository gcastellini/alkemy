package com.backend.alkemy.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.alkemy.repositories.PersonajeRepo;
import com.backend.alkemy.model.*;

@RestController
@RequestMapping
public class PersonajeController {
   private PersonajeRepo  persRepo;
   
   public PersonajeController(PersonajeRepo persRepo) {
	   this.persRepo = persRepo;
   }
   
  /*
   @GetMapping("/characters")
   public List<Personaje> personaje(){
	   List<Personaje> personaje = persRepo.findAll();
	   return personaje;
	     }
	     */
	        
   @RequestMapping("/characters")
   public List<Personaje> filtrarPersonajes(@RequestParam(required=false) String nombre, @RequestParam(required=false) String edad ){
	   if (nombre == null && edad == null) {
		   List<Personaje> personaje = persRepo.findAll();
			  return personaje;
	   }
	   else {
	  List<Personaje> personaje = persRepo.findAll();
	  Predicate<Personaje> filtroNombre=(p)->p.getNombre().equals(nombre);
	  Predicate<Personaje> filtroEdad=(p)->p.getEdad().equals(edad);
	  List <Personaje> filtrado =personaje.stream().filter(filtroNombre.or(filtroEdad)).map(p-> new Personaje(p.getNombre(),p.getImagen()));
	  }
   }
}
