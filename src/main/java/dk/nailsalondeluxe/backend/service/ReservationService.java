package dk.nailsalondeluxe.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dk.nailsalondeluxe.backend.model.Reservation;
import dk.nailsalondeluxe.backend.repository.ReservationRepository;

@Service
public class ReservationService {
    
    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.findById(id);
    }

    public void createReservation(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    public void updateReservation(Reservation reservation, int id) {
        reservation.setId(id);
        reservationRepository.save(reservation);
    }

    public void deleteReservation(int id) {
        reservationRepository.deleteById(id);
    }
}
