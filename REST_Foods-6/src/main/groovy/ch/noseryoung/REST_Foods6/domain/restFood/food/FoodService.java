package ch.noseryoung.REST_Foods6.domain.restFood.food;
import ch.noseryoung.REST_Foods6.domain.restFood.RestFoodException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;


/**
 * can't use optional, because ID may never be found.
 *  To solve that we use exception.
 */

@Service
@Log4j2
public class FoodService {
    @Autowired
    private FoodRepository repository;

    public List<Food> getAllFoods(String filterName, Boolean chef_Choice) {
        log.info("All foods shown");
        List<Food> foods;
        List<Food> filteredFoods = new ArrayList<>();
        Boolean filterApplied = false;
        foods = repository.findAll();
        if (chef_Choice != null){
            filterApplied = true;
            for (Food food: foods) {
                if (food.getChef_choice().equals(chef_Choice)){
                    filteredFoods.add(food);
                }
            }
        }
        if (filterName != null){
            if (!filterApplied){
                filterApplied = true;
                for (Food food: foods) {
                    if (food.getFoodName().equals(filterName)) {
                        filteredFoods.add(food);
                    }
                }
            }else {
                filteredFoods.removeIf(food -> !food.getFoodName().equals(filterName));
            }
        }
        if (filterApplied){
            return filteredFoods;
        }else {
            return foods;
        }
    }

    public Food getOneFood(Integer id) throws RestFoodException {
        log.info(id + " food found");
        return repository.findById(id).orElseThrow(() -> new RestFoodException("ID "+ id +" not found"));
    }

    public Food postAFood(Food food) {
        log.info(food + " food created");
        return repository.save(food);
    }

    public Food putAFood(Food food, Integer id) throws RestFoodException {
        if(repository.existsById(id)) {
            food.setFoodID(id);
            return repository.save(food);
        }
        return repository.findById(id).orElseThrow(() -> new RestFoodException("ID "+ id +" not found"));
    }

    public void deleteAFood(Integer id) {
        log.info(id + " food deleted");
        repository.deleteById(id);
    }

}
