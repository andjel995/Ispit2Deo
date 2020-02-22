/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domen.Predmet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class StoragePredmet {

    List<Predmet> predmeti;

    public List<Predmet> getPredmeti() {
        return predmeti;
    }

    public void setPredmeti(List<Predmet> predmeti) {
        this.predmeti = predmeti;
    }

    public StoragePredmet() {
        predmeti = new ArrayList<>();
        init();
    }

    private void init() {
        predmeti.add(new Predmet(11l, "Matematika"));
        predmeti.add(new Predmet(22l, "ProjektovanjeSoftvera"));
        predmeti.add(new Predmet(32l, "Elektronsko poslovanje"));
        predmeti.add(new Predmet(42l, "Statistika"));
        predmeti.add(new Predmet(52l, "Engleski jezik"));
    }
    
    
}
