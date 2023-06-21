package ch.noseryoung.REST_Foods6.domain.users;

import ch.noseryoung.REST_Foods6.domain.role.Role;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "RESTFOOD_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="users_Id")
    private Integer usrId;
    @Column(name="name")
    private String usrName;
    @Column(name="password")
    private String ps;
    @ManyToOne
    @JoinTable(
            name = "RESTFOOD_users_roles",
            joinColumns = @JoinColumn (name = "user_Id", referencedColumnName = "users_Id"),
            inverseJoinColumns = @JoinColumn
                    (name = "id_role", referencedColumnName = "id_role")
    )
    private Role usrRoles;

}