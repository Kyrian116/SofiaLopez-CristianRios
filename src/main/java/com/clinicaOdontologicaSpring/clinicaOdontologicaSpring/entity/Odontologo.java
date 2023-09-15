package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Getter
@NoArgsConstructor
@Entity
@Table(name = "ODONTOLOGOS")
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Odontologo {
    @Id
    //allLocationSize --> Reserva en la tabla una cierta cantidad de ID para generar
    //No necesita investigar cuales son los ID que hay para generar
    @SequenceGenerator(name = "odontologo_sequence", sequenceName = "odontologo_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "odontologo_sequence")
    private Long id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "MATRICULA")
    private String matricula;

    public Odontologo(String nombre, String apellido, String matricula, Set<Turno> turnos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.turnos = turnos;
    }

    @OneToMany(mappedBy = "odontologo", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turno> turnos = new HashSet<>();

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }
}
