function validarFormulario() {
    // Validar campos de texto y email
    // Validar campos de texto y email
    var nombre = document.querySelector('.subscribe-form input[name="nombre"]');
    var apellido = document.querySelector('.subscribe-form input[name="apellido"]');
    var correo = document.querySelector('.subscribe-form input[name="correo"]');
    var telefono = document.querySelector('.subscribe-form input[name="telefono"]');

    // Nombre: solo letras y espacios
    var nombreRegex = /^[A-Za-zÁÉÍÓÚáéíóúÑñ\s]+$/;
    if (!nombre.value.trim().match(nombreRegex)) {
        alert("El nombre solo puede contener letras y espacios.");
        nombre.focus();
        return false;
    }
    // Apellido: solo letras y espacios
    if (!apellido.value.trim().match(nombreRegex)) {
        alert("El apellido solo puede contener letras y espacios.");
        apellido.focus();
        return false;
    }
    // Correo: formato válido
    var correoRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!correo.value.trim().match(correoRegex)) {
        alert("Por favor, ingresa un correo electrónico válido.");
        correo.focus();
        return false;
    }
    // Teléfono: solo números
    var telefonoRegex = /^[0-9]+$/;
    if (!telefono.value.trim().match(telefonoRegex)) {
        alert("El número de teléfono solo puede contener números.");
        telefono.focus();
        return false;
    }

    // Selecciona todos los checkboxes de consolas
    var consolas = document.querySelectorAll('.subscribe-form input[name="consolas"]');
    var algunaConsola = Array.from(consolas).some(cb => cb.checked);
    if (!algunaConsola) {
        alert("Por favor, selecciona al menos una consola.");
        consolas[0].focus();
        return false;
    }

    // Validar que se haya respondido la pregunta de e-sports
    var esports = document.querySelectorAll('.subscribe-form input[name="esports"]');
    var respuestaEsports = Array.from(esports).find(rb => rb.checked);
    if (!respuestaEsports) {
        alert("Por favor, responde si quieres recibir noticias de e-sports.");
        esports[0].focus();
        return false;
    }

    // Si la respuesta de e-sports es "si", la región es obligatoria
    if (respuestaEsports.value === "si") {
        var region = document.getElementById('region');
        if (!region || !region.value) {
            alert("Por favor, selecciona una región de e-sports.");
            if (region) region.focus();
            return false;
        }
    }

    // Si todo está bien, retorna true para permitir el envío
    return true;
}

function validarCancelar() {
    var telefono = document.querySelector('.subscribe-form input[name="telefono"]');
    var telefonoRegex = /^[0-9]+$/;
    if (!telefono.value.trim().match(telefonoRegex)) {
        alert("El número de teléfono solo puede contener números.");
        telefono.focus();
        return false;
    }
    return true;
}

// Mostrar/ocultar región según respuesta de e-sports
function mostrarRegionEsports() {
    var si = document.querySelector('.subscribe-form input[name="esports"][value="si"]');
    var regionDiv = document.getElementById('region-esports');
    if (si && si.checked) {
        regionDiv.style.display = 'block';
    } else {
        regionDiv.style.display = 'none';
        var region = document.getElementById('region');
        if (region) region.value = "";
    }
}

document.addEventListener('DOMContentLoaded', function () {
    // Mostrar modal al hacer click en cualquier noticia
    document.querySelectorAll('.featured-article, .article-card').forEach(function (card) {
        card.addEventListener('click', function (e) {
            e.preventDefault();
            var modal = document.getElementById('suscribe-modal');
            if (modal) modal.style.display = 'flex';
        });
    });

    // Botón "Suscribirse" del modal: desliza hasta la sección de novedades
    var suscribirBtn = document.getElementById('ir-suscripcion-btn');
    if (suscribirBtn) {
        suscribirBtn.onclick = function () {
            var modal = document.getElementById('suscribe-modal');
            if (modal) modal.style.display = 'none';
            var novedades = document.querySelector('.novedades-section');
            if (novedades) {
                novedades.scrollIntoView({ behavior: 'smooth' });
            }
        };
    }

    // Botón "Cerrar" del modal
    var cerrarBtn = document.getElementById('cerrar-modal-btn');
    if (cerrarBtn) {
        cerrarBtn.onclick = function () {
            var modal = document.getElementById('suscribe-modal');
            if (modal) modal.style.display = 'none';
        };
    }

    // --- ENVÍO DEL FORMULARIO ---
    var form = document.querySelector('.subscribe-form');
    if (form) {
        form.onsubmit = function () {
            return validarFormulario();
        };
    }

    // Botón aceptar del modal
    var graciasBtn = document.getElementById('gracias-aceptar-btn');
    if (graciasBtn) {
        graciasBtn.onclick = function () {
            window.location.href = 'index.html';
        };
    }
});

function mostrarGracias() {
    var graciasModal = document.getElementById('gracias-modal');
    if (graciasModal) {
        graciasModal.style.display = 'flex';
    }
}