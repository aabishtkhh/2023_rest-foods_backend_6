package ch.noseryoung.REST_Foods6.domain.restFood.pizza;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Data
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pizzaID;
    private String pizzaName;

    private Integer price;

    //needs backend -> proper attributes
}
