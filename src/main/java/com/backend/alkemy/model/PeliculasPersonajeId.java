package com.backend.alkemy.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Embeddable
public class PeliculasPersonajeId implements Serializable{
    private Personaje personaje;
    private Peliculas pelicula;
 
    @ManyToOne
    public Personaje getPersonaje() {
    	return personaje;
    }
    
    public void setPersonaje(Personaje personaje) {
    	this.personaje=personaje;
    }
    
    @ManyToOne
    public Peliculas getPelicula() {
    	return pelicula;
    }
    
    public void setPelicula(Peliculas pelicula) {
    	this.pelicula=pelicula;
    }
    
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PeliculasPersonajeId that = (PeliculasPersonajeId) o;

        if (personaje != null ? !personaje.equals(that.personaje) : that.personaje != null) return false;
        if (pelicula != null ? !pelicula.equals(that.pelicula) : that.pelicula != null)
            return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (personaje != null ? personaje.hashCode() : 0);
        result = 31 * result + (pelicula != null ? pelicula.hashCode() : 0);
        return result;
    }

}
