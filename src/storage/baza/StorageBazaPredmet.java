/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.baza;

import baza.konekcija.BazaKonekcija;
import domen.Predmet;
import domen.Profesor;
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
public class StorageBazaPredmet {
    
       public List<Predmet> vratiSve() throws Exception {
        List<Predmet> lista = new LinkedList<>();
        try {

            Connection connection = BazaKonekcija.getInstance().getConnection();
            String query = "SELECT * FROM predmet";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Long id = resultSet.getLong("predmetId");
                String naziv = resultSet.getString(2);
                Predmet predmet = new Predmet(id, naziv);
                lista.add(predmet);
            }
            resultSet.close();
            statement.close();
            return lista;
        } catch (SQLException ex) {
            throw new Exception("Neuspesna konekcija! " + ex.getMessage(), ex);
        }
    }

    public Predmet nadjiPoId(Long predmetId) throws Exception {
         Predmet predmet = new Predmet();
        try {

            Connection connection = BazaKonekcija.getInstance().getConnection();
            String query = "SELECT * FROM predmet where predmetId = " + predmetId;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Long id = resultSet.getLong("predmetId");
                String naziv = resultSet.getString(2);
                predmet = new Predmet(id, naziv);
            }
            resultSet.close();
            statement.close();
            return predmet;
        } catch (SQLException ex) {
            throw new Exception("Neuspesna konekcija! " + ex.getMessage(), ex);
        }
    }
}
