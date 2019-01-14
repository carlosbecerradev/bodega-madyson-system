/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import vista.JFIniciarSesion;
import controlador.Controlador;

/**
 *
 * @author Administrador
 */
public class Principal {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
        
        JFIniciarSesion jfIniSes = new JFIniciarSesion();
        Controlador c = new Controlador(jfIniSes);
        c.iniciar();
        
    } 
}
