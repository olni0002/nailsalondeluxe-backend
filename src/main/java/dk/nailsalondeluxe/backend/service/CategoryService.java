package dk.nailsalondeluxe.backend.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dk.nailsalondeluxe.backend.model.Category;
import dk.nailsalondeluxe.backend.repository.CategoryRepository;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional(readOnly = true)
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        
        categories.forEach(category -> category.getTreatments().forEach(treatment -> Hibernate.initialize(treatment.getReservations())));

        return categories;
    }

    @Transactional(readOnly = true)
    public Optional<Category> getCategory(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        
        category.get().getTreatments().forEach(treatment -> Hibernate.initialize(treatment.getReservations()));
        
        return category;
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
}
