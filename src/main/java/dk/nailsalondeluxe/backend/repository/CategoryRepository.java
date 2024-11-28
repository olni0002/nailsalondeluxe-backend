package dk.nailsalondeluxe.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dk.nailsalondeluxe.backend.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
