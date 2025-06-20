<%@ page contentType="text/html; charset=UTF-8" language="java" %>
    <!DOCTYPE html>
    <html lang="es">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Suscripción</title>
        <link rel="icon" type="image/png" href="img/gamerlyicon.png">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" href="css/styles.css">
    </head>

    <body>
        <% if (request.getAttribute("mensaje") !=null) { %>
            <div class="modal-overlay" style="display:flex;">
                <div class="modal-box">
                    <p>
                        <%= request.getAttribute("mensaje") %>
                    </p>
                    <button onclick="window.location.href='index.html'" class="novedades-btn"
                        style="margin-top:18px;">Aceptar</button>
                </div>
            </div>
            <% } %>
                <% if (request.getAttribute("error") !=null) { %>
                    <div class="modal-overlay" style="display:flex;">
                        <div class="modal-box">
                            <p>
                                <%= request.getAttribute("error") %>
                            </p>
                            <button onclick="window.location.href='suscripcion.jsp'" class="novedades-btn"
                                style="margin-top:18px;">Aceptar</button>
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
                            <form class="subscribe-form" action="SuscripcionServlet" method="post"
                                style="flex-direction: column; gap: 18px;" onsubmit="return validarFormulario()">
                                <div class="form-columns">
                                    <div class="form-fields">
                                        <input type="text" name="nombre" placeholder="Nombres" required>
                                        <input type="text" name="apellido" placeholder="Apellidos" required>
                                        <input type="email" name="correo" placeholder="Correo electrónico" required>
                                        <input type="text" name="telefono" placeholder="Teléfono" required>
                                    </div>
                                    <div class="consolas-checkbox-group" id="grupo-consolas">
                                        <label>¿Sobre qué consolas quieres recibir más noticias?</label>
                                        <div class="checkbox-options">
                                            <label>
                                                <input type="checkbox" name="consolas" value="playstation">
                                                PlayStation
                                            </label>
                                            <label>
                                                <input type="checkbox" name="consolas" value="xbox"> Xbox
                                            </label>
                                            <label>
                                                <input type="checkbox" name="consolas" value="nintendo"> Nintendo
                                            </label>
                                            <label>
                                                <input type="checkbox" name="consolas" value="pc"> PC
                                            </label>
                                        </div>
                                    </div>
                                    <div class="esports-group">
                                        <label style="min-width:240px;display:inline-block;">¿Quieres recibir
                                            noticias
                                            de
                                            e-sports y
                                            campeonatos?</label>
                                        <div class="esports-options">
                                            <label>
                                                <input type="radio" name="esports" value="si"
                                                    onchange="mostrarRegionEsports()">
                                                Sí
                                            </label>
                                            <label>
                                                <input type="radio" name="esports" value="no"
                                                    onchange="mostrarRegionEsports()">
                                                No
                                            </label>
                                        </div>
                                        <div id="region-esports" style="display:none; margin-top:8px;">
                                            <label for="region">¿De qué región?</label>
                                            <select name="region" id="region">
                                                <option value="" disabled selected>Selecciona una región</option>
                                                <option value="latam">Latinoamérica</option>
                                                <option value="europa">Europa</option>
                                                <option value="norteamerica">Norteamérica</option>
                                                <option value="asia">Asia</option>
                                                <option value="oceania">Oceanía</option>
                                                <option value="mundial">Todas</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <button type="submit" class="subscribe-btn">Suscribirse</button>
                                <button class="regresar-btn" type="button"
                                    onclick="window.location.href='index.html'">Regresar</button>
                            </form>
                        </div>
                        <div id="gracias-modal" class="modal-overlay" style="display:none;">
                            <div class="modal-box">
                                <p>Gracias por suscribirte. Muy pronto recibirás las noticias en tu correo.</p>
                                <button id="gracias-aceptar-btn" class="novedades-btn"
                                    style="margin-top:18px;">Aceptar</button>
                            </div>
                        </div>

                        <script src="js/javascript.js"></script>
    </body>

    </html>