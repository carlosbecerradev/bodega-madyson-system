package modelo;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vista.JFPrincipal;

public class Modelo {

    private JFPrincipal v;

    /* Iniciar Sesion */
    public void iniciarSesion() {
        if (usuario().equals("admin") && contrasenia().equals("12345")) {
            cambiarJP(JFPrincipal.jpBase, JFPrincipal.jpSistemaon);
            JFPrincipal.lblNombUser.setText("Administrador");
        } else {
            JOptionPane.showMessageDialog(null, "?");
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
    }

    public void salirSistema() {
        int a = JOptionPane.showConfirmDialog(null, "Estas seguro de salir");
        if (a == 0) {
            System.exit(0);
        }
    }
    public void jpVenta(){
        cambiarJP(JFPrincipal.jpCardOpc, JFPrincipal.jpVenta);
        desactivarMant();
    }
    public void jpReporte(){
        cambiarJP(JFPrincipal.jpCardOpc, JFPrincipal.jpReportes);
        desactivarMant();
    }
    public void jpMantenimiento(){
        cambiarJP(JFPrincipal.jpCardOpc, JFPrincipal.jpMantenimiento);
        activarMant();
        
    }
    /* Mantenimiento */
    public void activarMant(){
        JFPrincipal.btnJpProd.setEnabled(true);
        JFPrincipal.btnJpUsuario.setEnabled(true);
        JFPrincipal.btnJpCliente.setEnabled(true);
        JFPrincipal.btnJpProve.setEnabled(true);
    }
    public void desactivarMant(){
        JFPrincipal.btnJpProd.setEnabled(false);
        JFPrincipal.btnJpUsuario.setEnabled(false);
        JFPrincipal.btnJpCliente.setEnabled(false);
        JFPrincipal.btnJpProve.setEnabled(false);
    }
    public void btnJpProd(){
        cambiarJP(JFPrincipal.jpMantenimiento, JFPrincipal.jpMProductos);
    }
    public void btnJpUsuario(){
        cambiarJP(JFPrincipal.jpMantenimiento, JFPrincipal.jpMUsuarios);
    }
    public void btnJpCliente(){
        cambiarJP(JFPrincipal.jpMantenimiento, JFPrincipal.jpMClientes);
    }
    public void btnJpProve(){
        cambiarJP(JFPrincipal.jpMantenimiento, JFPrincipal.jpMProveedores);
    }
}
