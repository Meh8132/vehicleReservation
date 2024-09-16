package com.test.vehicleReservation.controller;
import com.test.vehicleReservation.model.Reserva;
import com.test.vehicleReservation.service.ReservaService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

// Controlador de las rutas de la API

@RestController
@RequestMapping("/reservas")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5173/"}) // CORS para React / Vite
public class ReservaController {
    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<Reserva> crearReserva(@RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.crearReserva(reserva));
    }

    // Cuando no hay un parametro, obtiene todas las reservas
    @GetMapping
    public ResponseEntity<List<Reserva>> obtenerReservas() {
        return ResponseEntity.ok(reservaService.obtenerReservas());
    }

    // Obtiene una reserva especifica
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtenerReservaPorId(@PathVariable Long id) {
        return reservaService.obtenerReservaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Modifica una reserva
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> modificarReserva(@PathVariable Long id, @RequestBody Reserva reserva) {
        return ResponseEntity.ok(reservaService.modificarReserva(id, reserva));
    }

    // Cancela una reserva (se una Delete por semantica, pero es un soft delete)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarReserva(@PathVariable Long id) {
        reservaService.cancelarReserva(id);
        return ResponseEntity.noContent().build();
    }
}
