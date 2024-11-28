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

import dk.nailsalondeluxe.backend.model.Treater;
import dk.nailsalondeluxe.backend.repository.TreaterRepository;

@RestController
@RequestMapping("/api/treater")
@CrossOrigin("*")
public class TreaterRestController {
    
    private TreaterRepository treaterRepository;

    public TreaterRestController(TreaterRepository treaterRepository) {
        this.treaterRepository = treaterRepository;
    }

    @GetMapping
    public List<Treater> getAllCategories() {
        return treaterRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Treater> getTreater(@PathVariable int id) {
        return treaterRepository.findById(id);
    }

    @PostMapping
    public void createTreater(@RequestBody Treater treater) {
        treaterRepository.save(treater);
    }

    @PutMapping("/{id}")
    public void updateTreater(@RequestBody Treater treater, @PathVariable int id) {
        treater.setId(id);
        treaterRepository.save(treater);
    }

    @DeleteMapping("/{id}")
    public void deleteTreater(@PathVariable int id) {
        treaterRepository.deleteById(id);
    }
}
