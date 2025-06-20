package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase utilitaria para gestionar la conexión a la base de datos MySQL.
 */
public class DB {

    private static Connection connection;

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String url = "jdbc:mysql://localhost:3306/gamerly";
    private static String user = "root";
    private static String password = "Sistemas33_";

    /**
     * Constructor privado para evitar instanciación.
     */
    private DB() {
    }

    /**
     * Obtiene una conexión a la base de datos.
     * Si la conexión no existe, la crea y la retorna.
     * 
     * @return Connection objeto de conexión a la base de datos.
     */
    public static Connection getConexion() {
        if (connection == null) {
            try {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                // Maneja errores de SQL al intentar conectar
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // Maneja errores si el driver no se encuentra
                e.printStackTrace();
            }
        }
        return connection;
    }

}