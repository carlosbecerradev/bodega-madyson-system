/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ModeloInicio;
import vista.JFIniciarSesion;
import static vista.JFIniciarSesion.txtContrasenia;
import static vista.JFIniciarSesion.txtUsuario;
import vista.JFMenuPrincipal;

/**
 *
 * @author Administrador
 */
public class CtrlInicio implements ActionListener{
    
    JFIniciarSesion vstInicio;
    ModeloInicio mdlInicio;
    /**/
    JFMenuPrincipal vstMnPri;
    
    public CtrlInicio(JFIniciarSesion vstInicio, ModeloInicio mdlInicio, JFMenuPrincipal vstMnPri){
        this.vstInicio = vstInicio;
        this.mdlInicio = mdlInicio;
        this.vstMnPri = vstMnPri;
        this.vstInicio.btnIngresar.addActionListener(this);
        iniciar();
    }
    
    private void iniciar(){
        vstInicio.setTitle("INICAR SESIÓN");
        vstInicio.setLocationRelativeTo(null);
        vstInicio.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        if (vstInicio.btnIngresar == evt.getSource()) {
            try {
                 ingresar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese los caracteres correctos");
            }
        }
    }
    
    public void ingresar(){
        if (vstInicio.txtUsuario.getText().equals("admin") && vstInicio.txtContrasenia.getText().equals("12345")) {
            JFMenuPrincipal menuP = new JFMenuPrincipal();
            menuP.setVisible(true);
            menuP.setTitle("SISTEMA DE VENTA");
            menuP.setLocationRelativeTo(null);
            vstInicio.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Ingresaste la clave o contraseña erronea");
        }
    }
    
}
