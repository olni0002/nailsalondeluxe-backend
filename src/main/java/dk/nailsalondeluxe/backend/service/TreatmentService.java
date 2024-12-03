package dk.nailsalondeluxe.backend.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dk.nailsalondeluxe.backend.model.Treatment;
import dk.nailsalondeluxe.backend.repository.TreatmentRepository;

@Service
public class TreatmentService {
    
    private TreatmentRepository treatmentRepository;

    public TreatmentService(TreatmentRepository treatmentRepository) {
        this.treatmentRepository = treatmentRepository;
    }

    @Transactional(readOnly = true)
    public List<Treatment> getAllTreatments() {
        List<Treatment> treatments = treatmentRepository.findAll();

        treatments.forEach(treatment -> Hibernate.initialize(treatment.getReservations()));

        return treatments;
    }

    @Transactional(readOnly = true)
    public Optional<Treatment> getTreatment(int id) {
        Optional<Treatment> treatment = treatmentRepository.findById(id);

        Hibernate.initialize(treatment.get().getReservations());

        return treatment;
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
