package co.jmurillo.java.jdbc.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static final String URL ="jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection conexion;

    // Singleton: Obtener instancia única de la conexión
    public static Connection getConexion() throws SQLException {
        if (conexion == null || conexion.isClosed()) {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return conexion;
    }

    // Cerrar conexión
    public static void cerrarConexion() throws SQLException {
        if (conexion != null || !conexion.isClosed()) {
            conexion.close();
        }
    }
}
