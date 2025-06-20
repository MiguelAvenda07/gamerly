package model;

import java.sql.Connection;
import db.DB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Clase de acceso a datos para la entidad Persona.
 * Permite agregar, buscar y eliminar personas en la base de datos.
 */
public class PersonaDAO {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = null;
    DB conexion = null;

    /**
     * Agrega una nueva persona a la base de datos.
     * 
     * @param p Objeto Persona a agregar.
     * @return true si la inserción fue exitosa, false si hubo error (por ejemplo, correo duplicado).
     */
    public boolean agregar(Persona p) {
        boolean insertado = false;
        try {
            conn = DB.getConexion();
            String query = "INSERT INTO persona (nombre, apellido, correo, telefono, playstation, xbox, nintendo, pc, esports, region) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellido());
            ps.setString(3, p.getCorreo());
            ps.setString(4, p.getTelefono());
            ps.setBoolean(5, p.isPlaystation());
            ps.setBoolean(6, p.isXbox());
            ps.setBoolean(7, p.isNintendo());
            ps.setBoolean(8, p.isPc());
            ps.setBoolean(9, p.isEsports());
            ps.setString(10, p.getRegion());
            ps.executeUpdate();
            insertado = true;
        } catch (java.sql.SQLException e) {
            // Código de error 1062 es para clave duplicada en MySQL
            if (e.getErrorCode() == 1062) {
                System.out.println("El correo ya está registrado.");
            } else {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) ps.close();
            } catch (Exception e) { /* ignored */ }
        }
        return insertado;
    }

    /**
     * Busca una persona en la base de datos por su correo electrónico.
     * 
     * @param correo Correo electrónico de la persona a buscar.
     * @return Objeto Persona si se encuentra, null si no existe.
     */
    public Persona buscar(String correo) {
        Persona persona = null;
        String query = "SELECT nombre, apellido, correo, telefono FROM persona WHERE correo = ?";
        try {
            conn = DB.getConexion();
            ps = conn.prepareStatement(query);
            ps.setString(1, correo);
            rs = ps.executeQuery();
            if (rs.next()) {
                persona = new Persona();
                persona.setNombre(rs.getString("nombre"));
                persona.setApellido(rs.getString("apellido"));
                persona.setCorreo(rs.getString("correo"));
                persona.setTelefono(rs.getString("telefono"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();
            } catch (Exception e) {
                /* ignored */ }
            try {
                if (ps != null)
                    ps.close();
            } catch (Exception e) {
                /* ignored */ }
        }
        return persona;
    }

    /**
     * Elimina una persona de la base de datos por su correo electrónico.
     * 
     * @param correo Correo electrónico de la persona a eliminar.
     * @return true si se eliminó al menos un registro, false si no se encontró la persona.
     */
    public boolean eliminar(String correo) {
        boolean eliminado = false;
        String query = "DELETE FROM persona WHERE correo = ?";
        try {
            conn = DB.getConexion();
            ps = conn.prepareStatement(query);
            ps.setString(1, correo);
            int filas = ps.executeUpdate();
            eliminado = filas > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null)
                    ps.close();
            } catch (Exception e) {
                /* ignored */ }
        }
        return eliminado;
    }
}