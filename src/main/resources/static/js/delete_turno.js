function deleteBy(id) {
    const url = '/turnos/eliminar/'+ id;
    const settings = {
        method: 'DELETE'
    }

    fetch(url, settings)
    .then(response => {
        if (response.ok) {
            let row_id = "#tr_" + id;
            document.querySelector(row_id).remove();
        } else {
            throw new Error('No se pudo eliminar el turno. Asegúrate de que el turno existe.');
        }
    })
    .catch(error => {
        console.error(error);
        alert(error.message);
    });
}