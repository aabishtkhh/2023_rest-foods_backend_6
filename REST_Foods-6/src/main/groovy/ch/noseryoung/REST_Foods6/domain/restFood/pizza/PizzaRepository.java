package ch.noseryoung.REST_Foods6.domain.restFood.pizza;

import ch.noseryoung.REST_Foods6.domain.restFood.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PizzaRepository extends JpaRepository<Pizza, Integer> {
}
