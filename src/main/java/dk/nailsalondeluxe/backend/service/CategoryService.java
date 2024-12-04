package dk.nailsalondeluxe.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dk.nailsalondeluxe.backend.model.Category;
import dk.nailsalondeluxe.backend.model.CategoryImage;
import dk.nailsalondeluxe.backend.repository.CategoryImageRepository;
import dk.nailsalondeluxe.backend.repository.CategoryRepository;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryImageRepository categoryImageRepository;

    public CategoryService(CategoryRepository categoryRepository, CategoryImageRepository categoryImageRepository) {
        this.categoryRepository = categoryRepository;
        this.categoryImageRepository = categoryImageRepository;
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

    public void createImage(CategoryImage categoryImage, int id) {
        Category category = new Category();
        category.setId(id);

        categoryImage.setCategory(category);

        categoryImageRepository.save(categoryImage);
    }

    public void updateImage(CategoryImage categoryImage, int id) {
        int imageId = categoryImageRepository.findIdByCategoryId(id);
        categoryImage.setId(imageId);

        categoryImageRepository.save(categoryImage);
    }

    public void deleteImage(int id) {
        int imageId = categoryImageRepository.findIdByCategoryId(id);
        categoryImageRepository.deleteById(imageId);
    }
}
