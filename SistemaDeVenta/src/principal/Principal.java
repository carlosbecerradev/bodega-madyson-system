/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import modelo.*;
import vista.*;
import controlador.*;

/**
 *
 * @author Administrador
 */
public class Principal {

    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }

        JFPrincipal vst = new JFPrincipal();
        Modelo mdl = new Modelo();
        ModeloCliente mdlCli = new ModeloCliente();
        ModeloEmpleado mdlEmp = new ModeloEmpleado();
        ModeloProducto mdlProd = new ModeloProducto();
        
        Controlador ctrl = new Controlador(vst, mdl, mdlCli, mdlEmp, mdlProd);
        ctrl.iniciar();

    }
}
