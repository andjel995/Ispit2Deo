/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import domen.Korisnik;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author User
 */
public class Session {
    private static Session instanca;
    private Korisnik trenutniKorisnik;
    private final Map<String, Object> useCaseParams;

    public Korisnik getTrenutniKorisnik() {
        return trenutniKorisnik;
    }

    public void setTrenutniKorisnik(Korisnik trenutniKorisnik) {
        this.trenutniKorisnik = trenutniKorisnik;
    }
    
    private Session() {
       useCaseParams = new HashMap<>();
    }

    public Map<String, Object> getUseCaseParams() {
        return useCaseParams;
    }

    public static Session getInstance() {
        if (instanca == null) {
            instanca = new Session();
        }
        return instanca;
    }
}
