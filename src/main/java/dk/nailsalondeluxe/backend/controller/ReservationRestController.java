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
import dk.nailsalondeluxe.backend.repository.ReservationRepository;

@RestController
@RequestMapping("/api/reservation")
@CrossOrigin("*")
public class ReservationRestController {
    
    private ReservationRepository reservationRepository;

    public ReservationRestController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public List<Reservation> getAllCategories() {
        return reservationRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable int id) {
        return reservationRepository.findById(id);
    }

    @PostMapping
    public void createReservation(@RequestBody Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @PutMapping("/{id}")
    public void updateReservation(@RequestBody Reservation reservation, @PathVariable int id) {
        reservation.setId(id);
        reservationRepository.save(reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteReservation(@PathVariable int id) {
        reservationRepository.deleteById(id);
    }
}
