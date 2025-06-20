<%@ page contentType="text/html; charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Cancelación</title>
        <link rel="icon" type="image/png" href="img/gamerlyicon.png">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/styles.css">
    </head>

    <body>
        <% String mensaje=(String) request.getAttribute("mensaje"); model.Persona persona=(model.Persona)
            request.getAttribute("persona"); %>

            <%-- Modal para mensaje (no encontrado o eliminado) --%>
                <% if (mensaje!=null && persona==null) { %>
                    <div class="modal-overlay" style="display:flex;">
                        <div class="modal-box">
                            <p>
                                <%= mensaje %>
                            </p>
                            <button onclick="window.location.href='index.html'" class="novedades-btn"
                                style="margin-top:18px;">Aceptar</button>
                        </div>
                    </div>
                    <% } else if (persona !=null) { %>
                        <div class="modal-overlay" style="display:flex;">
                            <div class="modal-box">
                                <p>
                                    Confirma que eres <b>
                                        <%= persona.getNombre() %>
                                            <%= persona.getApellido() %>
                                    </b>
                                    con el correo <b>
                                        <%= persona.getCorreo() %>
                                    </b>
                                    y el número <b>
                                        <%= persona.getTelefono() %>
                                    </b>
                                </p>
                                <form action="EliminarServlet" method="post">
                                    <input type="hidden" name="correo" value="<%= persona.getCorreo() %>">
                                    <button type="submit" class="novedades-btn">Sí, cancelar suscripción</button>
                                    <button type="button" class="regresar-btn"
                                        onclick="window.location.href='index.html'">No</button>
                                </form>
                            </div>
                        </div>
                        <% } %>
                            <div class="header">
                                <div class="logo-header"
                                    style="flex-direction: column; align-items: center; display: flex; width: 100%;">
                                    <img src="img/gamerly.png" alt="Logo" class="logo-img">
                                    <p class="header-subtitle bright-subtitle">
                                        Tu lugar para mantenerte actualizado en las últimas noticias del mundo del
                                        gaming
                                    </p>
                                </div>
                            </div>
                            <div class="form-center-container">
                                <form class="subscribe-form" action="BuscarServlet" method="post"
                                    style="flex-direction: column; gap: 18px;" onsubmit="return validarCancelar()">
                                    <div class="form-columns">
                                        <div class="form-fields">
                                            <p class="novedades-subtitle">Ingresa el correo electrónico al que quieres
                                                cancelar la suscripción </p>
                                            <input type="email" name="correo" placeholder="Correo electrónico" required>
                                        </div>
                                    </div>
                                    <button type="submit" class="regresar-btn">Cancelar Suscripción</button>
                                    <button class="regresar-btn" type="button"
                                        onclick="window.location.href='index.html'">Regresar</button>

                                </form>
                            </div>
    </body>

    </html>