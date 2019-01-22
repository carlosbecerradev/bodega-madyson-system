package modelo;

import dao.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vista.JFPrincipal;

public class Modelo extends Conexion {

    private JFPrincipal v;

    /* Iniciar Sesion */
    public void iniciarSesion() throws Exception {
        try {
            Conexion.setCuenta("madyson", "12345");
            this.conectarBD();
            if (Conexion.getStatus()) {
                PreparedStatement ps = this.conexion.prepareStatement("select usuEmp, contraEmp, cargoEmp, estado, nombApeEmp,codEmp from Empleado");
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    if (usuario().equals(rs.getString(1)) && contrasenia().equals(rs.getString(2))) {
                        if (rs.getInt(4) == 1) {
                            cambiarJP(JFPrincipal.jpBase, JFPrincipal.jpSistemaon);
                            JFPrincipal.lblNombUser.setText(rs.getString(3));
                            v.lblAtendidoPor.setText(rs.getString(5));
                            v.lblSCodEmpleado.setText(rs.getString(6));
                            if (rs.getString(3).equals("Administrador")) {
                                privilegiosAdmin();
                            } else {
                                privilegiosCajero();
                            }
                        } else {
                            v.lblMensajeLogin.setText("El usuario esta desactivado.");
                        }
                    } else {
                        v.lblMensajeLogin.setText("Usuario o contraseña incorrecto.");
                    }
                }
            }
        } catch (Exception e) {
        } finally {
            this.desconectarBD();
        }

    }

    private String usuario() {
        return v.txtUsuario.getText();
    }

    private String contrasenia() {
        return v.txtContrasenia.getText();
    }

    private void cambiarJP(JPanel card, JPanel jp) {
        card.removeAll();
        card.repaint();
        card.add(jp);
        card.repaint();
        card.revalidate();
    }

    /* Menu Principal */
    public void cerraSesion() {
        cambiarJP(JFPrincipal.jpBase, JFPrincipal.jpIniciarSesion);
        v.lblNombUser.setText("");
        v.lblMensajeLogin.setText("");
        v.txtUsuario.setText("");
        v.txtContrasenia.setText("");
        cambiarJP(JFPrincipal.jpCardOpc, JFPrincipal.jpVenta);
        this.desconectarBD();
    }

    public void privilegiosCajero() {
        /*Al iniciar */
        cambiarJP(JFPrincipal.jpCardOpc, JFPrincipal.jpVenta);
        /* Menu */
        v.btnJpReportes.setEnabled(false);
        v.btnJpMantenimiento.setEnabled(false);
        /* Empleado*/
        v.jpMUsuarios.hide();
        v.jTPMAntenimiento.setEnabledAt(2, false);
        v.jpCardEmp.hide();
        v.jpOpcionesEmp.hide();
        /* Producto */
        v.btnNuevoProd.hide();
        v.btnEliminarProd.hide();
        v.btnExtraerProd.hide();
        cambiarJP(JFPrincipal.jpCardProd, JFPrincipal.jpConsultaProd);
        /* Clientes */
        cambiarJP(JFPrincipal.jpCardCli, JFPrincipal.jpConsultaCli);
    }
    
    public void privilegiosAdmin(){
        /*Al iniciar */
        cambiarJP(JFPrincipal.jpCardOpc, JFPrincipal.jpVenta);
        /* Menu */
        v.btnJpReportes.setEnabled(true);
        v.btnJpMantenimiento.setEnabled(true);
        /* Empleado*/
        v.jpMUsuarios.show();
        v.jTPMAntenimiento.setEnabledAt(2, true);
        v.jpCardEmp.show();
        v.jpOpcionesEmp.show();
        /* Producto */
        v.btnNuevoProd.show();
        v.btnEliminarProd.show();
        v.btnExtraerProd.show();
    }

    public void salirSistema() {
        int a = JOptionPane.showConfirmDialog(null, "Estas seguro de salir");
        if (a == 0) {
            System.exit(0);
        }
    }

    public void jpVenta() {
        cambiarJP(JFPrincipal.jpCardOpc, JFPrincipal.jpVenta);
    }

    public void jpReporte() {
        cambiarJP(JFPrincipal.jpCardOpc, JFPrincipal.jpReportes);
    }

    public void jpMantenimiento() {
        cambiarJP(JFPrincipal.jpCardOpc, JFPrincipal.jpMantenimiento);
    }

}
