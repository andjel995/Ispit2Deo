/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domen.Angazovanje;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class StorageAngazovanje {
    List<Angazovanje> angazovanja;

    public StorageAngazovanje() {
        angazovanja = new ArrayList<>();
    }
    
    public void dodajAngazovanje(Angazovanje angazovanje)
    {
        Long id =Long.valueOf(getNextID());
        angazovanje.setAngazovanjeId(id);
        angazovanja.add(angazovanje);     
    }
    public void obrisiAngazovanje(Angazovanje angazovanje)
    {
        angazovanja.remove(angazovanje);
    }
    
    public List<Angazovanje> getAngazovanja() {
        return angazovanja;
    }

    public void setAngazovanja(List<Angazovanje> angazovanja) {
        this.angazovanja = angazovanja;
    }

    private int getNextID() {
       return angazovanja.size();
    }
  
}
