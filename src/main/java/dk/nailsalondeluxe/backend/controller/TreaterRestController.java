package dk.nailsalondeluxe.backend.controller;

import java.util.List;
import java.util.Optional;

import dk.nailsalondeluxe.backend.service.TreaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    private TreaterService treaterService;
    private TreaterRepository treaterRepository;

    @Autowired
    public TreaterRestController(TreaterService treaterService, TreaterRepository treaterRepository) {
        this.treaterService = treaterService;
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

    @PostMapping("/login")
    public ResponseEntity<Treater> login(@RequestBody Treater loginRequest) {
        Treater treater = treaterService.authenticate(loginRequest.getName(), loginRequest.getPassword());
        if (treater == null) {
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.ok(treater);
    }
}
