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
    
    private static JFIniciarSesion vstIni;
    private static ModeloInicio mdlInicio;
    private static CtrlInicio ctrlInicio;
    
    private static JFMenuPrincipal vstMnPri;
    private static ModeloMnPri mdlMnPri;
    private static CtrlMnPri ctrlMnPri;
    
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
         
        
        vstMnPri = new JFMenuPrincipal();
        mdlMnPri = new ModeloMnPri();
        ctrlMnPri = new CtrlMnPri(vstMnPri, mdlMnPri);  
        
        vstIni = new JFIniciarSesion();
        mdlInicio = new ModeloInicio();
        ctrlInicio = new CtrlInicio(vstIni, mdlInicio, vstMnPri);

        
    } 
}
