/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baza.konekcija;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author student1
 */
public class BazaKonekcija {

    private Connection connection;
    private static BazaKonekcija instance;

    private BazaKonekcija() throws SQLException {
        String url = "jdbc:mysql://localhost/bazaispit";
        String user = "root";
        String pass = "";
        connection = DriverManager.getConnection(url, user, pass);
    }

    public static BazaKonekcija getInstance() throws SQLException {
        if (instance == null) {
            instance = new BazaKonekcija();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
