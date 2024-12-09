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
import dk.nailsalondeluxe.backend.model.CategoryImage;
import dk.nailsalondeluxe.backend.model.Treatment;
import dk.nailsalondeluxe.backend.service.CategoryService;

@RestController
@RequestMapping("/api/category")
@CrossOrigin("*")
public class CategoryRestController {
    
    private CategoryService categoryService;

    public CategoryRestController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable int id) {
        return categoryService.getCategory(id);
    }

    @PostMapping
    public void createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public void updateCategory(@RequestBody Category category, @PathVariable int id) {
        categoryService.updateCategory(category, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }

    @GetMapping("/{id}/image")
    public Optional<CategoryImage> getImage(@PathVariable int id) {
        return categoryService.getImage(id);
    }

    @GetMapping("/{id}/treatments")
    public List<Treatment> getTreatments(@PathVariable int id) {
        return categoryService.getTreatments(id);
    }
}
