package com.test.vehicleReservation.service;

import com.test.vehicleReservation.model.Reserva;
import com.test.vehicleReservation.repository.ReservaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    // Crea una nueva reserva
    public Reserva crearReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    // Obtiene todas las reservas
    public List<Reserva> obtenerReservas() {
        return reservaRepository.findAll();
    }

    // Obtiene una reserva especifica por ID
    public Optional<Reserva> obtenerReservaPorId(Long id) {
        return reservaRepository.findById(id);
    }

    // Modifica y actualiza una reserva ya existente
    public Reserva modificarReserva(Long id, Reserva reservaActualizada) {
        return reservaRepository.findById(id).map(reserva -> {
            reserva.setCliente(reservaActualizada.getCliente());
            reserva.setVehiculo(reservaActualizada.getVehiculo());
            reserva.setFechaInicio(reservaActualizada.getFechaInicio());
            reserva.setFechaFin(reservaActualizada.getFechaFin());
            return reservaRepository.save(reserva);
        }).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    // Cancela las reservas, se hace un soft delete marcandolos pero no se borran
    public void cancelarReserva(Long id) {
        reservaRepository.findById(id).ifPresent(reserva -> {
            reserva.setCancelada(true);
            reservaRepository.save(reserva);
        });
    }
}
