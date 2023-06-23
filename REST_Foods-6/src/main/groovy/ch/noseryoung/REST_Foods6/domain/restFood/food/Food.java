package ch.noseryoung.REST_Foods6.domain.restFood.food;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "foods")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "foodID")
    private Integer foodID;
    @Column(name ="name")
    private String foodName;
    @Column(name = "price")
    private Integer price;
    @Column(name = "description")
    private String description;
    @Column(name = "chefs_choice")
    private Boolean chef_choice;
    @Column(name = "category")
    private String category;
    @Column(name = "isItPizza")
    private Boolean isItPizza;
    @Column(name = "image_url")
    private String image_url;
    @Column(name = "size")
    private int size;

    public Integer getFoodID() {
        return foodID;
    }

    public void setFoodID(Integer foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
