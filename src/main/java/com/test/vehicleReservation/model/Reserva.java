package com.test.vehicleReservation.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

// Modelo de los datos de la reserva usando JPA y Lombok

@Entity
@Data
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cliente;
    private String vehiculo;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private Boolean cancelada = false;

}