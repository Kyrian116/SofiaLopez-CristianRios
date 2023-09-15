package com.clinicaOdontologicaSpring.clinicaOdontologicaSpring.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pacientes")
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Paciente {
    @Id
    @SequenceGenerator(name = "paciente_sequence", sequenceName = "paciente_sequence", allocationSize =  1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paciente_sequence")
    private Long id;
    @NonNull
    @Column(name = "NOMBRE")
    private String nombre;
    @NonNull
    @Column(name = "APELLIDO")
    private String apellido;
    @NonNull
    @Column(name = "DNI")
    private String dni;

    @NonNull
    @Column(name = "FECHA_INGRESO")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fechaIngreso;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    /*e utiliza para especificar si se permiten valores nulos en la
    columna de la clave externa que establece la asociación.
    Cuando se establece en false, significa que la columna no permitirá
    valores nulos y se requerirá una fila en la tabla asociada para
    que la entidad principal pueda ser creada o actualizada.*/
    @JoinColumn(name = "DOMICILIO_ID", referencedColumnName = "id", nullable = false)
    @NonNull
    @JsonIgnore
    @JsonProperty("domicilio")
    private Domicilio domicilio;
    //Lazy --> Trae cuando necesito el dato
    //All --> Elimina lo relacionado. Si elimino un paciente elimino todos los domicilios
     @OneToMany(mappedBy = "paciente", fetch = FetchType.LAZY)
    //Set por que no admite elementos repetidos
    @JsonIgnore
    private Set<Turno> turnos;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public void setTurnos(Set<Turno> turnos) {
        this.turnos = turnos;
    }
}


