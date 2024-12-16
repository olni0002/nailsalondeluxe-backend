package dk.nailsalondeluxe.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import dk.nailsalondeluxe.backend.model.CategoryImage;

public interface CategoryImageRepository extends JpaRepository<CategoryImage, Integer> {

    Optional<CategoryImage> findByCategoryId(int categoryId);

    @Modifying
    @Query(value = "DELETE FROM category_image WHERE id=:id", nativeQuery = true)
    void deleteById(int id);
}
