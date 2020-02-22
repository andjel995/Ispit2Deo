/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.baza;

import baza.konekcija.BazaKonekcija;
import domen.Angazovanje;
import domen.Predmet;
import domen.TipNastave;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import domen.Profesor;
import java.sql.PreparedStatement;
/**
 *
 * @author User
 */
public class StorageBazaAngazovanje {
             public List<Angazovanje> vratiSve() throws Exception 
             {
                List<Angazovanje> lista = new ArrayList<>();
        try {
            Connection connection = BazaKonekcija.getInstance().getConnection();
            String query = "select a.angazovanjeId, a.tipNastave, p.predmetId as predmetId, p.naziv as predmetNaziv, pr.profesorId as profesorId, pr.ime as profesorIme, pr.prezime as profesorPrezime "
                    + "from angazovanje a "
                    + "inner join predmet p on a.predmet = p.predmetId "
                    + "inner join profesor pr on a.profesor = pr.profesorId";
                System.out.println(query);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);  

            while (resultSet.next()) {
                Long id = resultSet.getLong("angazovanjeId");
                TipNastave tipNastave = TipNastave.valueOf(resultSet.getString("tipNastave"));
                Long predmetId = resultSet.getLong("predmetId");
                String predmetNaziv = resultSet.getString("predmetNaziv");
                
                Long profesorId = resultSet.getLong("profesorId");
                String profesorIme = resultSet.getString("profesorIme");
                String profesorPrezime = resultSet.getString("profesorPrezime");

                Predmet predmet = new Predmet(predmetId, predmetNaziv);
                Profesor profesor = new Profesor(profesorId,profesorIme,profesorPrezime);
                
                Angazovanje a = new Angazovanje(id , predmet, profesor, tipNastave);
                lista.add(a);
            }
            resultSet.close();
            statement.close();

            return lista;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
   
    public void dodajAngazovanje(Angazovanje angazovanje) throws Exception
    {

        try {
            Connection connection = BazaKonekcija.getInstance().getConnection();
            String query = "INSERT INTO angazovanje(tipNastave, predmet, profesor) VALUES (?,?,?)";
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, angazovanje.getTipNastave().toString());
            preparedStatement.setLong(2, angazovanje.getPredmet().getPredmetId());
            preparedStatement.setLong(3, angazovanje.getProfesor().getProfesorId());
            preparedStatement.executeUpdate();
            
            preparedStatement.close();  
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }
    public void obrisiAngazovanje(Angazovanje angazovanje) throws Exception
    {
    
        try {
            Connection connection = BazaKonekcija.getInstance().getConnection();
            String query = "delete from angazovanje where angazovanjeId = " + angazovanje.getAngazovanjeId();
            System.out.println(query);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            
            preparedStatement.close();  
        } catch (SQLException ex) {
            throw new Exception(ex.getMessage(), ex);
        }
    }
}

