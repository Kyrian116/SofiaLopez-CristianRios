package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class DomicilioDTO {
    private Long id;
    @JsonProperty("calle")
    private String calle;
    @JsonProperty("numero")
    private String numero;
    @JsonProperty("localidad")
    private String localidad;
    @JsonProperty("provincia")
    private String provincia;

    public DomicilioDTO() {
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

}
