/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.baza;

import baza.konekcija.BazaKonekcija;
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
public class StorageBazaProfesor {
    
     public List<Profesor> vratiSve() throws Exception {
        List<Profesor> lista = new LinkedList<>();
        try {

            Connection connection = BazaKonekcija.getInstance().getConnection();
            String query = "SELECT * FROM profesor";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Long id = resultSet.getLong("profesorId");
                String ime = resultSet.getString(2);
                String prezime = resultSet.getString(3);
                Profesor profesor = new Profesor(id, ime, prezime);
                lista.add(profesor);
            }
            resultSet.close();
            statement.close();
            return lista;
        } catch (SQLException ex) {
            throw new Exception("Neuspesna konekcija! " + ex.getMessage(), ex);
        }
    }
}
