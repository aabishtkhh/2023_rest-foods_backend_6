package ch.noseryoung.REST_Foods6.domain.restFood.pizza;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pizzaID;
    @Column(name ="name")
    private String pizzaName;
    @Column(name = "price")
    private Integer price;
    @Column(name = "description")
    private String description;
    @Column(name = "chefs_choice")
    private Boolean chef_choice;
    @Column(name = "category")
    private String category;
    @Column(name = "image_url")
    private String image_url;
    @Column(name = "size")
    private int size;

    public Integer getPizzaID() {
        return pizzaID;
    }

    public void setPizzaID(Integer pizzaID) {
        this.pizzaID = pizzaID;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
