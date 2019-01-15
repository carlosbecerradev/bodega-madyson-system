package modelo;

import bean.Cliente;
import dao.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import dao.CRUD;
import java.awt.Color;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import vista.JFCliente;

public class ModeloCliente extends Conexion implements CRUD {

    private DefaultTableModel mdlTblCli;
    private JFCliente jfCliente;

    public void inicioJFCliente() {
        tabla();
    }

    public void tabla() {
        mdlTblCli = (DefaultTableModel) jfCliente.tblCliente.getModel();
        jfCliente.jScrollPane1.getViewport().setBackground(Color.white);
    }

    @Override
    public void registrar() throws Exception {
        try {
            Cliente cli = new Cliente(nombre() + " " + apePat() + " " + apeMat(), dni(), ruc(), genero());

            this.conectarBD();
            PreparedStatement ps = this.conexion.prepareStatement("insert into Cliente values (?, ?, ?, ?)");
            ps.setString(1, cli.getNombCli());
            ps.setString(2, cli.getDniCli());
            ps.setString(3, cli.getRucCli());
            ps.setString(4, cli.getGeneroCli());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Registrados en SQL SERVER");
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectarBD();
        }
    }

    @Override
    public String buscar(String filtro) throws Exception {
        String consultar = "";

        try {
            if (filtro.equals("")) {
                consultar = "select * from Cliente";
            } else {
                consultar = "select * from Cliente where dniCli  like '" + filtro + "%'";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los datos");
        }
        return consultar;
    }

    @Override
    public void extraer() throws Exception {
        try {
            this.conectarBD();
            Statement st = this.conexion.createStatement();
            
            int fila = jfCliente.tblCliente.getSelectedRow();
            if (fila < 0) {
                jfCliente.txtCodigoCli.setText((String) jfCliente.tblCliente.getValueAt(fila, 0));
                /**/
                String nombres = (String) jfCliente.tblCliente.getValueAt(fila, 1);
                String separarNombres[] = nombres.split(" ");
                jfCliente.txtNombreCli.setText(separarNombres[0]);
                jfCliente.txtApePatCli.setText(separarNombres[1]);
                jfCliente.txtApeMatCli.setText(separarNombres[2]);
                /**/
                jfCliente.txtDniCli.setText((String) jfCliente.tblCliente.getValueAt(fila, 2));
                jfCliente.txtRucCli.setText((String) jfCliente.tblCliente.getValueAt(fila, 3));
                /**/
                String genero = (String) jfCliente.tblCliente.getValueAt(fila, 4);
                switch (genero) {
                    case "M":
                        jfCliente.cboGeneroCli.setSelectedIndex(1);
                        break;
                    case "F":
                        jfCliente.cboGeneroCli.setSelectedIndex(2);
                        break;
                    default:
                        jfCliente.cboGeneroCli.setSelectedIndex(0);
                        break;
                }

            } else {
                JOptionPane.showMessageDialog(null, "Seleccione una fila de la tabla para modificar.");
            }

            //JOptionPane.showMessageDialog(null, "Datos extraidos.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo encontrar los datos");
        } finally {
            this.desconectarBD();
        }
    }

    @Override
    public void actualizar() throws Exception {
        try {
            this.conectarBD();
            PreparedStatement st = this.conexion.prepareStatement("update Cliente set nombApeCli = '" + nombre() + " " + apePat() + " " + apeMat() + "',"
                    + " dniCli = '" + dni() + "', rucCli = '" + ruc() + "', genCli = '" + genero() + "'");
            st.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectarBD();
        }
    }

    @Override
    public void eliminar() throws Exception {
        int confirmar = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar el empleado?");
        if (confirmar == 0) {
            int fila = jfCliente.tblCliente.getSelectedRow();
            int codigo = (int)jfCliente.tblCliente.getValueAt(fila, 0);
            try {
                this.conectarBD();
                PreparedStatement ppt = this.conexion.prepareStatement("delete from Cliente where codCli = " + codigo);
                ppt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cliente eliminado");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error" + e);
            } finally {
                this.desconectarBD();
            }
        }
    }

    @Override
    public void listar() throws Exception {
        //limpiar la tabla
        int filas = mdlTblCli.getRowCount();
        for (int i = 0; i < filas; i++) {
            mdlTblCli.removeRow(0);
        }
        /**
         * ** TRAER DATOS DE SQL SERVER HACIA LA TABLA ***
         */
        String datos[] = new String[5];
        try {
            this.conectarBD();
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(buscar(filtroNombre()));

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                mdlTblCli.addRow(datos);
            }
            jfCliente.txtFiltroNombre.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Recuerde, los codigos son números.");
        } finally {
            this.desconectarBD();
        }
    }

    @Override
    public void limpiar() throws Exception {
        jfCliente.txtCodigoCli.setText("");
        jfCliente.txtNombreCli.setText("");
        jfCliente.txtApePatCli.setText("");
        jfCliente.txtApeMatCli.setText("");
        jfCliente.txtDniCli.setText("");
        jfCliente.txtRucCli.setText("");
        jfCliente.cboGeneroCli.setSelectedIndex(0);
    }

    private int codigo() {
        return Integer.parseInt(jfCliente.txtCodigoCli.getText());
    }

    private String nombre() {
        return jfCliente.txtNombreCli.getText();
    }

    private String apePat() {
        return jfCliente.txtApePatCli.getText();
    }

    private String apeMat() {
        return jfCliente.txtApeMatCli.getText();
    }

    private String dni() {
        return jfCliente.txtDniCli.getText();
    }

    private String ruc() {
        return jfCliente.txtRucCli.getText();
    }

    private String genero() {
        String genero = null;
        switch (jfCliente.cboGeneroCli.getSelectedIndex()) {
            case 1:
                genero = "M";
                break;
            case 2:
                genero = "F";
                break;
            default:
                break;
        }
        return genero;
    }

    /* Filtros de busqueda */
    private String filtroNombre() {
        return jfCliente.txtFiltroNombre.getText();
    }
}
