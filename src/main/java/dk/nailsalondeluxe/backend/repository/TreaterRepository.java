package dk.nailsalondeluxe.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dk.nailsalondeluxe.backend.model.Treater;

import java.util.List;

public interface TreaterRepository extends JpaRepository<Treater, Integer> {
    List<Treater> findByNameAndPassword(String name, String password);
}
