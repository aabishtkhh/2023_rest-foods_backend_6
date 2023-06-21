package ch.noseryoung.REST_Foods6.domain.role;

import ch.noseryoung.REST_Foods6.domain.authority.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository repository;
}
