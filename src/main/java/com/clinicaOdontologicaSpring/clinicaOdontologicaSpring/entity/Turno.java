package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

// Nos permite crear los objetos con las caracteristicas que necesitemos.
//Podemos agregar los atributos que necesitemos.
//Turno turno = Turno.builder().fechaHora("20-05-2003 16:30").build()
//Al agregar el build final le avisamos que terminamos de agregar atributos
//le permite generar automáticamente el código requerido para que su clase
// sea instanciable. Se puede colocar en una clase, o en un constructor,
// o en un método.

@NoArgsConstructor
@Entity
@Table(name = "turnos")
@Getter
@ToString
public class Turno {

    @Id //PK
    @SequenceGenerator(name = "turno_sequence", sequenceName = "turno_sequence", allocationSize =  1) // Para colocar distintos nombres a la secuencia
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "turno_sequence") //
    private Long id;
    @NotNull
    @Column(name = "FECHA", nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;

    @NotNull
    @Column(name = "HORA", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime hora;
    @ManyToOne(fetch = FetchType.LAZY)
    //Se crea una FK (Se agrega una columna más en el objeto)
    @JoinColumn(name = "paciente_id", nullable = false)
    @JsonIgnore
    private Paciente paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    //No utilizas el cascate All para que no se relacionen al eliminar el turno
    //Se crea una FK (Se agrega una columna más en el objeto)
    @JoinColumn(name = "odontologo_id", nullable = false)
    @JsonIgnore
    private Odontologo odontologo;

    public Turno(LocalDate fecha, LocalTime hora, Paciente paciente, Odontologo odontologo) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.odontologo = odontologo;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public void setOdontologo(Odontologo odontologo) {
        this.odontologo = odontologo;
    }
}
