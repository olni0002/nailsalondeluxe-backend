package dk.nailsalondeluxe.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dk.nailsalondeluxe.backend.model.Treatment;
import dk.nailsalondeluxe.backend.repository.TreatmentRepository;

@Service
public class TreatmentService {
    
    private TreatmentRepository treatmentRepository;

    public TreatmentService(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    public List<Treatment> getAllTreatments() {
        return treatmentRepository.findAll();
    }

    public Optional<Treatment> getTreatment(int id) {
        return treatmentRepository.findById(id);
    }

    public void createTreatment(Treatment treatment) {
        treatmentRepository.save(treatment);
    }

    public void updateTreatment(Treatment treatment, int id) {
        treatment.setId(id);
        treatmentRepository.save(treatment);
    }

    public void deleteTreatment(int id) {
        treatmentRepository.deleteById(id);
    }
}
