package dk.nailsalondeluxe.backend.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate date;
    private LocalTime time;

    @ManyToOne
    @JoinColumn(name = "treater_id")
    @JsonBackReference(value = "reservation-treater")
    private Treater treater;

    @ManyToOne
    @JoinColumn(name = "treatment_id")
    @JsonBackReference(value = "reservation-treatment")
    private Treatment treatment;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference(value = "reservation-customer")
    private Customer customer;

    @JsonInclude
    public int getTreaterId() {
        return treater.getId();
    }

    @JsonInclude
    public int getTreatmentId() {
        return treatment.getId();
    }

    @JsonInclude
    public int getCustomerId() {
        return customer.getId();
    }
}
