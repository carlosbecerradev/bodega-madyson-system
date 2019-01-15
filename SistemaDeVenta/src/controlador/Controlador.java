/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

/**
 *
 * @author Administrador
 */
public class Controlador implements ActionListener {

    private JFPrincipal vst;
    private Modelo mdl;
    
    public Controlador(JFPrincipal vst, Modelo mdl){
        this.vst = vst;
        this.mdl = mdl;
        this.vst.btnIngresar.addActionListener(this);
        /* Menu Bar*/
        this.vst.mnItemCerrarSesion.addActionListener(this);
        this.vst.mnItemSalir.addActionListener(this);
        /* Menu Principal */
        this.vst.btnJpVenta.addActionListener(this);
        this.vst.btnJpReportes.addActionListener(this);
        this.vst.btnJpMantenimiento.addActionListener(this);
    }
    
    public void iniciar(){
        vst.pack();
        vst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vst.setVisible(true);
        vst.setTitle("SISTEMA DE VENTA");
        vst.setLocationRelativeTo(null);
        vst.setResizable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        /* Iniciar Sesión */
        if (vst.btnIngresar == evt.getSource()) {
            try {
                mdl.iniciarSesion();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "here" + e);
            }
        }
        /* Menu Bar */
        if (vst.mnItemCerrarSesion == evt.getSource()) {
            try {
                mdl.cerraSesion();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "here" + e);
            }
        }
        if (vst.mnItemSalir == evt.getSource()) {
            try {
                mdl.salirSistema();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "here" + e);
            }
        }
        /*  Menu Principal  */
        if (vst.btnJpVenta == evt.getSource()) {
            try {
                mdl.jpVenta();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "here" + e);
            }
        }
        if (vst.btnJpReportes == evt.getSource()) {
            try {
                mdl.jpReporte();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "here" + e);
            }
        }
        if (vst.btnJpMantenimiento == evt.getSource()) {
            try {
                mdl.jpMantenimiento();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "here" + e);
            }
        }
    }

 

}
