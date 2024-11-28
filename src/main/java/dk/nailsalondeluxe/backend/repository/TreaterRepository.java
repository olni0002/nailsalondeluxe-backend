package dk.nailsalondeluxe.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dk.nailsalondeluxe.backend.model.Treater;

public interface TreaterRepository extends JpaRepository<Treater, Integer> {
    
}
