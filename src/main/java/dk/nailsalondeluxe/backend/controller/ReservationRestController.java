package dk.nailsalondeluxe.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dk.nailsalondeluxe.backend.model.Reservation;
import dk.nailsalondeluxe.backend.service.ReservationService;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin("*")
public class ReservationRestController {
    
    private ReservationService reservationService;

    public ReservationRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable int id) {
        return reservationService.getReservation(id);
    }

    @PostMapping
    public void createReservation(@RequestBody Reservation reservation) {
        reservationService.createReservation(reservation);
    }

    @PutMapping("/{id}")
    public void updateReservation(@RequestBody Reservation reservation, @PathVariable int id) {
        reservationService.updateReservation(reservation, id);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id) {
        reservationService.deleteReservation(id);
    }
}
