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
import dk.nailsalondeluxe.backend.service.TreatmentService;

@RestController
@RequestMapping("/api/treatment")
@CrossOrigin("*")
public class TreatmentRestController {
    
    private TreatmentService treatmentService;

    public TreatmentRestController(TreatmentService treatmentService) {
        this.treatmentService = treatmentService;
    }

    @GetMapping
    public List<Treatment> getAllTreatments() {
        return treatmentService.getAllTreatments();
    }

    @GetMapping("/{id}")
    public Optional<Treatment> getTreatment(@PathVariable int id) {
        return treatmentService.getTreatment(id);
    }

    @PostMapping
    public void createTreatment(@RequestBody Treatment treatment) {
        treatmentService.createTreatment(treatment);
    }

    @PutMapping("/{id}")
    public void updateTreatment(@RequestBody Treatment treatment, @PathVariable int id) {
        treatmentService.updateTreatment(treatment, id);
    }

    @DeleteMapping("/{id}")
    public void deleteTreatment(@PathVariable int id) {
        treatmentService.deleteTreatment(id);
    }
}
