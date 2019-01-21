/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this tprodlate file, choose Tools | Tprodlates
 * and open the tprodlate in the editor.
 */
package modelo;

import bean.Producto;
import dao.CRUD;
import dao.Conexion;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import vista.JFPrincipal;

/**
 *
 * @author Administrador
 */
public class ModeloProducto extends Conexion implements CRUD {

    private DefaultTableModel mdlTblProd;
    private JFPrincipal vp;

    public void inicioJFProducto() {
        tabla();
    }

    public void tabla() {
        mdlTblProd = (DefaultTableModel) vp.tblProducto.getModel();
        vp.jSPProd.getViewport().setBackground(Color.white);
    }

    @Override
    public void registrar() throws Exception {
        try {
            Producto prod = new Producto(articuloR(), marcaR(), precioVentaR(), stockR(), categoriaR());
            this.conectarBD();
            PreparedStatement ps = this.conexion.prepareStatement("insert into Producto values (?, ?, ?, ?, ?)");
            ps.setString(1, prod.getArticulo());
            ps.setString(2, prod.getMarca());
            ps.setFloat(3, prod.getPrecioV());
            ps.setInt(4, prod.getStock());
            ps.setString(5, prod.getCategoria());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Registrados");
            vp.btnRegistrarProd.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "registrar " + e);
        } finally {
            this.desconectarBD();
        }
    }

    @Override
    public String buscar(String filtro) throws Exception {
        String consultar = "";
        try {
            if (filtro.equals("")) {
                consultar = "select * from Producto";
            } else {
                consultar = "select * from Producto where articulo  like '%" + filtro + "%'";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los datos");
        }
        return consultar;
    }

    @Override
    public void extraer() throws Exception {
        try {

            int fila = JFPrincipal.tblProducto.getSelectedRow();
            if (fila >= 0) {
                String cod = (String) JFPrincipal.tblProducto.getValueAt(fila, 0);
                this.conectarBD();
                Statement st = this.conexion.createStatement();
                ResultSet rs = st.executeQuery("select * from Producto where codProd = " + cod);
                String datos[] = new String[5];
                rs.next();
                datos[0] = rs.getString(2);
                datos[1] = rs.getString(3);
                datos[2] = rs.getString(4);
                datos[3] = rs.getString(5);
                datos[4] = rs.getString(6);

                vp.txtCodigoProd.setText(cod);
                vp.txtArticuloProdM.setText(datos[0]);
                vp.cboMarcaProdM.setSelectedItem(datos[1]);
                vp.txtPrecioVentaProM.setText(datos[2]);
                vp.txtStockProdM.setText(datos[3]);
                vp.cboCategoriaProdM.setSelectedItem(datos[4]);

                cambiarJP(JFPrincipal.jpCardProd, JFPrincipal.jpModificarProd);
                vp.btnActualizarProd.setEnabled(true);
                vp.btnEliminarProd.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla para modificar.");
            }

            //JOptionPane.showMessageDialog(null, "Datos extraidos.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "extraer " + e);
        } finally {
            this.desconectarBD();
        }
    }

    @Override
    public void actualizar() throws Exception {
        try {
            this.conectarBD();
            PreparedStatement ps = this.conexion.prepareStatement("update Producto set articulo = '" + articuloM()
                    + "', marca = '" + marcaM() + "', precioVenta = '" + precioVentaM() + "', stock = '" + stockM()
                    + "', categoria = '" + categoriaM() + "'  where codProd = " + codigoM());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            vp.btnActualizarProd.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "actualizar " + e);
        } finally {
            this.desconectarBD();
        }
    }

    @Override
    public void consultar() throws Exception {
        cambiarJP(JFPrincipal.jpCardProd, JFPrincipal.jpConsultaProd);
        vp.btnActualizarProd.setEnabled(false);
        vp.btnRegistrarProd.setEnabled(false);
        vp.btnEliminarProd.setEnabled(true);
    }

    @Override
    public void eliminar() throws Exception {
        int fila = JFPrincipal.tblProducto.getSelectedRow();
        if (fila >= 0) {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar el empleado?");
            if (confirmar == 0) {
                String cod = (String) JFPrincipal.tblProducto.getValueAt(fila, 0);
                int codigo = Integer.parseInt(cod);
                try {
                    this.conectarBD();
                    PreparedStatement ps = this.conexion.prepareStatement("delete from Producto where codProd = " + codigo);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Empleado eliminado");
                    listar();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(null, "eliminar " + e);
                } finally {
                    this.desconectarBD();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila.");
        }
    }

    @Override
    public void listar() throws Exception {
        //limpiar la tabla
        int filas = mdlTblProd.getRowCount();
        for (int i = 0; i < filas; i++) {
            mdlTblProd.removeRow(0);
        }
        /**
         * ** TRAER DATOS DE SQL SERVER HACIA LA TABLA ***
         */
        try {
            String datos[] = new String[6];
            this.conectarBD();
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(buscar(filtroNombre()));

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                mdlTblProd.addRow(datos);
            }
            vp.txtFiltroNombreProd.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "listar " + e);
        } finally {
            this.desconectarBD();
        }
    }

    @Override
    public void nuevo() throws Exception {
        vp.txtArticuloProd.setText("");
        vp.cboMarcaProd.setSelectedIndex(0);
        vp.txtPrecioVentaPro.setText("");
        vp.txtStockProd.setText("");
        vp.cboCategoriaProd.setSelectedIndex(0);
        cambiarJP(JFPrincipal.jpCardProd, JFPrincipal.jpDatosProd);
        vp.btnRegistrarProd.setEnabled(true);
        vp.btnEliminarProd.setEnabled(false);
    }

    /* Registrar */
    private String articuloR() {
        String tr = vp.txtArticuloProd.getText();
        if (tr.equals("")) {
            tr = "";
        }
        return tr;
    }

    private String marcaR() {
        return (String) vp.cboMarcaProd.getSelectedItem();
    }

    private float precioVentaR() {
        String tr = vp.txtPrecioVentaPro.getText();
        return Float.parseFloat(tr);
    }

    private int stockR() {
        String tr = vp.txtStockProd.getText();
        return Integer.parseInt(tr);
    }

    private String categoriaR() {
        return (String) vp.cboCategoriaProd.getSelectedItem();
    }

    /* Filtros */
    private String filtroNombre() {
        return vp.txtFiltroNombreProd.getText();
    }

    /* Modificar */
    private int codigoM() {
        return Integer.parseInt(vp.txtCodigoProd.getText());
    }

    private String articuloM() {
        String tr = vp.txtArticuloProdM.getText();
        if (tr.equals("")) {
            tr = "";
        }
        return tr;
    }

    private String marcaM() {
        return (String) vp.cboMarcaProdM.getSelectedItem();
    }

    private float precioVentaM() {
        String tr = vp.txtPrecioVentaProM.getText();
        return Float.parseFloat(tr);
    }

    private int stockM() {
        String tr = vp.txtStockProdM.getText();
        return Integer.parseInt(tr);
    }

    private String categoriaM() {
        return (String) vp.cboCategoriaProdM.getSelectedItem();
    }

    private void cambiarJP(JPanel card, JPanel jp) {
        card.removeAll();
        card.repaint();
        card.add(jp);
        card.repaint();
        card.revalidate();
    }

    public void enviarProducto() {

        int fila = JFPrincipal.tblProducto.getSelectedRow();
        if (fila >= 0) {
            String cod = (String) JFPrincipal.tblProducto.getValueAt(fila, 0);
            int codProd = Integer.parseInt(cod);
            try {
                this.conectarBD();
                PreparedStatement ps = this.conexion.prepareStatement("select * from Producto where codProd = " + codProd);
                ResultSet rs = ps.executeQuery();
                rs.next();
                Producto prod = new Producto(rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getInt(5), rs.getString(6));
                ModeloVenta mdv = new ModeloVenta();
                JFPrincipal.txtSCodPro.setText(cod);
                JFPrincipal.txtSNombreProd.setText(prod.getArticulo());
                JFPrincipal.txtSPrecioProd.setText(String.valueOf(prod.getPrecioV()));
                JFPrincipal.txtSStock.setText(String.valueOf(prod.getStock()));
                cambiarJP(JFPrincipal.jpCardOpc, JFPrincipal.jpVenta);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "enviarProducto" + e);
            } finally {
                this.desconectarBD();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila de la Tabla para enviar los datos");
        }
    }
    
}
