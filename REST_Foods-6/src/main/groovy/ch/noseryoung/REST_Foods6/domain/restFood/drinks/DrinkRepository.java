package ch.noseryoung.REST_Foods6.domain.restFood.drinks;

import ch.noseryoung.REST_Foods6.domain.authority.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrinkRepository extends JpaRepository<Authority, Integer> {
}
