import java.sql.Connection;

public class TestConexion {
    public static void main(String[] args) {
        Connection conn = db.DB.getConexion();
        if (conn != null) {
            System.out.println("¡Conexión exitosa!");
        } else {
            System.out.println("No se pudo conectar.");
        }
    }
}