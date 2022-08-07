package com.backend.alkemy.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Personaje {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int persId;
	private byte[] imagen;
	private String nombre;
	private String edad;
	private String peso;
	private String historia;
	@ManyToMany(mappedBy = "personajes", fetch = FetchType.EAGER)
	private Set<Peliculas> pelicula;
	
	public Set<Peliculas> getPeliculas(){
		return pelicula;
	}
    
	 public long getPersId() {
	        return persId;
	    }

	    public void setPersId(int persId) {
	        this.persId = persId;
	    }
	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }
	    
	    public String getEdad() {
	        return edad;
	    }

	    public void setEdad(String edad) {
	        this.edad = edad;
	    }
	    
	    public String getPeso() {
	        return peso;
	    }

	    public void setPeso(String peso) {
	        this.peso = peso;
	    }
	    
	    public String getHistoria() {
	        return historia;
	    }

	    public void setHistoria(String historia) {
	        this.historia = historia;
	    }

		public byte[] getImagen() {
			return imagen;
		}

		public void setImagen(byte[] imagen) {
			this.imagen = imagen;
		}
	    
	    
	    
}
