/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ControladorMnPri;
import javax.swing.JOptionPane;
import vista.JFIniciarSesion;
import vista.JFMenuPrincipal;

/**
 *
 * @author Administrador
 */
public class ModeloInicio {
    
    private JFIniciarSesion vis;
   
    public void ingresar() {
        if (vis.txtUsuario.getText().equals("admin") && vis.txtContrasenia.getText().equals("12345")) {
            vstMnPri.setVisible(true);
            vstMnPri.setTitle("SISTEMA DE VENTA");
            vstMnPri.setLocationRelativeTo(null);
            vis.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Ingresaste la clave o contraseña erronea");
        }
    }
    
    
}
