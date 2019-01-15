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
import vista.*;

/**
 *
 * @author Administrador
 */
public class ControladorInicio implements ActionListener {

    private JFIniciarSesion vstInicio;
    private ModeloInicio mdlInicio;
    
    private JFMenuPrincipal vstMnPri;

    public ControladorInicio(JFIniciarSesion vstInicio, ModeloInicio mdlInicio, JFMenuPrincipal vstMnPri) {
        this.vstInicio = vstInicio;
        this.mdlInicio = mdlInicio;
        this.vstInicio.btnIngresar.addActionListener(this);
        iniciar();
        this.vstMnPri = vstMnPri;
    }

    private void iniciar() {
        vstInicio.setTitle("INICAR SESIÓN");
        vstInicio.setLocationRelativeTo(null);
        vstInicio.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (vstInicio.btnIngresar == evt.getSource()) {
            try {
                this.ingresar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }


}
