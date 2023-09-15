// En el controlador, obtenemos los datos del modelo y los pasamos a la vista
function mostrarFormulario() {
  let pacientes = [];
  let odontologos = [];

  // Obtenemos la lista de pacientes y odontólogos del modelo a través de una llamada al servidor
  fetch('/paciente/listar')
    .then(response => response.json())
    .then(data => {
      pacientes = data;
      return fetch('/odontologo/listar')
    })
    .then(response => response.json())
    .then(data => {
      odontologos = data;

      // Pasamos los datos a la vista
      const pacienteSelect = document.querySelector('#paciente_id');
      const odontologoSelect = document.querySelector('#odontologo_id');

      pacientes.forEach(paciente => {
        const option = document.createElement('option');
        option.value = paciente.id;
        option.textContent = `${paciente.nombre} ${paciente.apellido}`;
        pacienteSelect.appendChild(option);
      });

      odontologos.forEach(odontologo => {
        const option = document.createElement('option');
        option.value = odontologo.id;
        option.textContent = `${odontologo.nombre} ${odontologo.apellido}`;
        odontologoSelect.appendChild(option);
      });

      // Mostramos el formulario en la vista
      const formulario = document.querySelector('#add_new_turno');
      formulario.style.display = "block";
    })
    .catch(error => {
      console.error('Error al obtener los datos:', error);
    });
}

// En la vista, llamamos al controlador cuando se carga la página
window.addEventListener('load', function () {
  mostrarFormulario();

  // Al enviar el formulario, obtenemos los valores y los enviamos al servidor
  const formulario = document.querySelector('#add_new_turno');
  formulario.addEventListener('submit', function (event) {
    event.preventDefault();

    // Obtenemos los valores del formulario
    const pacienteId = document.querySelector('#paciente_id').value;
    const odontologoId = document.querySelector('#odontologo_id').value;
    const fecha = document.querySelector('#fecha').value;
    const hora = document.querySelector('#hora').value;

    // Enviamos los datos al servidor
    const url = '/turnos';
    const settings = {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
    body: JSON.stringify({
      paciente: {
        id: pacienteId
      },
      odontologo: {
        id: odontologoId
      },
      fecha: fecha,
      hora: hora
    })
    }

    fetch(url, settings)
      .then(response => response.json())
      .then(data => {
        // Si no hay ningún error se muestra un mensaje diciendo que el turno se agregó bien
        let successAlert = '<div class="alert alert-success alert-dismissible">' +
          '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
          '<strong>Turno agregado </strong> </div>';

        document.querySelector('#response').innerHTML = successAlert;
        document.querySelector('#response').style.display = "block";
        resetUploadForm();
      })
    .catch(error => {
      //Si hay algun error se muestra un mensaje diciendo que el turno
      //no se pudo guardar y se intente nuevamente
      let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
          '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
          '<strong> Error intente nuevamente</strong> </div>'

      document.querySelector('#response').innerHTML = errorAlert;
      document.querySelector('#response').style.display = "block";
      //se dejan todos los campos vacíos por si se quiere ingresar otro turno
      resetUploadForm();
    });

  function resetUploadForm() {
    paciente_id.value = "";
    odontologo_id.value = "";
    document.querySelector("form").reset(); //Resetea el form
  }
  });
(function(){
    let pathname = window.location.pathname;
    if(pathname === "/"){
        document.querySelector(".nav .nav-item a:first").classList.add("active");
    } else if (pathname == "/turnoList.html") {
        document.querySelector(".nav .nav-item a:last").classList.add("active");
    }
})();

 });