package dk.nailsalondeluxe.backend.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dk.nailsalondeluxe.backend.model.Treater;
import dk.nailsalondeluxe.backend.repository.TreaterRepository;

@Service
public class TreaterService {
    
    private TreaterRepository treaterRepository;

    public TreaterService(TreaterRepository treaterRepository) {
        this.treaterRepository = treaterRepository;
    }

    @Transactional(readOnly = true)
    public List<Treater> getAllTreaters() {
        List<Treater> treaters = treaterRepository.findAll();

        treaters.forEach(treater -> Hibernate.initialize(treater.getReservations()));

        return treaters;
    }

    @Transactional(readOnly = true)
    public Optional<Treater> getTreater(int id) {
        Optional<Treater> treater = treaterRepository.findById(id);

        Hibernate.initialize(treater.get().getReservations());

        return treater;
    }

    public void createTreater(Treater treater) {
        treaterRepository.save(treater);
    }

    public void updateTreater(Treater treater, int id) {
        treater.setId(id);
        treaterRepository.save(treater);
    }

    public void deleteTreater(int id) {
        treaterRepository.deleteById(id);
    }
}
