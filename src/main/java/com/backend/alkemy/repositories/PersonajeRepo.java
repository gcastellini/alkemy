package com.backend.alkemy.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.backend.alkemy.model.*;

public interface PersonajeRepo extends JpaRepository <Personaje,Long>{
	List<Personaje> findAll();
	Personaje findBypersId (int persId);
	Personaje save(Personaje p);
	void delete(Personaje p);
	

}
