package com.backend.alkemy.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Peliculas")
public class Peliculas {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int filmId;
	private byte[] imagen;
	private String titulo;
	private Date fechaCreacion;
	private int calificacion;
    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "pelicula_personaje",
            joinColumns = {@JoinColumn(name = "filmId")},
            inverseJoinColumns = {@JoinColumn(name = "persId")}
    )
    private Set<Personaje> personajes;
    
    @ManyToOne
    @JoinColumn(name = "Gen_ID")
    private Genero genero;
    public Genero getGenero() { return genero;}
	
	public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
    

}
