package modelo;

import bean.Producto;
import dao.CRUD;
import dao.Conexion;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import vista.JFPrincipal;

public class ModeloVenta extends Conexion {

    private DefaultTableModel mdlTblDVenta;
    private JFPrincipal vp;
    public int codProd;
    public Producto prod;

    public void inicioJFVenta() {
        tabla();
    }

    public void tabla() {
        mdlTblDVenta = (DefaultTableModel) vp.tblDVenta.getModel();
        vp.jSPDVenta.getViewport().setBackground(Color.white);
    }

    public void btnSeleccionarCli() {
        cambiarJP(JFPrincipal.jpCardOpc, JFPrincipal.jpMantenimiento);
        JFPrincipal.jTPMAntenimiento.setSelectedIndex(0);
    }

    public void btnSeleccionarProd() {
        cambiarJP(JFPrincipal.jpCardOpc, JFPrincipal.jpMantenimiento);
        JFPrincipal.jTPMAntenimiento.setSelectedIndex(1);
    }

    public void btnAgregarPedido() {
        boolean validar = vp.txtSNombreProd.equals("");
        if (!validar) {
            if (validarStockCantidad()) {
                int cantidad = (int) vp.spiSCantidad.getValue();
                float precioV = Float.parseFloat(vp.txtSPrecioProd.getText());
                double importe = cantidad * precioV;
                mdlTblDVenta.addRow(new Object[]{
                    vp.txtSNombreProd.getText(),
                    vp.txtSPrecioProd.getText(),
                    vp.spiSCantidad.getValue(),
                    String.format("%.2f", importe).replace(",", ".")
                });
            } 
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto.");
        }
    }

    public boolean validarStockCantidad() {
        int cantidad = (int) vp.spiSCantidad.getValue();
        int stockActual = Integer.parseInt(vp.txtSStock.getText());
        if (cantidad > 0) {
            if (stockActual >= cantidad) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "El stock no abarca la cantidad seleccionada.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciono una cantidad negativa.");
            vp.spiSCantidad.setValue(0);
        }
        return false;
    }

//    public void restarStock(){
//        try {
//                this.conectarBD();
//                PreparedStatement ps = this.conexion.prepareStatement("update Producto set stock = " + stock + " where codPro = " + p);
//                ps.executeUpdate();
//                return true;
//            }catch(Exception e){
//                JOptionPane.showMessageDialog(null, "validar Cantidad " + e);
//            }finally {
//                this.desconectarBD();
//            }
//    }
    private void cambiarJP(JPanel card, JPanel jp) {
        card.removeAll();
        card.repaint();
        card.add(jp);
        card.repaint();
        card.revalidate();
    }

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public Producto getProd() {
        return prod;
    }

    public void setProd(Producto prod) {
        this.prod = prod;
    }

}
