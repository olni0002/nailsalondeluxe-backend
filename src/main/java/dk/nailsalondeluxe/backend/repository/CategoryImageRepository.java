package dk.nailsalondeluxe.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dk.nailsalondeluxe.backend.model.CategoryImage;

public interface CategoryImageRepository extends JpaRepository<CategoryImage, Integer> {

    Optional<CategoryImage> findByCategoryId(int categoryId);
}
