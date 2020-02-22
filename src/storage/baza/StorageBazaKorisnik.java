/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.baza;

import baza.konekcija.BazaKonekcija;
import domen.Korisnik;
import domen.Predmet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author User
 */
public class StorageBazaKorisnik {
         public List<Korisnik> vratiSve() throws Exception 
         {
        List<Korisnik> lista = new LinkedList<>();
        try {

            Connection connection = BazaKonekcija.getInstance().getConnection();
            String query = "SELECT * FROM korisnik";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Long id = resultSet.getLong("korisnikId");
                String korisnickoIme = resultSet.getString(2);
                String lozinka = resultSet.getString(3);
                String ime = resultSet.getString(4);
                String prezime = resultSet.getString(5);
                Korisnik korisnik = new Korisnik(id,korisnickoIme,lozinka,ime,prezime);
                lista.add(korisnik);
            }
            resultSet.close();
            statement.close();
            return lista;
        } catch (SQLException ex) {
            throw new Exception("Neuspesna konekcija! " + ex.getMessage(), ex);
        }
      }
}
