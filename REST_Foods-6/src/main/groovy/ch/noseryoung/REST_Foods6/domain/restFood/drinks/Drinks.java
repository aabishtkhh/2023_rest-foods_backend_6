package ch.noseryoung.REST_Foods6.domain.restFood.drinks;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Drinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer drinkID;
    private String drinkName;

    private Integer price;

    //needs backend -> proper attributes
}
