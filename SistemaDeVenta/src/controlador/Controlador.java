/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

/**
 *
 * @author Administrador
 */
public class Controlador implements ActionListener, MouseListener {

    private JFPrincipal vst;
    private Modelo mdl;
    private ModeloCliente mdlCli;
    private ModeloEmpleado mdlEmp;
    private ModeloProducto mdlProd;
    private ModeloVenta mdlVenta;
    private ModeloReportes mdlReVenta;

    public Controlador(JFPrincipal vst, Modelo mdl, ModeloCliente mdlCli,
            ModeloEmpleado mdlEmp, ModeloProducto mdlProd, ModeloVenta mdlVenta, ModeloReportes mdlReVenta) {
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
        /* Mant. Cliente */
        this.mdlCli = mdlCli;
        this.vst.btnNuevoCli.addActionListener(this);
        this.vst.btnRegistrarCli.addActionListener(this);
        this.vst.btnConsultarCli.addActionListener(this);
        this.vst.btnActualizarCli.addActionListener(this);
        this.vst.btnEliminarCli.addActionListener(this);
        this.vst.btnListarCli.addActionListener(this);
        this.vst.btnExtraerCli.addActionListener(this);
        this.vst.tblCliente.addMouseListener(this);
        /* Mant. Empleado */
        this.mdlEmp = mdlEmp;
        this.vst.btnNuevoEmp.addActionListener(this);
        this.vst.btnRegistrarEmp.addActionListener(this);
        this.vst.btnBuscarEmp.addActionListener(this);
        this.vst.btnActualizarEmp.addActionListener(this);
        this.vst.btnEliminarEmp.addActionListener(this);
        this.vst.btnListarEmp.addActionListener(this);
        this.vst.btnExtraerEmp.addActionListener(this);
        /* Mant. Producto */
        this.mdlProd = mdlProd;
        this.vst.btnNuevoProd.addActionListener(this);
        this.vst.btnRegistrarProd.addActionListener(this);
        this.vst.btnBuscarProd.addActionListener(this);
        this.vst.btnActualizarProd.addActionListener(this);
        this.vst.btnEliminarProd.addActionListener(this);
        this.vst.btnListarProd.addActionListener(this);
        this.vst.btnExtraerProd.addActionListener(this);
        this.vst.tblProducto.addMouseListener(this);
        /* Realizar Venta */
        this.mdlVenta = mdlVenta;
        this.vst.btnSeleccionarCli.addActionListener(this);
        this.vst.btnSeleccionarProd.addActionListener(this);
        this.vst.btnAgregarPedido.addActionListener(this);
        this.vst.btnQuitarPedido.addActionListener(this);
        this.vst.btnRegistrarVenta.addActionListener(this);
        /* mdlReVenta */
        this.mdlReVenta = mdlReVenta;
        this.vst.btnMostrarTodasVentas.addActionListener(this);
        this.vst.btnMostrarDetalleVenta.addActionListener(this);
    }

    public void iniciar() {
        vst.pack();
        vst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vst.setVisible(true);
        vst.setTitle("SISTEMA DE VENTA");
        vst.setLocationRelativeTo(null);
        vst.setResizable(false);
        /* Agregar Tablas */
        mdlCli.inicioJFCliente();
        mdlEmp.inicioJFEmpleado();
        mdlProd.inicioJFProducto();
        mdlVenta.inicioJFVenta();
        mdlReVenta.inicioReVenta();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        /* Iniciar Sesión */
        if (vst.btnIngresar == evt.getSource()) {
            try {
                mdl.iniciarSesion();
                mdlVenta.numeroBoleta();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnIngresar" + e);
            }
        }
        /* Menu Bar */
        if (vst.mnItemCerrarSesion == evt.getSource()) {
            try {
                mdl.cerraSesion();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "mnItemCerrarSesion" + e);
            }
        }
        if (vst.mnItemSalir == evt.getSource()) {
            try {
                mdl.salirSistema();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "mnItemSalir" + e);
            }
        }
        /*  Menu Principal  */
        if (vst.btnJpVenta == evt.getSource()) {
            try {
                mdl.jpVenta();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnJpVenta" + e);
            }
        }
        if (vst.btnJpReportes == evt.getSource()) {
            try {
                mdl.jpReporte();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnJpReportes" + e);
            }
        }
        if (vst.btnJpMantenimiento == evt.getSource()) {
            try {
                mdl.jpMantenimiento();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnJpMantenimiento" + e);
            }
        }
        /* Mant. Cliente */
        if (vst.btnRegistrarCli == evt.getSource()) {
            try {
                mdlCli.registrar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnRegistrarCli" + e);
            }
        }
        if (vst.btnNuevoCli == evt.getSource()) {
            try {
                mdlCli.nuevo();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnNuevoCli" + e);
            }
        }
        if (vst.btnConsultarCli == evt.getSource()) {
            try {
                mdlCli.consultar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnBuscarCli" + e);
            }
        }
        if (vst.btnListarCli == evt.getSource()) {
            try {
                mdlCli.listar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnListar" + e);
            }
        }
        if (vst.btnActualizarCli == evt.getSource()) {
            try {
                mdlCli.actualizar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnActualizarCli" + e);
            }
        }
        if (vst.btnExtraerCli == evt.getSource()) {
            try {
                mdlCli.extraer();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnExtraer" + e);
            }
        }
        if (vst.btnEliminarCli == evt.getSource()) {
            try {
                mdlCli.eliminar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnExtraer" + e);
            }
        }
        /* Mant. Empleado */
        if (vst.btnRegistrarEmp == evt.getSource()) {
            try {
                mdlEmp.registrar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnRegistrarEmp" + e);
            }
        }
        if (vst.btnNuevoEmp == evt.getSource()) {
            try {
                mdlEmp.nuevo();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnNuevoEmp" + e);
            }
        }
        if (vst.btnBuscarEmp == evt.getSource()) {
            try {
                mdlEmp.consultar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnBuscarEmp" + e);
            }
        }
        if (vst.btnListarEmp == evt.getSource()) {
            try {
                mdlEmp.listar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnListarEmp" + e);
            }
        }
        if (vst.btnActualizarEmp == evt.getSource()) {
            try {
                mdlEmp.actualizar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnActualizarEmp" + e);
            }
        }
        if (vst.btnExtraerEmp == evt.getSource()) {
            try {
                mdlEmp.extraer();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnExtraerEmp" + e);
            }
        }
        if (vst.btnEliminarEmp == evt.getSource()) {
            try {
                mdlEmp.eliminar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnEliminarEmp" + e);
            }
        }
        /* Mant. Producto */
        if (vst.btnRegistrarProd == evt.getSource()) {
            try {
                mdlProd.registrar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnRegistrarProd" + e);
            }
        }
        if (vst.btnNuevoProd == evt.getSource()) {
            try {
                mdlProd.nuevo();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnNuevoProd" + e);
            }
        }
        if (vst.btnBuscarProd == evt.getSource()) {
            try {
                mdlProd.consultar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnBuscarProd" + e);
            }
        }
        if (vst.btnListarProd == evt.getSource()) {
            try {
                mdlProd.listar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnListarProd" + e);
            }
        }
        if (vst.btnActualizarProd == evt.getSource()) {
            try {
                mdlProd.actualizar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnActualizarProd" + e);
            }
        }
        if (vst.btnExtraerProd == evt.getSource()) {
            try {
                mdlProd.extraer();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnExtraerProd" + e);
            }
        }
        if (vst.btnEliminarProd == evt.getSource()) {
            try {
                mdlProd.eliminar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnEliminarProd" + e);
            }
        }
        /* Realizar Venta */
        if (vst.btnSeleccionarCli == evt.getSource()) {
            try {
                mdlVenta.btnSeleccionarCli();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnSeleccionarCli " + e);
            }
        }
        if (vst.btnSeleccionarProd == evt.getSource()) {
            try {
                mdlVenta.btnSeleccionarProd();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnSeleccionarProd " + e);
            }
        }
        if (vst.btnAgregarPedido == evt.getSource()) {
            try {
                mdlVenta.btnAgregarPedido();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnAgregarPedido " + e);
            }
        }
        if (vst.btnQuitarPedido == evt.getSource()) {
            try {
                mdlVenta.btnQuitarPedido();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnQuitarPedido " + e);
            }
        }
        if (vst.btnRegistrarVenta == evt.getSource()) {
            try {
                mdlVenta.btnRegistrarVenta();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnRegistrarVenta " + e);
            }
        }
        if (vst.btnMostrarTodasVentas == evt.getSource()) {
            try {
                mdlReVenta.btnMostrarTodasVentas();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnMostrarTodasVentas " + e);
            }
        }
        if (vst.btnMostrarDetalleVenta == evt.getSource()) {
            try {
                mdlReVenta.btnMostrarDetalleVenta();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "btnMostrarDetalleVenta " + e);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        if (vst.tblCliente == evt.getSource()) {
            if (evt.getClickCount() == 1) {

            }
            if (evt.getClickCount() == 2) {
                try {
                    mdlCli.enviarCliente();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "btnSeleccionarProd" + e);
                }
            }
        }
        if (vst.tblProducto == evt.getSource()) {
            if (evt.getClickCount() == 1) {

            }
            if (evt.getClickCount() == 2) {
                try {
                    mdlProd.enviarProducto();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "btnSeleccionarProd" + e);
                }
            }
        }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
