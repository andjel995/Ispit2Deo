package logika;

import domen.Angazovanje;
import domen.Korisnik;
import domen.Predmet;
import domen.Profesor;
import domen.RezultatCuvanja;
import domen.TipNastave;
import java.util.ArrayList;
import java.util.List;
import storage.baza.StorageBazaAngazovanje;
import storage.baza.StorageBazaKorisnik;
import storage.baza.StorageBazaPredmet;
import storage.baza.StorageBazaProfesor;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Kontroler {
    private static Kontroler instanca;
    private StorageBazaAngazovanje storageBazaAngazovanje;
    private StorageBazaKorisnik storageBazaKorisnik;
    private StorageBazaPredmet storageBazaPredmet;
    private StorageBazaProfesor storageBazaProfesor;
   
    private Kontroler() {
        storageBazaAngazovanje = new StorageBazaAngazovanje();
        storageBazaKorisnik = new StorageBazaKorisnik();
        storageBazaPredmet = new StorageBazaPredmet();
        storageBazaProfesor = new StorageBazaProfesor();
    }
    
   public static Kontroler dajInstancu()
   {
     if(instanca == null)
         instanca = new Kontroler();
     return instanca;
   }
    
   public Korisnik prijaviSe(String korisnickoIme, String lozinka) throws Exception
   {
       Korisnik korisnik = new Korisnik();
       List<Korisnik> korisnici = storageBazaKorisnik.vratiSve();
       try
       {
            for(Korisnik k : korisnici)
            {
                if(k.getKorisnickoIme().equals(lozinka) && k.getLozinka().equals(lozinka))
                    return k;
            }
       }catch(Exception ex)
       {
            throw new Exception("Error in login method :"+ ex.getMessage());
       }
       return korisnik;
   }

    public List<Predmet> dajPredmete() throws Exception {
       List<Predmet> listaPredmeta = storageBazaPredmet.vratiSve();
       return listaPredmeta;
    }

    public List<Profesor> dajListuProfesora() throws Exception {
        List<Profesor> listaProfesora = storageBazaProfesor.vratiSve();
        return listaProfesora;
    }

    public List<Angazovanje> dajAngazovanja() throws Exception {
        List<Angazovanje> listaAngazovanja = storageBazaAngazovanje.vratiSve();
        return listaAngazovanja;
    }

    public boolean proveriDuplikate(Profesor profesor, Predmet predmet, TipNastave tn, List<Angazovanje> lista) {
        for(Angazovanje angazovanje : lista)
        {
            if(angazovanje.getPredmet().equals(predmet) && angazovanje.getProfesor().equals(profesor))
                return true;
        }
        return false;
    }

    public RezultatCuvanja sacuvajSve(List<Angazovanje> lista) throws Exception {
        RezultatCuvanja rc = RezultatCuvanja.Uspesan;
        List<Angazovanje> angazovanja = storageBazaAngazovanje.vratiSve();
        for(Angazovanje a: lista)
        {
            if(angazovanja.contains(a))
            {
                rc = RezultatCuvanja.Duplikati;
                continue;
            }
           a.setAngazovanjeId(Long.valueOf(angazovanja.size()));
           storageBazaAngazovanje.dodajAngazovanje(a);
        }
        return rc;
    }

    public List<Angazovanje> dajAngazovanjaZaOdredjeniPredmet(Long predmetId) throws Exception {
       List<Angazovanje> lista =  storageBazaAngazovanje.vratiSve();
       List<Angazovanje> listaOdabranihAngazovanja = new ArrayList<>();
       for(Angazovanje a : lista)
       {
           if(a.getPredmet().getPredmetId().equals(predmetId))
               listaOdabranihAngazovanja.add(a);
       }
       return listaOdabranihAngazovanja;
    }

    public boolean izmeniAngazovanja(Angazovanje a, List<Angazovanje> novaLista) throws Exception {
        int brojac = 0;
        boolean bezDuplikata = true;
        List<Angazovanje> postojecaAngazovanja = dajAngazovanjaZaOdredjeniPredmet(a.getPredmet().getPredmetId());
        List<Angazovanje> zaDodavanje = new ArrayList<>();
        for(Angazovanje angazovanje : novaLista)
        {
            if(postojecaAngazovanja.contains(angazovanje)){
                brojac++;
                continue;
            }
            else
            {
                zaDodavanje.add(angazovanje);
            }
        }
        //postojecaAngazovanja = dajAngazovanjaZaOdredjeniPredmet(a.getPredmet().getPredmetId());
        if(brojac == novaLista.size())
            bezDuplikata = false;
        
        for(Angazovanje angazovanje : postojecaAngazovanja)
        {
            
            if(!novaLista.contains(angazovanje))
            storageBazaAngazovanje.obrisiAngazovanje(angazovanje);
        }
        for(Angazovanje an : zaDodavanje)
        {
            storageBazaAngazovanje.dodajAngazovanje(an);
        }
        return bezDuplikata;
    }

    public Predmet nadjiPredmetPoId(Long predmetId) throws Exception {
        Predmet predmet = storageBazaPredmet.nadjiPoId(predmetId);
        return predmet;
        }
    
}
