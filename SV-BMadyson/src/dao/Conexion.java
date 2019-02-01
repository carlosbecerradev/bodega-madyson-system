package dao;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    // variable que permite consultar a bd
    public Connection conexion;
    // JDBC Driver, nombre de la base de datos y la url.
    private final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String BD_NOMBRE = "BodegaMadyson";
    private final String BD_URL = "jdbc:sqlserver://localhost:1433;databaseName=" + BD_NOMBRE;
    
    // Nos conecta con la BD
    public void conectarBD() {
        try {
            Class.forName(JDBC_DRIVER);
            conexion = DriverManager.getConnection(BD_URL, "madyson", "12345");
        } catch (SQLServerException e) {
            JOptionPane.showConfirmDialog(null, e);//"El usuario o contraseña no existe"
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "conectarBD: " + e.getMessage());
        }
    }
    // Nos desconecta con la bd
    public void desconectarBD() {
        try {
            if (conexion != null) {
                if (!conexion.isClosed()) {
                    conexion.close();
                }
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "desconectarBD: " +  e.getMessage());
        }
    }
    
    
}
