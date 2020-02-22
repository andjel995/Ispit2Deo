/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author User
 */
public class Predmet {
  private Long predmetId;
  private String naziv;

    public Predmet() {
    }

    public Predmet(Long predmetId, String naziv) {
        this.predmetId = predmetId;
        this.naziv = naziv;
    }

    public Long getPredmetId() {
        return predmetId;
    }

    public void setPredmetId(Long predmetId) {
        this.predmetId = predmetId;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String toString() {
        return naziv; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object o) {
       Predmet p = (Predmet) o;
       if(p.getPredmetId() == null || this.predmetId == null)
           return p.getNaziv() == this.naziv;
        return p.getPredmetId().equals(this.predmetId);
    }
  
}
