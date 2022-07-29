package com.backend.alkemy.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genero {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int genID;
	private String nombre;
	@OneToMany(mappedBy = "filmId", fetch = FetchType.EAGER)
	private Set<Peliculas> peliculas;

	public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
