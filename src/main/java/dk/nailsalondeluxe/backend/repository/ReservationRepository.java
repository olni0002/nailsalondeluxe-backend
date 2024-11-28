package dk.nailsalondeluxe.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dk.nailsalondeluxe.backend.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    
}
