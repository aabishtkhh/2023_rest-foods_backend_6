package ch.noseryoung.REST_Foods6.domain.authority;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "RESTFOOD_authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_auth")
    private Integer authId;
    @Column(name="name")
    private String authName;
}