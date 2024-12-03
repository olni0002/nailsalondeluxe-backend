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
import dk.nailsalondeluxe.backend.service.TreaterService;

@RestController
@RequestMapping("/api/treater")
@CrossOrigin("*")
public class TreaterRestController {
    
    private TreaterService treaterService;

    public TreaterRestController(TreaterService treaterService) {
        this.treaterService = treaterService;
    }

    @GetMapping
    public List<Treater> getAllTreaters() {
        return treaterService.getAllTreaters();
    }

    @GetMapping("/{id}")
    public Optional<Treater> getTreater(@PathVariable int id) {
        return treaterService.getTreater(id);
    }

    @PostMapping
    public void createTreater(@RequestBody Treater treater) {
        treaterService.createTreater(treater);
    }

    @PutMapping("/{id}")
    public void updateTreater(@RequestBody Treater treater, @PathVariable int id) {
        treaterService.updateTreater(treater, id);
    }

    @DeleteMapping("/{id}")
    public void deleteTreater(@PathVariable int id) {
        treaterService.deleteTreater(id);
    }
}
