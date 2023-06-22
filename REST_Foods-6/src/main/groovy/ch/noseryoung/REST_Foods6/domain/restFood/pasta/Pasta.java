package ch.noseryoung.REST_Foods6.domain.restFood.pasta;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//or @Data
@Table(name = "pastas")
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
