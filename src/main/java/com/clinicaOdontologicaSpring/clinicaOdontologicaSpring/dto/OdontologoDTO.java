package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.dto;

import lombok.Getter;

import java.util.Set;


//Agrega las propiedades que queremos tener relaciòn con el front
//No va a traer un ID

@Getter
                                   //Usar Builder (Se usa para instanciar)
                                  //Serializable para verlo por consola
public class OdontologoDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String matricula;

    private Set<TurnoDTO> turnos;

    public OdontologoDTO() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

}
