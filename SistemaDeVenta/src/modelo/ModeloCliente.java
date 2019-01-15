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
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import vista.JFPrincipal;

public class ModeloCliente extends Conexion implements CRUD {

    private DefaultTableModel mdlTblCli;
    private JFPrincipal vp;

    public void inicioJFCliente() {
        tabla();
    }

    public void tabla() {
        mdlTblCli = (DefaultTableModel) vp.tblCliente.getModel();
        vp.jScrollPane1.getViewport().setBackground(Color.white);
    }

    @Override
    public void registrar() throws Exception {
        try {
            Cliente cli = new Cliente(nombreR(), apellidos(), dniR(), rucR(), generoR());
            this.conectarBD();
            PreparedStatement ps = this.conexion.prepareStatement("insert into Cliente values (?, ?, ?, ?)");
            ps.setString(1, cli.getNombCli());
            ps.setString(2, cli.getApeCli());
            ps.setString(3, cli.getDniCli());
            ps.setString(4, cli.getRucCli());
            ps.setString(5, cli.getGeneroCli());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Registrados en SQL SERVER");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "registrar " + e);
        } finally {
            this.desconectarBD();
        }
    }

    @Override
    public void extraer() throws Exception {
        try {

            int fila = JFPrincipal.tblCliente.getSelectedRow();
            if (fila >= 0) {
                String cod = (String) JFPrincipal.tblCliente.getValueAt(fila, 0);
                this.conectarBD();
                Statement st = this.conexion.createStatement();
                ResultSet rs = st.executeQuery("select * from Cliente where codCli = " + cod);
                String datos[] = new String[6];
                rs.next();
                datos[0] = rs.getString(2);
                datos[1] = rs.getString(3);
                datos[2] = rs.getString(4);
                datos[3] = rs.getString(5);
                datos[4] = rs.getString(6);
                datos[5] = rs.getString(7);
                
                vp.txtNombreCliM.setText(datos[0]);
                vp.txtApePatCliM.setText(datos[1]);
                vp.txtApeMatCliM.setText(datos[2]);
                /**/
                vp.txtDniCliM.setText(datos[3]);
                vp.txtRucCliM.setText(datos[4]);
                /**/
                String genero = datos[5];
                switch (genero) {
                    case "M":
                        vp.cboGeneroCliM.setSelectedIndex(1);
                        break;
                    case "F":
                        vp.cboGeneroCliM.setSelectedIndex(2);
                        break;
                    default:
                        vp.cboGeneroCliM.setSelectedIndex(0);
                        break;
                }
                cambiarJP(JFPrincipal.jpCardCli, JFPrincipal.jpModificar);
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
            PreparedStatement ps = this.conexion.prepareStatement("update Cliente set nombApeCli = '" + nombreM() + " " + apePatM() + " " + apeMatM() + "' "
                    + " , dniCli = '" + dniM() + "' , rucCli = '" + rucM() + "', genCli = '" + generoM() + "'  where codCli = " + codigoM() + " ");
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "actualizar " + e);
        } finally {
            this.desconectarBD();
        }
    }

    @Override
    public void eliminar() throws Exception {

        int fila = JFPrincipal.tblCliente.getSelectedRow();
        if (fila >= 0) {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar el empleado?");
            if (confirmar == 0) {
                String cod = (String) JFPrincipal.tblCliente.getValueAt(fila, 0);
                int codigo = Integer.parseInt(cod);
                try {
                    this.conectarBD();
                    PreparedStatement ppt = this.conexion.prepareStatement("delete from Cliente where codCli = " + codigo);
                    ppt.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Cliente eliminado");
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

    public void consultar() {
        cambiarJP(JFPrincipal.jpCardCli, JFPrincipal.jpConsultaCli);
    }

    @Override
    public String buscar(String filtro) throws Exception {
        String consultar = "";
        try {
            if (filtro.equals("")) {
                consultar = "select * from Cliente";
            } else {
                consultar = "select * from Cliente where nombApeCli  like '%" + filtro + "%'";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los datos");
        }
        return consultar;
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
        try {
            String datos[] = new String[5];
            this.conectarBD();
            Statement st = this.conexion.createStatement();
            ResultSet rs = st.executeQuery(buscar(filtroNombre()));

            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2) + rs.getString(3) + rs.getString(4);
                datos[2] = rs.getString(5);
                datos[3] = rs.getString(6);
                datos[4] = rs.getString(7);
                mdlTblCli.addRow(datos);
            }
            vp.txtFiltroNombre.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "listar " + e);
        } finally {
            this.desconectarBD();
        }
    }

    @Override
    public void nuevo() throws Exception {
        //vp.txtCodigoCliM.setText("");
        vp.txtNombreCli.setText("");
        vp.txtApePatCli.setText("");
        vp.txtApeMatCli.setText("");
        vp.txtDniCli.setText("");
        vp.txtRucCli.setText("");
        vp.cboGeneroCli.setSelectedIndex(0);
        cambiarJP(JFPrincipal.jpCardCli, JFPrincipal.jpDatosCli);
    }

    /* Registrar */
    private String nombreR() {
        String tr = vp.txtNombreCli.getText();
        if (tr.equals("")) {
            tr = "";
        }
        return tr;
    }

    private String apePatR() {
        String tr = vp.txtApePatCli.getText();
        if (tr.equals("")) {
            tr = "";
        }
        return tr;
    }

    private String apeMatR() {
        String tr = vp.txtApeMatCli.getText();
        if (tr.equals("")) {
            tr = "";
        }
        return tr;
    }

    private String dniR() {
        String tr = vp.txtDniCli.getText();
        if (tr.equals("")) {
            tr = "";
        }
        return tr;
    }

    private String rucR() {
        String tr = vp.txtRucCli.getText();
        if (tr.equals("")) {
            tr = "";
        }
        return tr;
    }

    private String generoR() {
        int genero = vp.cboGeneroCli.getSelectedIndex();
        String gen = null;
        switch (genero) {
            case 1:
                gen = "M";
                break;
            case 2:
                gen = "F";
                break;
            default:
                break;
        }
        return gen;
    }

    /* Filtros de busqueda */
    private String filtroNombre() {
        return vp.txtFiltroNombre.getText();
    }

    /* Modificar */
    private int codigoM() {
        return Integer.parseInt(vp.txtCodigoCliM.getText());
    }

    private String nombreM() {
        String tr = vp.txtNombreCliM.getText();
        if (tr.equals("")) {
            tr = "";
        }
        return tr;
    }

    private String apellidos() {
        String tr = vp.txtApePatCliM.getText();
        String ap = vp.txtApeMatCliM.getText();
        if (tr.equals("")) {
            tr = "";
        }
        return tr;
    }

    private String dniM() {
        String tr = vp.txtDniCliM.getText();
        if (tr.equals("")) {
            tr = "";
        }
        return tr;
    }

    private String rucM() {
        String tr = vp.txtRucCliM.getText();
        if (tr.equals("")) {
            tr = "";
        }
        return tr;
    }

    private String generoM() {
        int genero = vp.cboGeneroCliM.getSelectedIndex();
        String gen = null;
        switch (genero) {
            case 1:
                gen = "M";
                break;
            case 2:
                gen = "F";
                break;
            default:
                break;
        }
        return gen;
    }

    private void cambiarJP(JPanel card, JPanel jp) {
        card.removeAll();
        card.repaint();
        card.add(jp);
        card.repaint();
        card.revalidate();
    }

}
