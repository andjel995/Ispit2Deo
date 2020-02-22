/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;
import java.util.List;

import domen.Profesor;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class StorageProfesor {
    List<Profesor> profesori;

    public StorageProfesor() {
        profesori = new ArrayList<>();
        profesori.add(new Profesor(0l, "Sasa", "Petrovic"));
        profesori.add(new Profesor(1l, "Sandra", "Simic"));
        profesori.add(new Profesor(2l, "Marko", "Kostadinovic"));
        profesori.add(new Profesor(3l, "Dusan", "Aleksic"));
        profesori.add(new Profesor(4l, "Dara", "Simic"));
    }

    public List<Profesor> getProfesori() {
        return profesori;
    }

    public void setProfesori(List<Profesor> profesori) {
        this.profesori = profesori;
    }
    
    
}
