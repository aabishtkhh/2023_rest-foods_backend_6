package ch.noseryoung.REST_Foods6.domain.restFood.reservation;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reservationID;
    private String table_name;
    private String date_of_reservation;
    private String bookingTime;
    private Integer peopleAmount;
    private Integer telefonNr;
}
