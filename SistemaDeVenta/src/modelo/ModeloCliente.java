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
            Cliente cli = new Cliente(nombreR() + " " + apePatR() + " " + apeMatR(), dniR(), rucR(), generoR());
            this.conectarBD();
            PreparedStatement ps = this.conexion.prepareStatement("insert into Cliente values (?, ?, ?, ?)");
            ps.setString(1, cli.getNombCli());
            ps.setString(2, cli.getDniCli());
            ps.setString(3, cli.getRucCli());
            ps.setString(4, cli.getGeneroCli());
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
            this.conectarBD();
            Statement st = this.conexion.createStatement();

            int fila = vp.tblCliente.getSelectedRow();
            if (fila >= 0) {
                vp.txtCodigoCliM.setText((String) vp.tblCliente.getValueAt(fila, 0));
                /**/
                String nombres = (String) vp.tblCliente.getValueAt(fila, 1);
                String separarNombres[] = nombres.split(" ");
                vp.txtNombreCliM.setText(separarNombres[0]);
                vp.txtApePatCliM.setText(separarNombres[1]);
                vp.txtApeMatCliM.setText(separarNombres[2]);
                /**/
                vp.txtDniCliM.setText((String) vp.tblCliente.getValueAt(fila, 2));
                vp.txtRucCliM.setText((String) vp.tblCliente.getValueAt(fila, 3));
                /**/
                String genero = (String) vp.tblCliente.getValueAt(fila, 4);
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
            PreparedStatement st = this.conexion.prepareStatement("update Cliente set nombApeCli = '" + nombreM() + " " + apePatM() + " " + apeMatM() + "',"
                    + " dniCli = '" + dniM() + "' , rucCli = '" + rucM() + "', genCli = '" + generoM() + "'  where codCli = " + codigoM());
            st.executeUpdate();
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
                String cod = (String)JFPrincipal.tblCliente.getValueAt(fila, 0);
                int codigo =  Integer.parseInt(cod);
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


public void consultar(){
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
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
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
        String tr = null;
        if (tr == null) {
            tr = vp.txtNombreCli.getText();
        }
        return tr;
    }

    private String apePatR() {
        String tr = null;
        if (tr == null) {
            tr = vp.txtApePatCli.getText();
        }
        return tr;
    }

    private String apeMatR() {
        String tr = null;
        if (tr == null) {
            tr = vp.txtApeMatCli.getText();
        }
        return tr;
    }

    private String dniR() {
        String tr = null;
        if (tr == null) {
            tr = vp.txtDniCli.getText();
        }
        return tr;
    }

    private String rucR() {
        String tr = null;
        if (tr == null) {
            tr = vp.txtRucCli.getText();
        }
        return tr;
    }

    private String generoR() {
        String genero = null;
        switch (vp.cboGeneroCli.getSelectedIndex()) {
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
        return vp.txtFiltroNombre.getText();
    }

    /* Modificar */
    private int codigoM() {
        return Integer.parseInt(vp.txtCodigoCliM.getText());
    }

    private String nombreM() {
        return vp.txtNombreCli.getText();
    }

    private String apePatM() {
        return vp.txtApePatCli.getText();
    }

    private String apeMatM() {
        return vp.txtApeMatCli.getText();
    }

    private String dniM() {
        return vp.txtDniCli.getText();
    }

    private String rucM() {
        return vp.txtRucCli.getText();
    }

    private String generoM() {
        String genero = null;
        switch (vp.cboGeneroCli.getSelectedIndex()) {
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

    private void cambiarJP(JPanel card, JPanel jp) {
        card.removeAll();
        card.repaint();
        card.add(jp);
        card.repaint();
        card.revalidate();
    }

}
