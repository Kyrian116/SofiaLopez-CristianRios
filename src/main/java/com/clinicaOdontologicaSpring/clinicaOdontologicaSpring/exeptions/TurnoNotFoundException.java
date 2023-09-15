package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class TurnoNotFoundException  extends Exception{

    public TurnoNotFoundException(String mensaje) {
        super(mensaje);
    }
}
