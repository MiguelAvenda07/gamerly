package controller;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.Persona;
import model.PersonaDAO;

/**
 * Servlet encargado de buscar una suscripción por correo electrónico.
 * Si encuentra la persona, muestra un mensaje de confirmación y los datos.
 * Si no la encuentra, muestra un mensaje de error.
 */
@WebServlet("/BuscarServlet")
public class BuscarServlet extends HttpServlet {

    PersonaDAO perDAO = new PersonaDAO();

    /**
     * Procesa las solicitudes POST para buscar una persona por correo electrónico.
     * Si la persona existe, coloca sus datos y un mensaje de confirmación en los atributos de la request.
     * Si no existe, coloca un mensaje de error.
     *
     * @param request  Objeto HttpServletRequest con los datos de la solicitud.
     * @param response Objeto HttpServletResponse para enviar la respuesta.
     * @throws ServletException Si ocurre un error en el servlet.
     * @throws IOException      Si ocurre un error de entrada/salida.
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String correo = request.getParameter("correo");
        Persona persona = perDAO.buscar(correo);

        if (persona != null) {
            request.setAttribute("mensaje", "Confirma que eres " + persona.getNombre() + " " + persona.getApellido()
                    + " con el correo " + persona.getCorreo() + " y el número " + persona.getTelefono());
            request.setAttribute("persona", persona);
        } else {
            request.setAttribute("mensaje", "No se encontró ninguna suscripción con ese correo.");
        }
        RequestDispatcher view = request.getRequestDispatcher("cancelar.jsp");
        view.forward(request, response);
    }
}
