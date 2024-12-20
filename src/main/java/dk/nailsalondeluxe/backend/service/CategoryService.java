package dk.nailsalondeluxe.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dk.nailsalondeluxe.backend.model.Category;
import dk.nailsalondeluxe.backend.model.CategoryImage;
import dk.nailsalondeluxe.backend.model.Treatment;
import dk.nailsalondeluxe.backend.repository.CategoryImageRepository;
import dk.nailsalondeluxe.backend.repository.CategoryRepository;
import dk.nailsalondeluxe.backend.repository.TreatmentRepository;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryImageRepository categoryImageRepository;
    private TreatmentRepository treatmentRepository;

    public CategoryService(CategoryRepository categoryRepository,
                           CategoryImageRepository categoryImageRepository,
                           TreatmentRepository treatmentRepository) {

        this.categoryRepository = categoryRepository;
        this.categoryImageRepository = categoryImageRepository;
        this.treatmentRepository = treatmentRepository;
    }

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.findById(id);
    }

    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    public void updateCategory(Category category, int id) {
        category.setId(id);
        categoryRepository.save(category);
    }

    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }

    public Optional<CategoryImage> getImage(int id) {
        return categoryImageRepository.findByCategoryId(id);
    }

    public List<Treatment> getTreatments(int id) {
        return treatmentRepository.findByCategoryId(id);
    }
}
