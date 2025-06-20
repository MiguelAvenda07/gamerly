package controller;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import model.PersonaDAO;

/**
 * Servlet encargado de eliminar una suscripción por correo electrónico.
 * Recibe el correo, elimina la persona de la base de datos y muestra un mensaje de confirmación o error.
 */
@WebServlet("/EliminarServlet")
public class EliminarServlet extends HttpServlet {

    PersonaDAO perDAO = new PersonaDAO();

    /**
     * Procesa las solicitudes POST para eliminar una persona por correo electrónico.
     * Si la eliminación es exitosa, muestra un mensaje de éxito.
     * Si no se encuentra la persona, muestra un mensaje de error.
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
        boolean eliminado = perDAO.eliminar(correo);

        if (eliminado) {
            request.setAttribute("mensaje", "Suscripción eliminada exitosamente.");
        } else {
            request.setAttribute("mensaje", "Error al eliminar la suscripción.");
        }
        RequestDispatcher view = request.getRequestDispatcher("cancelar.jsp");
        view.forward(request, response);
    }
}
