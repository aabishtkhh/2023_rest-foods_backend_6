package ch.noseryoung.REST_Foods6.domain.users;

import ch.noseryoung.REST_Foods6.domain.role.Role;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "restfood_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_Id")
    private Integer user_Id;
    @Column(name="name")
    private String usrName;
    @Column(name="password")
    private String ps;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinTable(
            name = "restfood_users_roles",
            joinColumns = @JoinColumn (name = "user_Id", referencedColumnName = "user_Id"),
            inverseJoinColumns = @JoinColumn
                    (name = "id_role", referencedColumnName = "id_role")
    )
    private Role usrRoles;

}