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

import dk.nailsalondeluxe.backend.model.CategoryImage;
import dk.nailsalondeluxe.backend.service.CategoryImageService;

@RestController
@RequestMapping("/api/categoryImage")
@CrossOrigin("*")
public class CategoryImageRestController {
    
    private CategoryImageService categoryImageService;

    public CategoryImageRestController(CategoryImageService categoryImageService) {
        this.categoryImageService = categoryImageService;
    }

    @GetMapping
    public List<CategoryImage> getAllCategories() {
        return categoryImageService.getAllCategories();
    }

    @GetMapping("/{id}")
    public Optional<CategoryImage> getCategoryImage(@PathVariable int id) {
        return categoryImageService.getCategoryImage(id);
    }

    @PostMapping
    public void createCategoryImage(@RequestBody CategoryImage categoryimage) {
        categoryImageService.createCategoryImage(categoryimage);
    }

    @PutMapping("/{id}")
    public void updateCategoryImage(@RequestBody CategoryImage categoryimage, @PathVariable int id) {
        categoryImageService.updateCategoryImage(categoryimage, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategoryImage(@PathVariable int id) {
        categoryImageService.deleteCategoryImage(id);
    }
}
