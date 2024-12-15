package dk.nailsalondeluxe.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dk.nailsalondeluxe.backend.model.CategoryImage;
import dk.nailsalondeluxe.backend.repository.CategoryImageRepository;

@Service
public class CategoryImageService {

    private CategoryImageRepository categoryImageRepository;

    public CategoryImageService(CategoryImageRepository categoryImageRepository) {
        this.categoryImageRepository = categoryImageRepository;
    }

    public List<CategoryImage> getAllCategories() {
        return categoryImageRepository.findAll();
    }

    public Optional<CategoryImage> getCategoryImage(int id) {
        return categoryImageRepository.findById(id);
    }

    public void createCategoryImage(CategoryImage categoryImage) {
        categoryImageRepository.save(categoryImage);
    }

    public void updateCategoryImage(CategoryImage categoryImage, int id) {
        categoryImage.setId(id);
        categoryImageRepository.save(categoryImage);
    }

    public void deleteCategoryImage(int id) {
        categoryImageRepository.deleteById(id);
    }
}
