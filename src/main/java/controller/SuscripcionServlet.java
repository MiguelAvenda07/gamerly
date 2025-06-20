package controller;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Persona;
import model.PersonaDAO;

/**
 * Servlet encargado de procesar las solicitudes de suscripción.
 * Recibe los datos del formulario, los valida y los almacena en la base de datos.
 */
@WebServlet("/SuscripcionServlet")
public class SuscripcionServlet extends HttpServlet {

    PersonaDAO perDAO = new PersonaDAO();

    /**
     * Procesa las solicitudes POST del formulario de suscripción.
     * Obtiene los datos del formulario, crea un objeto Persona y lo guarda en la base de datos.
     * Si la suscripción es exitosa, muestra un mensaje de éxito.
     * Si el correo ya está registrado, muestra un mensaje de error.
     *
     * @param request  Objeto HttpServletRequest con los datos de la solicitud.
     * @param response Objeto HttpServletResponse para enviar la respuesta.
     * @throws ServletException Si ocurre un error en el servlet.
     * @throws IOException      Si ocurre un error de entrada/salida.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");

        // Recibe todas las consolas seleccionadas como un array
        String[] consolas = request.getParameterValues("consolas");
        boolean playstation = false, xbox = false, nintendo = false, pc = false;
        if (consolas != null) {
            for (String consola : consolas) {
                if ("playstation".equals(consola)) playstation = true;
                if ("xbox".equals(consola)) xbox = true;
                if ("nintendo".equals(consola)) nintendo = true;
                if ("pc".equals(consola)) pc = true;
            }
        }

        boolean esports = "si".equals(request.getParameter("esports"));
        String region = request.getParameter("region");
        if (region == null) region = "";

        Persona per = new Persona(nombre, apellido, correo, telefono, playstation, xbox, nintendo, pc, esports, region);
        boolean insertado = perDAO.agregar(per);

        if (insertado) {
            request.setAttribute("mensaje", "¡Suscripción exitosa! Muy pronto recibirás las noticias en tu correo...");
        } else {
            request.setAttribute("error", "El correo ya está registrado.");
        }
        RequestDispatcher view = request.getRequestDispatcher("suscripcion.jsp");
        view.forward(request, response);
    }
}
