package ch.noseryoung.REST_Foods6.domain.restFood.pizza;

import ch.noseryoung.REST_Foods6.domain.authority.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Authority, Integer> {
}
