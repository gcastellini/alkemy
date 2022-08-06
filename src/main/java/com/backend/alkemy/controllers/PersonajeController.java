package com.backend.alkemy.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
   
   @GetMapping("/characters")
   public List<Personaje> personaje(){
	   List<Personaje> personaje = persRepo.findAll();
	   return personaje;
   }
}
