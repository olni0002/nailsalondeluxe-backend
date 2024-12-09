package dk.nailsalondeluxe.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dk.nailsalondeluxe.backend.model.Treatment;

public interface TreatmentRepository extends JpaRepository<Treatment, Integer> {
    
        List<Treatment> findByCategoryId(int categoryId);
}
