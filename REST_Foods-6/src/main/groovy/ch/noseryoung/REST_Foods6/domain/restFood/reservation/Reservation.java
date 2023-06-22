package ch.noseryoung.REST_Foods6.domain.restFood.reservation;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Reservation {
    /*needs to be changed*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationID;
    private String name;
    private Integer price;
    private String description;
    private String image_url;
}
