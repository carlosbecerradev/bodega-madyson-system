/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import dao.CRUD;
import dao.Conexion;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import vista.JFPrincipal;

/**
 *
 * @author Administrador
 */
public class ModeloProducto extends Conexion implements CRUD{

    private DefaultTableModel mdlTblProd;
    private JFPrincipal vp;

    public void inicioJFEmpleado() {
        tabla();
    }

    public void tabla() {
        mdlTblProd = (DefaultTableModel) vp.tbProducto.getModel();
        vp.jSPProd.getViewport().setBackground(Color.white);
    }
    
    @Override
    public void registrar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String buscar(String filtro) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void extraer() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void consultar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nuevo() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void cambiarJP(JPanel card, JPanel jp) {
        card.removeAll();
        card.repaint();
        card.add(jp);
        card.repaint();
        card.revalidate();
    }

}
