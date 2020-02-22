/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domen.Korisnik;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class StorageKorisnik {
    List<Korisnik> korisnici;

    public StorageKorisnik() {
        korisnici = new ArrayList<>();
        inicijalizuj();
    }

    public List<Korisnik> getKorisnici() {
        return korisnici;
    }

    private void inicijalizuj() {
        korisnici.add(new Korisnik(0l,"jovana1","jovana1", "Jovana", "Andjelkovic"));
        korisnici.add(new Korisnik(1l,"Bojana","bojana1", "Bojana", "Nikolic"));
        korisnici.add(new Korisnik(2l,"Jelena","jelena1", "Jelena", "Petrovic"));      
    }
    
}
