package com.backend.alkemy.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.data.repository.core.support.PersistenceExceptionTranslationRepositoryProxyPostProcessor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.alkemy.repositories.PeliPersonajeRepo;
import com.backend.alkemy.repositories.PeliculaRepo;
import com.backend.alkemy.repositories.PersonajeRepo;
import com.backend.alkemy.services.PersonajeServ;
import com.backend.alkemy.model.*;

@RestController
@RequestMapping
public class PersonajeController {
   private PersonajeRepo  persRepo;
  private PersonajeServ persServ;
  private  PeliPersonajeRepo pelipersrepo;
  
   
   public PersonajeController(PersonajeRepo persRepo, PersonajeServ persServ, PeliculaRepo pelirepo, PeliPersonajeRepo pelipersrepo) {
	   this.persRepo = persRepo;
	   this.persServ = persServ;
	   this.pelipersrepo=pelipersrepo;
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
   
   
   @GetMapping("/characters")
   public List filtrarPersonajes(@RequestParam(required=false) String nombre, @RequestParam(required=false) String edad,@RequestParam (required=false) String idMovie ){
	   List personajes = new ArrayList ();
	   if (nombre == null && edad == null && idMovie == null) {
		   for (int i = 0 ; i < persRepo.findAll().size(); i++) {
			 personajes.add(Arrays.asList(persRepo.findAll().get(i).getNombre(),persRepo.findAll().get(i).getImagen()));
		   }
	   }
		   else {   for (int i = 0 ; i < pelipersrepo.findAll().size(); i++) {
			   String str= String.valueOf(pelipersrepo.findAll().get(i).getPk().getPelicula().getFilmId());
			   if ((pelipersrepo.findAll().get(i).getPk().getPersonaje().getNombre().equals(nombre)) || (pelipersrepo.findAll().get(i).getPk().getPersonaje().getEdad().equals(edad)) || str.equals(idMovie)) {
		personajes.add(Arrays.asList(persRepo.findAll().get(i).getNombre(),persRepo.findAll().get(i).getImagen()));
			   
   }
	   }
		   
}
	return personajes;
}
}