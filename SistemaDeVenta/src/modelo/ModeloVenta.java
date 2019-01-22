package modelo;

import bean.DetalleVenta;
import bean.Venta;
import dao.Conexion;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLXML;
import java.sql.Statement;
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
            int cod = (int) mdlTblDVenta.getValueAt(fila, 0);
            int cantidad =(int) mdlTblDVenta.getValueAt(fila, 3);
            String im = (String) mdlTblDVenta.getValueAt(fila, 4);
            float importe = Float.parseFloat(im);
            try {
                this.conectarBD();
                Statement st = this.conexion.createStatement();
                ResultSet rs = st.executeQuery("select stock from Producto where codProd = " + cod);
                rs.next();
                int nuevoStock = rs.getInt(1) + cantidad;
                PreparedStatement ps2 = this.conexion.prepareStatement("update Producto set stock = " + nuevoStock
                        + " where codProd = " + cod);
                ps2.executeUpdate();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                this.desconectarBD();
            }
            float importes = 0;
            mdlTblDVenta.removeRow(fila);
            int cantFilas = mdlTblDVenta.getRowCount();
            for (int i = 0; i < cantFilas; i++) {
                importes += importe;
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
    
    public void numeroBoleta(){
        int nextBoleta = 0;
        try{
            this.conectarBD();
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery("select codVenta from Venta");
            while(rs.next()){
                nextBoleta = rs.getInt(1);
            }
            nextBoleta += 1;
            vp.lblNBoleta.setText(String.valueOf(nextBoleta));            
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        } finally {
            this.desconectarBD();
        }
    }

    private void cambiarJP(JPanel card, JPanel jp) {
        card.removeAll();
        card.repaint();
        card.add(jp);
        card.repaint();
        card.revalidate();
    }
    
    public void btnRegistrarVenta(){
        boolean validar = vp.jdcFechaBoleta.getDate() == null || vp.txtSNombreCli.getText().equals("") ||
                mdlTblDVenta.getRowCount() <= 0;
        
        if (!validar) {
            try{
                this.conectarBD();
                /* Tabla Venta */
                Venta venta = new Venta(fechaVenta(), totalVenta(), codEmpleado1(), codCliente1());
                PreparedStatement ps = this.conexion.prepareStatement("insert into Venta values (?, ?, ?, ?)");
                ps.setDate(1, venta.getFechaVenta());
                ps.setFloat(2, venta.getTotalVenta());
                ps.setInt(3, venta.getCodEmpleado1());
                ps.setInt(4, venta.getCodCliente1());
                ps.executeUpdate();
                /* Tabla Detalle de Venta */
                int filas = mdlTblDVenta.getRowCount();
                for (int i = 0; i < filas; i++) {
                    DetalleVenta dv = new DetalleVenta(codVenta(), codProdcto(i), codCliente1(), codEmpleado1(), cantidad(i), importe(i));
                    PreparedStatement psDv = this.conexion.prepareStatement("insert into DetalleVenta values (?,?,?,?,?,?)");
                    psDv.setInt(1, dv.getCodVenta());
                    psDv.setInt(2, dv.getCodPro());
                    psDv.setInt(3, dv.getCodCliente());
                    psDv.setInt(4,dv.getCodEmpleado());
                    psDv.setInt(5, dv.getCantidad());
                    psDv.setFloat(6, dv.getImporte());
                    psDv.executeUpdate();
                }                
                limpiarVenta();
                JOptionPane.showMessageDialog(null, "Boleta Registrada.");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }finally{
                this.desconectarBD();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Rellene todos los campos.");
        }
    }
    
    private java.sql.Date fechaVenta(){
        java.util.Date jdate;
        jdate = vp.jdcFechaBoleta.getDate();
        java.sql.Date fecha = new java.sql.Date(jdate.getTime());
        return fecha;
    }
    
    private float totalVenta(){
        return Float.parseFloat(vp.txtMontoFinal.getText());
    }
    
    private int codEmpleado1(){
        return Integer.parseInt(vp.lblSCodEmpleado.getText());
    }
    
    private int codCliente1(){
        return Integer.parseInt(vp.txtSCodCli.getText());
    }
    
    private int codVenta(){
        return Integer.parseInt(vp.lblNBoleta.getText());
    }
    
    private int codProdcto(int i){
        int codPro = (int) mdlTblDVenta.getValueAt(i, 0);
        return codPro;
    }
    
    private int cantidad(int i){
        int cantidad = (int) mdlTblDVenta.getValueAt(i, 3);
        return cantidad;
    }
    
    private float importe(int i){
        String fl = (String) mdlTblDVenta.getValueAt(i, 4);
        float importe = Float.parseFloat(fl);
        return importe;
    }    
    
    public void limpiarVenta(){
        // Fecha
        vp.jdcFechaBoleta.setDate(null);
        // Datos Cliente
        vp.txtSCodCli.setText("");
        vp.txtSNombreCli.setText("");
        // Datos Producto
        vp.txtSCodPro.setText("");
        vp.txtSNombreProd.setText("");
        vp.txtSPrecioProd.setText("");
        vp.txtSStock.setText("");
        vp.spiSCantidad.setValue(0);
        // Detalle Venta
        int filas = mdlTblDVenta.getRowCount();
        for (int i = 0; i < filas; i++) {
            mdlTblDVenta.removeRow(0);
        }
        // Monto Final
        vp.txtMontoFinal.setText("");
        /* nueva boleta*/
        numeroBoleta();
    }
}
