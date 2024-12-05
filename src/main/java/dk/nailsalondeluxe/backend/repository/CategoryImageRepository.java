package dk.nailsalondeluxe.backend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import dk.nailsalondeluxe.backend.model.CategoryImage;

public interface CategoryImageRepository extends JpaRepository<CategoryImage, Integer> {
    Optional<CategoryImage> findByCategoryId(int categoryId);

    @Query(value = "SELECT id FROM category_image WHERE category_id = :id", nativeQuery = true)
    int findIdByCategoryId(int id);

    @Modifying
    @Query(value = "DELETE FROM category_image WHERE category_id = :id", nativeQuery = true)
    void deleteByCategoryId(int id);
}
