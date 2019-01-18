package modelo;

import dao.CRUD;
import dao.Conexion;
import java.awt.Color;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
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
    
    public void validarStockCantidad(){
        int cantidad = (int)vp.spiSCantidad.getValue();
        int stockActual = Integer.parseInt(vp.txtSStock.getText());
        if (cantidad <= stockActual) {
            try {
                this.conectarBD();
                int stock = stockActual - cantidad;
                PreparedStatement ps = this.conexion.prepareStatement("update Producto set stock = " + stock + "where codPro = ");
            }catch(Exception e){
                
            }finally {
                this.desconectarBD();
            }
        } else {
            JOptionPane.showMessageDialog(null, "El stock no abarca la cantidad seleccionada.");            
        }
    }
    
    private void cambiarJP(JPanel card, JPanel jp) {
        card.removeAll();
        card.repaint();
        card.add(jp);
        card.repaint();
        card.revalidate();
    }
    
}
