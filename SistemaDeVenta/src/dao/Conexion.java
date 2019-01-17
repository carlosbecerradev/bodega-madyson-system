package dao;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    protected Connection conexion;
    // JDBC Driver, nombre y nombre de la base de datos
    private final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String BD_NOMBRE = "BodegaMadyson";
    private final String HOSTNAME = "Ulises-pc"; // cambiar
    private final String BD_URL = "jdbc:sqlserver://" + HOSTNAME + ":1433;databaseName=" + BD_NOMBRE;
    /*Credenciales
    private final String USER = "sa";
    private final String PASS = "123";*/
    /* Login */
    public static String usuario;
    public static String contrasenha;
    public static boolean status = false;
    
    public void conectarBD() {
        status = false;
        try {
            Class.forName(JDBC_DRIVER);
            conexion = DriverManager.getConnection(BD_URL, Conexion.usuario, Conexion.contrasenha);
            status = true;
        } catch (SQLServerException e) {
            //JOptionPane.showConfirmDialog(null, "El usuario o contraseña no existe");
        }catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "conectarBD " + e.getMessage());
        }
    }

    public void desconectarBD() {
        try {
            if (conexion != null) {
                if (!conexion.isClosed()) {
                    conexion.close();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "desconectarBD " +  e.getMessage());
        }
    }
    
    public static void setCuenta(String usuario, String contrasenha) {
        Conexion.usuario = usuario;
        Conexion.contrasenha = contrasenha;        
    }
    
    public static boolean getStatus(){
        return status;
    }
    
}
