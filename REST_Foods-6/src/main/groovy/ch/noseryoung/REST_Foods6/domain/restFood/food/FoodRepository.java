package ch.noseryoung.REST_Foods6.domain.restFood.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface FoodRepository extends JpaRepository<Food, Integer> {
}
