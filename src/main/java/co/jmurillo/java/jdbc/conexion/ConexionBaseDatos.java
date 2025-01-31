package co.jmurillo.java.jdbc.conexion;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static final String URL ="jdbc:mysql://localhost:3306/base_de_datos";
    private static final String USER = "root";
    private static final String PASSWORD = "pass";
    private static BasicDataSource poolConexion;
    //private static Connection conexion;

    // Singleton: Obtener instancia única de la conexión
//    public static Connection getConexion() throws SQLException {
//        if (conexion == null || conexion.isClosed()) {
//            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
//        }
//        return conexion;
//    }

    // Pool de coneciones.
    public static BasicDataSource getInstance() throws SQLException {
        if (poolConexion  == null) {
            poolConexion = new BasicDataSource();
            poolConexion.setUrl(URL);
            poolConexion.setUsername(USER);
            poolConexion.setPassword(PASSWORD);

            poolConexion.setInitialSize(2);
            poolConexion.setMinIdle(3);
            poolConexion.setMaxIdle(8);
            poolConexion.setMaxTotal(8);
        }
        return poolConexion;
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }

    // Cerrar conexión
    public static void cerrarPool() throws SQLException {
        if (poolConexion != null && !poolConexion.isClosed()) {
            poolConexion.close();
        }
    }



}
