package dk.nailsalondeluxe.backend.service;

import dk.nailsalondeluxe.backend.model.Treater;
import dk.nailsalondeluxe.backend.repository.TreaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreaterService {
    private final TreaterRepository treaterRepository;

    @Autowired
    public TreaterService(TreaterRepository treaterRepository) {
        this.treaterRepository = treaterRepository;
    }

    public Treater authenticate(String name, String password) {
        List<Treater> treaters = treaterRepository.findAll();
        for (Treater treater : treaters) {
            if (treater.getName().equals(name) && treater.getPassword().equals(password)) {
                return treater;
            }
        }
        return null;
    }
}
