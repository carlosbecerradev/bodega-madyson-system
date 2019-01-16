package dao;

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
    /*Credenciales*/
    private final String USER = "sa";
    private final String PASS = "123";
    
    public void conectarBD() {
        try {
            Class.forName(JDBC_DRIVER);
            conexion = DriverManager.getConnection(BD_URL, USER, PASS);
        } catch (Exception e) {
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

}
;