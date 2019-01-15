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
    private ModeloCliente mdlCli;
    private ModeloEmpleado mdlEmp;
    
    public Controlador(JFPrincipal vst, Modelo mdl, ModeloCliente mdlCli, ModeloEmpleado mdlEmp){
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
        /* Mantenimiento */
        this.vst.btnJpProd.addActionListener(this);
        this.vst.btnJpUsuario.addActionListener(this);
        this.vst.btnJpCliente.addActionListener(this);
        this.vst.btnJpProve.addActionListener(this);
        
        /* Mant. Cliente */
        this.mdlCli = mdlCli;
        this.vst.btnNuevoCli.addActionListener(this);
        this.vst.btnRegistrarCli.addActionListener(this);
        this.vst.btnConsultarCli.addActionListener(this);
        this.vst.btnActualizarCli.addActionListener(this);
        this.vst.btnEliminarCli.addActionListener(this);
        this.vst.btnListarCli.addActionListener(this);
        this.vst.btnExtraerCli.addActionListener(this);
        /* Mant. Empleado */
        this.mdlEmp = mdlEmp;
        this.vst.btnNuevoEmp.addActionListener(this);
        this.vst.btnRegistrarEmp.addActionListener(this);
        this.vst.btnBuscarEmp.addActionListener(this);
        this.vst.btnActualizarEmp.addActionListener(this);
        this.vst.btnEliminarEmp.addActionListener(this);
        this.vst.btnListarEmp.addActionListener(this);
        this.vst.btnExtraerEmp.addActionListener(this);
    }
    
    public void iniciar(){
        vst.pack();
        vst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vst.setVisible(true);
        vst.setTitle("SISTEMA DE VENTA");
        vst.setLocationRelativeTo(null);
        vst.setResizable(false);
        /* Agregar Tablas */
        mdlCli.inicioJFCliente();
        mdlEmp.inicioJFEmpleado();
    }
    
    @Override
    public void actionPerformed(ActionEvent evt) {
        /* Iniciar Sesión */
        if (vst.btnIngresar == evt.getSource()) {
            try {
                mdl.iniciarSesion();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnIngresar" + e);
            }
        }
        /* Menu Bar */
        if (vst.mnItemCerrarSesion == evt.getSource()) {
            try {
                mdl.cerraSesion();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "mnItemCerrarSesion" + e);
            }
        }
        if (vst.mnItemSalir == evt.getSource()) {
            try {
                mdl.salirSistema();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "mnItemSalir" + e);
            }
        }
        /*  Menu Principal  */
        if (vst.btnJpVenta == evt.getSource()) {
            try {
                mdl.jpVenta();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnJpVenta" + e);
            }
        }
        if (vst.btnJpReportes == evt.getSource()) {
            try {
                mdl.jpReporte();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnJpReportes" + e);
            }
        }
        if (vst.btnJpMantenimiento == evt.getSource()) {
            try {
                mdl.jpMantenimiento();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnJpMantenimiento" + e);
            }
        }
        /* Paneles Mantenimiento */
        if (vst.btnJpProd == evt.getSource()) {
            try {
                mdl.btnJpProd();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnJpProd" + e);
            }
        }
        if (vst.btnJpUsuario == evt.getSource()) {
            try {
                mdl.btnJpUsuario();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnJpUsuario" + e);
            }
        }
        if (vst.btnJpCliente == evt.getSource()) {
            try {
                mdl.btnJpCliente();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnJpCliente" + e);
            }
        }
        if (vst.btnJpProve == evt.getSource()) {
            try {
                mdl.btnJpProve();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnJpProve" + e);
            }
        }
        /* Mant. Cliente */
        if (vst.btnRegistrarCli == evt.getSource()) {
            try {
                mdlCli.registrar();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnRegistrarCli" + e);
            }
        }
        if (vst.btnNuevoCli == evt.getSource()) {
            try {
                mdlCli.nuevo();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnNuevoCli" + e);
            }
        }
        if (vst.btnConsultarCli == evt.getSource()) {
            try {
                mdlCli.consultar();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnBuscarCli" + e);
            }
        }
        if (vst.btnListarCli == evt.getSource()) {
            try {
                mdlCli.listar();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnListar" + e);
            }
        }
        if (vst.btnActualizarCli == evt.getSource()) {
            try {
                mdlCli.actualizar();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnActualizarCli" + e);
            }
        }
        if (vst.btnExtraerCli == evt.getSource()) {
            try {
                mdlCli.extraer();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnExtraer" + e);
            }
        }
        if (vst.btnEliminarCli == evt.getSource()) {
            try {
                mdlCli.eliminar();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnExtraer" + e);
            }
        }
        /* Mant. Empleado */
        if (vst.btnRegistrarEmp == evt.getSource()) {
            try {
                mdlEmp.registrar();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnRegistrarEmp" + e);
            }
        }
        if (vst.btnNuevoEmp == evt.getSource()) {
            try {
                mdlEmp.nuevo();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnNuevoEmp" + e);
            }
        }
        if (vst.btnBuscarEmp == evt.getSource()) {
            try {
                mdlEmp.consultar();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnBuscarEmp" + e);
            }
        }
        if (vst.btnListarEmp == evt.getSource()) {
            try {
                mdlEmp.listar();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnListarEmp" + e);
            }
        }
        if (vst.btnActualizarEmp == evt.getSource()) {
            try {
                mdlEmp.actualizar();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnActualizarEmp" + e);
            }
        }
        if (vst.btnExtraerEmp == evt.getSource()) {
            try {
                mdlEmp.extraer();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnExtraerEmp" + e);
            }
        }
        if (vst.btnEliminarEmp == evt.getSource()) {
            try {
                mdlEmp.eliminar();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "btnEliminarEmp" + e);
            }
        }
    }

 

}
