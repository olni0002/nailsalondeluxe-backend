package dk.nailsalondeluxe.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dk.nailsalondeluxe.backend.model.Treatment;

public interface TreatmentRepository extends JpaRepository<Treatment, Integer> {
    
}
