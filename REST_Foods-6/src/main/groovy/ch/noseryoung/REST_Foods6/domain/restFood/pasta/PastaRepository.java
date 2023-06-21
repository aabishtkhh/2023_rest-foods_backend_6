package ch.noseryoung.REST_Foods6.domain.restFood.pasta;

import ch.noseryoung.REST_Foods6.domain.authority.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PastaRepository extends JpaRepository<Authority, Integer> {
}
