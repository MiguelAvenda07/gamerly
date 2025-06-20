import model.PersonaDAO;

public class TestEliminar {
    public static void main(String[] args) {
        PersonaDAO dao = new PersonaDAO();
        String telefono = "123456789"; // Cambia por un teléfono que exista en tu base de datos

        boolean eliminado = dao.eliminar(telefono);

        if (eliminado) {
            System.out.println("La persona con teléfono " + telefono + " fue eliminada correctamente.");
        } else {
            System.out.println("No se encontró ninguna persona con ese teléfono para eliminar.");
        }
    }
}