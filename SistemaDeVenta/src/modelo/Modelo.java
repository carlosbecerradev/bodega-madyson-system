package modelo;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import vista.JFPrincipal;

public class Modelo {

    private JFPrincipal v;

    /* Iniciar Sesion */
    public void iniciarSesion() {
        if (usuario().equals("admin") && contrasenia().equals("12345")) {
            JOptionPane.showMessageDialog(null, "correcto");
            cambiarJP(JFPrincipal.jpBase, JFPrincipal.jpSistemaon);
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
        cambiarJP(JFPrincipal.jpCardMant, JFPrincipal.jpVenta);
    }
    public void jpReporte(){
        cambiarJP(JFPrincipal.jpCardMant, JFPrincipal.jpReportes);
    }
    public void jpMantenimiento(){
        cambiarJP(JFPrincipal.jpCardMant, JFPrincipal.jpMantenimiento);
    }
    /* Mantenimiento */
}
