package modelo;

import dao.CRUD;
import dao.Conexion;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import vista.JFPrincipal;

public class ModeloVenta extends Conexion {
    
    private DefaultTableModel mdlTblDVenta;
    private JFPrincipal vp;

    public void inicioJFVenta() {
        tabla();
    }

    public void tabla() {
        mdlTblDVenta = (DefaultTableModel) vp.tblDVenta.getModel();
        vp.jSPDVenta.getViewport().setBackground(Color.white);
    }

    public void btnSeleccionarCli(){
        cambiarJP(JFPrincipal.jpCardOpc, JFPrincipal.jpMantenimiento);
        JFPrincipal.jTPMAntenimiento.setSelectedIndex(0);
    }
    
    public void btnSeleccionarProd(){
        cambiarJP(JFPrincipal.jpCardOpc, JFPrincipal.jpMantenimiento);
        JFPrincipal.jTPMAntenimiento.setSelectedIndex(1);
    }
    
    private void cambiarJP(JPanel card, JPanel jp) {
        card.removeAll();
        card.repaint();
        card.add(jp);
        card.repaint();
        card.revalidate();
    }
    
}
