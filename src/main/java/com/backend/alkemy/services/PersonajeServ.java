package com.backend.alkemy.services;

import java.util.Set;

import com.backend.alkemy.model.*;

public interface PersonajeServ {
   Personaje listarId (int id);
   Personaje add(Personaje p);
   Personaje editP(Personaje p);
   Personaje deleteP(int id);
}
