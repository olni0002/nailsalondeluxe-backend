package dk.nailsalondeluxe.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dk.nailsalondeluxe.backend.model.Treater;
import dk.nailsalondeluxe.backend.repository.TreaterRepository;

@Service
public class TreaterService {
    
    private TreaterRepository treaterRepository;

    public TreaterService(TreaterRepository treaterRepository) {
        this.treaterRepository = treaterRepository;
    }

    public List<Treater> getAllTreaters() {
        return treaterRepository.findAll();
    }

    public Optional<Treater> getTreater(int id) {
        return treaterRepository.findById(id);
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
