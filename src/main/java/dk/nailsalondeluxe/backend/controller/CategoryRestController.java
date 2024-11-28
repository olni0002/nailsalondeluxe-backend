package dk.nailsalondeluxe.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dk.nailsalondeluxe.backend.model.Category;
import dk.nailsalondeluxe.backend.repository.CategoryRepository;

@RestController
@RequestMapping("/api/category")
@CrossOrigin("*")
public class CategoryRestController {
    
    private CategoryRepository categoryRepository;

    public CategoryRestController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable int id) {
        return categoryRepository.findById(id);
    }

    @PostMapping
    public void createCategory(@RequestBody Category category) {
        categoryRepository.save(category);
    }

    @PutMapping("/{id}")
    public void updateCategory(@RequestBody Category category, @PathVariable int id) {
        category.setId(id);
        categoryRepository.save(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id) {
        categoryRepository.deleteById(id);
    }

}
