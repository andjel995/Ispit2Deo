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
public class Profesor {
    private Long profesorId;
    private String ime;
    private String prezime;

    public Profesor() {
    }

    public Profesor(Long profesorId, String ime, String prezime) {
        this.profesorId = profesorId;
        this.ime = ime;
        this.prezime = prezime;
    }

    public Long getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Long profesorId) {
        this.profesorId = profesorId;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public String toString() {
        return ime + " "+ prezime; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object o) {
        Profesor p =(Profesor) o;
        if(p.getProfesorId() == null || this.profesorId == null)
            return p.getIme().equals(this.getIme()) && p.getPrezime().equals(this.getPrezime());
        return p.getProfesorId() == profesorId;//p.getIme().equals(ime) && p.getPrezime().equals(prezime);
    }
    
    
}
