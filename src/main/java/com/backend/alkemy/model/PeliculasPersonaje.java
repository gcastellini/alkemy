package com.backend.alkemy.model;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "peliculas_personaje")
@AssociationOverrides({@AssociationOverride(name= "pk.personaje",joinColumns = @JoinColumn(name ="persId")),
	@AssociationOverride(name="pk.pelicula",joinColumns=@JoinColumn(name="filmId"))})
public class PeliculasPersonaje implements Serializable{
	
private PeliculasPersonajeId pk = new PeliculasPersonajeId();
private int peliculasId;
private int personajesId;

  @EmbeddedId
	public PeliculasPersonajeId getPk() {
		return pk;
	}

	public void setPk(PeliculasPersonajeId pk) {
		this.pk = pk;
	}
	    

	public Personaje getPersonaje() {
		return getPk().getPersonaje();
	}

	public void setPersonaje(Personaje personaje) {
		getPk().setPersonaje(personaje);
	}

	public Peliculas getPelicula() {
		return getPk().getPelicula();
	}

	public void setPelicula(Peliculas pelicula) {
		getPk().setPelicula(pelicula);
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		PeliculasPersonaje that = (PeliculasPersonaje) o;

		if (getPk() != null ? !getPk().equals(that.getPk())
				: that.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}

	public int getPeliculasId() {
		return peliculasId;
	}

	public void setPeliculasId(int peliculasId) {
		this.peliculasId = peliculasId;
	}

	public int getPersonajesId() {
		return personajesId;
	}

	public void setPersonajesId(int personajesId) {
		this.personajesId = personajesId;
	}


}
