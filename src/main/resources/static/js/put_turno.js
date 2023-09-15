function mostrarFormulario() {

  // Declaramos las constantes pacienteSelect y odontologoSelect
  const pacienteSelect = document.querySelector('#paciente_id');
  const odontologoSelect = document.querySelector('#odontologo_id');

  if (!mostrarFormulario.pacientesSet) {
    mostrarFormulario.pacientesSet = new Set();
  }
  if (!mostrarFormulario.odontologosSet) {
    mostrarFormulario.odontologosSet = new Set();
  }
  let pacientes = [];
  let odontologos = [];

  fetch('/paciente/listar')
    .then(response => response.json())
    .then(data => {
      pacientes = data;
      pacientes.forEach(paciente => {
        if (!mostrarFormulario.pacientesSet.has(paciente.id)) {
          const option = document.createElement('option');
          option.value = paciente.id;
          option.textContent = `${paciente.nombre} ${paciente.apellido}`;
          pacienteSelect.appendChild(option);
          mostrarFormulario.pacientesSet.add(paciente.id);
        }
      });
      return fetch('/odontologo/listar')
    })
    .then(response => response.json())
    .then(data => {
      odontologos = data;
      odontologos.forEach(odontologo => {
        if (!mostrarFormulario.odontologosSet.has(odontologo.id)) {
          const option = document.createElement('option');
          option.value = odontologo.id;
          option.textContent = `${odontologo.nombre} ${odontologo.apellido}`;
          odontologoSelect.appendChild(option);
          mostrarFormulario.odontologosSet.add(odontologo.id);
        }
      });
      const formulario = document.querySelector('#update_turno_form');
      formulario.style.display = "block";
    })
    .catch(error => {
      console.error('Error al obtener los datos:', error);
    })
};
// En la vista, llamamos al controlador cuando se carga la página
window.onload = function() {
  mostrarFormulario();

  const formulario = document.querySelector('#update_turno_form');

  formulario.addEventListener('submit', function(event) {
    event.preventDefault();

    const idTurno = document.querySelector('#turno_id').value;
    const odontologoId = document.querySelector('#odontologo_id').value;
    const fecha = document.querySelector('#fecha').value;
    const hora = document.querySelector('#hora').value;
    const pacienteId = document.querySelector('#paciente_id').value;

    if (!idTurno || !odontologoId || !fecha || !hora || !pacienteId) {
      alert('Por favor, complete todos los campos');
      return;
    }

    const turno = {
      id: idTurno,
      odontologo: {
        id: odontologoId
      },
      paciente: {
        id: pacienteId
      },
      fecha: fecha,
      hora: hora
    };

    const url = '/turnos/modificar';
    const settings = {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(turno)
    }
    fetch(url, settings)
      .then(response => response.json())
     .then(data => {
        console.log('El turno ha sido modificado correctamente');
        location.reload();
      })
      .catch(error => {
        alert('Error al modificar el turno');
      });
  });
}

 //Es la función que se invoca
 //cuando se hace clic sobre el ID de un turno del listado
 //se encarga de llenar el formulario con los datos del turno
//que se desea modificar
function findBy(id) {
  const url = '/turnos/' + id;
  const settings = {
    method: 'GET',
    headers: {
      'Content-Type': 'application/json',
    },
  };
  return fetch(url, settings)
    .then(response => response.json())
    .then(turno => {
      document.querySelector('#turno_id').value = turno.id;
      document.querySelector('#odontologo_id').value = turno.odontologo.id;
      document.querySelector('#paciente_id').value = turno.paciente.id;
      document.querySelector('#fecha').value = turno.fecha;
      document.querySelector('#hora').value = turno.hora;

      mostrarFormulario(); // Llama a la función mostrarFormulario para cargar los datos del turno en el formulario

      //el formulario por default esta oculto y al editar se habilita
      document.querySelector('#div_turno_updating').style.display = "block";
    })
    .catch(error => {
      alert("Error: " + error);
    });
}