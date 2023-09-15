package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.entity;

import jakarta.persistence.*;
import lombok.*;


@Getter
@NoArgsConstructor
@Entity
@Table(name = "DOMICILIOS")
@ToString
public class Domicilio {
    @Id
    @SequenceGenerator(name = "domicilio_sequence", sequenceName = "domicilio_sequence", allocationSize =  1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "domicilio_sequence")
    private Long id;
    @Column(name = "CALLE")
    private String calle;
    @Column(name = "NUM_ALTURA")
    private String numero;
    @Column(name = "LOCALIDAD")
    private String localidad;
    @Column(name = "PROVINCIA")
    private String provincia;

    @OneToOne(mappedBy = "domicilio")
    private Paciente paciente;

    public Domicilio( String calle, String numero,  String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
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
