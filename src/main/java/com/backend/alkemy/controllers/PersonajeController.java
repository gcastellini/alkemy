package com.backend.alkemy.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.alkemy.repositories.PersonajeRepo;
import com.backend.alkemy.services.PersonajeServ;
import com.backend.alkemy.model.*;

@RestController
@RequestMapping
public class PersonajeController {
   private PersonajeRepo  persRepo;
  private PersonajeServ persServ;
   
   public PersonajeController(PersonajeRepo persRepo, PersonajeServ persServ) {
	   this.persRepo = persRepo;
	   this.persServ = persServ;
   }
   
   @GetMapping("/characters/{id}")
  	public Personaje listarPersonajes(@PathVariable("id") int id) {
  	 return  persServ.listarId(id);
  }
   
   @PutMapping("/characters/{id}")
 	 public Personaje editarPersonajes(@RequestBody Personaje p,@PathVariable("id") int id){
 	        p.setPersId(id);
 	        return persServ.editP(p);
 	    }
   
   @PostMapping("/characters")
   public Personaje agregar(@RequestBody Personaje p){
       return persServ.add(p);
   }
   
   @DeleteMapping(path = {"/characters/{id}"})
   public Personaje deleteP(@PathVariable("id") int  id){
       return persServ.deleteP(id);
   }
   
   @RequestMapping("/characters")
   public List filtrarPersonajes(@RequestParam(required=false) String nombre, @RequestParam(required=false) String edad ){
	   List personajes = new ArrayList ();
	   if (nombre == null && edad == null) {
		   for (int i = 0 ; i < persRepo.findAll().size(); i++) {
			 personajes.add(Arrays.asList(persRepo.findAll().get(i).getNombre(),persRepo.findAll().get(i).getImagen()));
		   }
	   }
		   else {   for (int i = 0 ; i < persRepo.findAll().size(); i++) {
			   if ((persRepo.findAll().get(i).getNombre().equals(nombre)) || (persRepo.findAll().get(i).getEdad().equals(edad))) {
		personajes.add(Arrays.asList(persRepo.findAll().get(i).getNombre(),persRepo.findAll().get(i).getImagen()));
			   
   }
	   }
}
	return personajes;
}
}