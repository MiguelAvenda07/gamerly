
import model.Persona;
import model.PersonaDAO;

public class TestBuscar{
    public static void main(String[] args) {
        PersonaDAO dao = new PersonaDAO();
        String telefono = "123456789"; // Cambia por un teléfono que exista en tu base de datos
        Persona persona = dao.buscar(telefono);

        if (persona != null) {
            System.out.println("Persona encontrada:");
            System.out.println("Nombre: " + persona.getNombre());
            System.out.println("Apellido: " + persona.getApellido());
            System.out.println("Correo: " + persona.getCorreo());
        } else {
            System.out.println("No se encontró ninguna persona con ese teléfono.");
        }
    }
}