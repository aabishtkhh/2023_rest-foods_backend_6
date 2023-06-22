package ch.noseryoung.REST_Foods6.domain.restFood.drinks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//or @Data
public class Drinks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer drinkID;
    private String name;
    private Integer price;
    private String description;
    private boolean chefs_choice;
    private String category;
    private String image_url;
    private Integer size;


    //needs backend -> proper attributes
}
