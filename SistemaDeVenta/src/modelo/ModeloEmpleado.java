/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import bean.Empleado;
import bean.Empleado;
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
public class ModeloEmpleado extends Conexion implements CRUD {

    private DefaultTableModel mdlTblEmp;
    private JFPrincipal vp;

    public void inicioJFEmpleado() {
        tabla();
    }

    public void tabla() {
        mdlTblEmp = (DefaultTableModel) vp.tblEmpleado.getModel();
        vp.jSPEmp.getViewport().setBackground(Color.white);
    }

    @Override
    public void registrar() throws Exception {
        try {
            Empleado emp = new Empleado(nombresR(), cargoR(), dniR(), usuarioR(), contraR(), generoR(), estadoR());
            this.conectarBD();
            PreparedStatement ps = this.conexion.prepareStatement("insert into Empleado values (?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, emp.getNombEmp());
            ps.setString(2, emp.getCargoEmp());
            ps.setString(3, emp.getDni());
            ps.setString(4, emp.getUsuario());
            ps.setString(5, emp.getContrasenia());
            ps.setString(6, emp.getGeneroEmp());
            ps.setInt(7, emp.getEstadoEmp());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Registrados");
            vp.btnRegistrarEmp.setEnabled(false);
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
                consultar = "select * from Empleado";
            } else {
                consultar = "select * from Empleado where nombApeEmp  like '%" + filtro + "%'";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo mostrar los datos");
        }
        return consultar;
    }

    @Override
    public void extraer() throws Exception {
        try {

            int fila = JFPrincipal.tblEmpleado.getSelectedRow();
            if (fila >= 0) {
                String cod = (String) JFPrincipal.tblEmpleado.getValueAt(fila, 0);
                this.conectarBD();
                Statement st = this.conexion.createStatement();
                ResultSet rs = st.executeQuery("select * from Empleado where codEmp = " + cod);
                String datos[] = new String[7];
                rs.next();
                datos[0] = rs.getString(2);
                datos[1] = rs.getString(3);
                datos[2] = rs.getString(4);
                datos[3] = rs.getString(5);
                datos[4] = rs.getString(6);
                datos[5] = rs.getString(7);
                datos[6] = rs.getString(8);

                vp.txtCodigoEmpM.setText(cod);
                vp.txtNombresEmpM.setText(datos[0]);
                String cargo = datos[1];
                switch (cargo) {
                    case "Administrador":
                        vp.cboCargoEmpM.setSelectedIndex(1);
                        break;
                    case "Cajero":
                        vp.cboCargoEmpM.setSelectedIndex(2);
                        break;
                    default:
                        vp.cboCargoEmpM.setSelectedIndex(0);
                        break;
                }
                vp.txtDniEmpM.setText(datos[2]);

                vp.txtUsuarioEmpM.setText(datos[3]);
                vp.txtContraEmpM.setText(datos[4]);
                /**/
                String genero = datos[5];
                switch (genero) {
                    case "M":
                        vp.cboGeneroEmpM.setSelectedIndex(1);
                        break;
                    case "F":
                        vp.cboGeneroEmpM.setSelectedIndex(2);
                        break;
                    default:
                        vp.cboGeneroEmpM.setSelectedIndex(0);
                        break;
                }
                String estado = datos[6];
                switch (estado) {
                    case "1":
                        vp.cboEstadoEmpM.setSelectedIndex(1);
                        break;
                    case "0":
                        vp.cboEstadoEmpM.setSelectedIndex(2);
                        break;
                    default:
                        vp.cboEstadoEmpM.setSelectedIndex(0);
                        break;
                }
                cambiarJP(JFPrincipal.jpCardEmp, JFPrincipal.jpModificarEmp);
                vp.btnActualizarEmp.setEnabled(true);
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
            PreparedStatement ps = this.conexion.prepareStatement("update Empleado set nombApeEmp = '" + nombresM()
                    + "', cargoEmp = '" + cargoM() + "', dniEmp = '" + dniM() + "', usuEmp = '" + usuarioM()
                    + "', contraEmp = '" + contraM() + "', genEmp = '" + generoM() + "', estado = '" + estadoM()
                    + "'  where codEmp = " + codigoM());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            vp.btnActualizarEmp.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "actualizar " + e);
        } finally {
            this.desconectarBD();
        }
    }

    @Override
    public void consultar() throws Exception {
        cambiarJP(JFPrincipal.jpCardEmp, JFPrincipal.jpConsultaEmp);
    }

    @Override
    public void eliminar() throws Exception {
        int fila = JFPrincipal.tblEmpleado.getSelectedRow();
        if (fila >= 0) {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Estas seguro de eliminar el empleado?");
            if (confirmar == 0) {
                String cod = (String) JFPrincipal.tblEmpleado.getValueAt(fila, 0);
                int codigo = Integer.parseInt(cod);
                try {
                    this.conectarBD();
                    PreparedStatement ps = this.conexion.prepareStatement("delete from Empleado where codEmp = " + codigo);
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
        int filas = mdlTblEmp.getRowCount();
        for (int i = 0; i < filas; i++) {
            mdlTblEmp.removeRow(0);
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
                String cinco = rs.getString(5);
                String seis = rs.getString(6);
                datos[4] = rs.getString(7);
                String estado = "";
                switch (rs.getInt(8)) {
                    case 1:
                        estado = "Activo";
                        break;
                    case 0:
                        estado = "Inactivo";
                        break;
                    default:
                        break;
                }
                datos[5] = estado;
                mdlTblEmp.addRow(datos);
            }
            vp.txtFiltroNombreEmp.requestFocus();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "listar " + e);
        } finally {
            this.desconectarBD();
        }
    }

    @Override
    public void nuevo() throws Exception {
        //vp.txtCodigoCliM.setText("");
        vp.txtNombreEmp.setText("");
        vp.cboCargoEmp.setSelectedIndex(0);
        vp.txtDniEmp.setText("");
        vp.txtUsuarioEmp.setText("");
        vp.txtContraEmp.setText("");
        vp.cboGeneroEmp.setSelectedIndex(0);
        vp.cboEstadoEmp.setSelectedIndex(0);
        cambiarJP(JFPrincipal.jpCardEmp, JFPrincipal.jpDatosEmp);
        vp.btnRegistrarEmp.setEnabled(true);
    }

    /* REGISTRAR*/
    private String nombresR() {
        String tr = vp.txtNombreEmp.getText();
        if (tr.equals("")) {
            tr = "";
        }
        return tr;
    }

    private String cargoR() {
        int cargo = vp.cboCargoEmp.getSelectedIndex();
        String car = null;
        switch (cargo) {
            case 1:
                car = "Administrador";
                break;
            case 2:
                car = "Cajero";
                break;
            default:
                break;
        }
        return car;
    }

    private String dniR() {
        String tr = vp.txtDniEmp.getText();
        if (tr.equals("")) {
            tr = "";
        }
        return tr;
    }

    private String usuarioR() {
        String tr = vp.txtUsuarioEmp.getText();
        if (tr.equals("")) {
            tr = "";
        }
        return tr;
    }

    private String contraR() {
        String tr = vp.txtContraEmp.getText();
        if (tr.equals("")) {
            tr = "";
        }
        return tr;
    }

    private String generoR() {
        int genero = vp.cboGeneroEmp.getSelectedIndex();
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

    private int estadoR() {
        int estado = vp.cboEstadoEmp.getSelectedIndex();
        int est = 1;
        switch (estado) {
            case 1:
                est = 1;
                break;
            case 2:
                est = 0;
                break;
            default:
                break;
        }
        return est;
    }

    /* Filtros */
    private String filtroNombre() {
        return vp.txtFiltroNombreEmp.getText();
    }

    /* Modificar */
    private int codigoM() {
        return Integer.parseInt(vp.txtCodigoEmpM.getText());
    }

    private String nombresM() {
        String tr = vp.txtNombresEmpM.getText();
        if (tr.equals("")) {
            tr = "";
        }
        return tr;
    }

    private String cargoM() {
        int cargo = vp.cboCargoEmpM.getSelectedIndex();
        String car = null;
        switch (cargo) {
            case 1:
                car = "Administrador";
                break;
            case 2:
                car = "Cajero";
                break;
            default:
                break;
        }
        return car;
    }

    private String dniM() {
        String tr = vp.txtDniEmpM.getText();
        if (tr.equals("")) {
            tr = "";
        }
        return tr;
    }

    private String usuarioM() {
        String tr = vp.txtUsuarioEmpM.getText();
        if (tr.equals("")) {
            tr = "";
        }
        return tr;
    }

    private String contraM() {
        String tr = vp.txtContraEmpM.getText();
        if (tr.equals("")) {
            tr = "";
        }
        return tr;
    }

    private String generoM() {
        int genero = vp.cboGeneroEmpM.getSelectedIndex();
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

    private int estadoM() {
        int estado = vp.cboEstadoEmpM.getSelectedIndex();
        int est = 1;
        switch (estado) {
            case 1:
                est = 1;
                break;
            case 2:
                est = 0;
                break;
            default:
                break;
        }
        return est;
    }

    private void cambiarJP(JPanel card, JPanel jp) {
        card.removeAll();
        card.repaint();
        card.add(jp);
        card.repaint();
        card.revalidate();
    }

}
