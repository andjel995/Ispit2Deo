/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package start;

import forme.LoginForma;
import javax.swing.UIManager;

/**
 *
 * @author User
 */
public class Start {
    
    public static void main(String[] args) 
    {
        LoginForma lf = new LoginForma();
                try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        lf.setDefaultLookAndFeelDecorated(true);

        lf.setVisible(true);
    }
}
