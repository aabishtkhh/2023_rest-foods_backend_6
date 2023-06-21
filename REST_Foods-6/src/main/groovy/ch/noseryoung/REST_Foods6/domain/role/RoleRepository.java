package ch.noseryoung.REST_Foods6.domain.role;

import ch.noseryoung.REST_Foods6.domain.authority.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Authority, Integer> {

}
