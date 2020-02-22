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
public class Angazovanje 
{
    Long angazovanjeId;
    Predmet predmet;
    Profesor profesor;
    TipNastave tipNastave;

    public Angazovanje(Long angazovanjeId, Predmet predmet, Profesor profesor, TipNastave tipNastave) {
        this.angazovanjeId = angazovanjeId;
        this.predmet = predmet;
        this.profesor = profesor;
        this.tipNastave = tipNastave;
    }

        public Angazovanje( Predmet predmet, Profesor profesor, TipNastave tipNastave) {
        this.predmet = predmet;
        this.profesor = profesor;
        this.tipNastave = tipNastave;
    }
    public Long getAngazovanjeId() {
        return angazovanjeId;
    }

    public void setAngazovanjeId(Long angazovanjeId) {
        this.angazovanjeId = angazovanjeId;
    }

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public TipNastave getTipNastave() {
        return tipNastave;
    }

    public void setTipNastave(TipNastave tipNastave) {
        this.tipNastave = tipNastave;
    }

    @Override
    public boolean equals(Object an) 
    {
        Angazovanje a = (Angazovanje) an;
        return a.getPredmet().equals(predmet) && a.getProfesor().equals(profesor); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
