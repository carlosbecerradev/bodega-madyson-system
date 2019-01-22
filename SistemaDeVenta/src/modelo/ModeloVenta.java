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
        int codProd = Integer.parseInt(vp.txtSCodPro.getText());
        int stockA = Integer.parseInt(vp.txtSStock.getText());
        if (!validar) {
            if (validarStockCantidad()) {
                int cantidad = (int) vp.spiSCantidad.getValue();
                float precioV = Float.parseFloat(vp.txtSPrecioProd.getText());
                float importe = cantidad * precioV;
                mdlTblDVenta.addRow(new Object[]{
                    codProd,
                    vp.txtSNombreProd.getText(),
                    vp.txtSPrecioProd.getText(),
                    vp.spiSCantidad.getValue(),
                    String.format("%.2f", importe).replace(",", ".")
                });
                try {
                    this.conectarBD();
                    PreparedStatement ps = this.conexion.prepareStatement("update Producto set stock = " + (stockA - cantidad)
                            + " where codProd = " + codProd);
                    ps.executeUpdate();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                } finally {
                    this.desconectarBD();
                }
                float importes = 0;
                int cantFilas = mdlTblDVenta.getRowCount();
                for (int i = 0; i < cantFilas; i++) {
                    String sImp = (String) mdlTblDVenta.getValueAt(i, 4);
                    float fImporte = Float.parseFloat(sImp);
                    importes += fImporte;
                }
                vp.txtMontoFinal.setText(String.valueOf(importes));
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un producto.");
        }
    }

    public void btnQuitarPedido() {
        int fila = JFPrincipal.tblDVenta.getSelectedRow();
        if (fila >= 0) {
            String codS = (String)mdlTblDVenta.getValueAt(fila, 0);
            int cod = Integer.parseInt(codS);
            //String producto = (String)mdlTblDVenta.getValueAt(fila, 1);
            String pS = (String) mdlTblDVenta.getValueAt(fila, 2);
            float precio = Float.parseFloat(pS);
            String cS = (String) mdlTblDVenta.getValueAt(fila, 3);
            int cantidad = Integer.parseInt(cS);
            String iS = (String) mdlTblDVenta.getValueAt(fila, 4);
            float importe = Float.parseFloat(iS);
            try {
                this.conectarBD();
                PreparedStatement ps1 = this.conexion.prepareStatement("select stock from Producto where codProd = " + cod + " ");
                ResultSet rs1 = ps1.executeQuery();
                rs1.next();
                PreparedStatement ps2 = this.conexion.prepareStatement("update Producto set stock = " + (rs1.getInt(1) + cantidad)
                        + " where codProd = " + cod);
                ps2.executeUpdate();
                
                rs1.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                this.desconectarBD();
            }
            float importes = 0;
            mdlTblDVenta.removeRow(fila);
            int cantFilas = mdlTblDVenta.getRowCount();
            for (int i = 0; i < cantFilas; i++) {
                String sImp = (String) mdlTblDVenta.getValueAt(i, 4);
                float fImporte = Float.parseFloat(sImp);
                importes += fImporte;
            }
            vp.txtMontoFinal.setText(String.valueOf(importes));
            vp.spiSCantidad.requestFocus();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila.");
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
            JOptionPane.showMessageDialog(null, "No ha elegido una unidad.");
            vp.spiSCantidad.setValue(0);
        }
        return false;
    }

    private void cambiarJP(JPanel card, JPanel jp) {
        card.removeAll();
        card.repaint();
        card.add(jp);
        card.repaint();
        card.revalidate();
    }

}
