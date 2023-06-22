package ch.noseryoung.REST_Foods6.domain.restFood.pasta;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Pasta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pastaID;
    private String name;
    private Integer price;
    private String description;
    private boolean chefs_choice;
    private String category;
    private String image_url;
    private Integer size;

}
