package com.test.vehicleReservation.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

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