package com.test.vehicleReservation.repository;

import com.test.vehicleReservation.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {
}