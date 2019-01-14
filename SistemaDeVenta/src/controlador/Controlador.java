package controlador;
import vista.JFIniciarSesion;
import javax.swing.JFrame;

public class Controlador {
    
    private JFIniciarSesion jfIniSes;
    
    public Controlador(JFIniciarSesion jfIniSes){
        this.jfIniSes = jfIniSes;
    }
    public void iniciar() {
        jfIniSes.pack();
        jfIniSes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfIniSes.setLocationRelativeTo(null);
        jfIniSes.setVisible(true);
    }
    
}
