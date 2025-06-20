import model.Persona;
import model.PersonaDAO;

public class TestInsertPersona {
    public static void main(String[] args) {
        // Crea un objeto Persona con datos de prueba
        Persona persona = new Persona(
            "Miguel",           // nombre
            "García",           // apellido
            "miguel@email.com", // correo
            "1234567890",       // telefono
            true,               // playstation
            false,              // xbox
            true,               // nintendo
            true,               // pc
            false,              // esports
            "Latam"             // region
        );

        // Crea el DAO y llama al método agregar
        PersonaDAO dao = new PersonaDAO();
        dao.agregar(persona);

        System.out.println("Persona insertada. Verifica en la base de datos.");
    }
}