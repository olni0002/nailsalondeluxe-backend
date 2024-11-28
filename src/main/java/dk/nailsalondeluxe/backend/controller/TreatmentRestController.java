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

import dk.nailsalondeluxe.backend.model.Treatment;
import dk.nailsalondeluxe.backend.repository.TreatmentRepository;

@RestController
@RequestMapping("/api/treatment")
@CrossOrigin("*")
public class TreatmentRestController {
    
    private TreatmentRepository treatmentRepository;

    public TreatmentRestController(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    @GetMapping
    public List<Treatment> getAllCategories() {
        return treatmentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Treatment> getTreatment(@PathVariable int id) {
        return treatmentRepository.findById(id);
    }

    @PostMapping
    public void createTreatment(@RequestBody Treatment treatment) {
        treatmentRepository.save(treatment);
    }

    @PutMapping("/{id}")
    public void updateTreatment(@RequestBody Treatment treatment, @PathVariable int id) {
        treatment.setId(id);
        treatmentRepository.save(treatment);
    }

    @DeleteMapping("/{id}")
    public void deleteTreatment(@PathVariable int id) {
        treatmentRepository.deleteById(id);
    }
}
