package ch.noseryoung.REST_Foods6.domain.role;

import ch.noseryoung.REST_Foods6.domain.authority.Authority;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
@Entity
@Data
@Table(name = "RESTFOOD_roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_role")
    private Integer roleId;
    @Column(name="name")
    private String roleName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "RESTFOOD_roles_authorities",
            joinColumns = {
                    @JoinColumn(name = "id_role", referencedColumnName = "id_role"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "id_auth", referencedColumnName = "id_auth")
            }
    )
    private Set<Authority> roleAuth;
}