package ch.noseryoung.REST_Foods6.domain.restFood.reservation;

import ch.noseryoung.REST_Foods6.domain.authority.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Authority, Integer> {
}
