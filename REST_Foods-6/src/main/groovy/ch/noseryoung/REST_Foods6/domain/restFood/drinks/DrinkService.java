package ch.noseryoung.REST_Foods6.domain.restFood.drinks;
import ch.noseryoung.REST_Foods6.domain.restFood.RestFoodException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class DrinkService {
    @Autowired
    private DrinkRepository repository;

    public List<Drinks> getAllDrinks(String filterName) {
        log.info("All drinks shown");
        List<Drinks> drink;
        List<Drinks> filteredDrinks = new ArrayList<>();
        drink = repository.findAll();
        if (filterName != null){ //it checks if the drink's name is equal to the filteredName
            for (Drinks drinks: drink) {
                if (drinks.getName().equals(filterName)){
                    filteredDrinks.add(drinks); //when matches it adds to the filteredDrinks
                }
            }
            return filteredDrinks;
        }else {
            return drink;
        }
    }

    public Drinks getOneDrink(Integer id) throws RestFoodException {
        log.info(id + " drink found");
        return repository.findById(id).orElseThrow(() -> new RestFoodException("ID "+ id +" not found"));
    }

    public Drinks postADrink(Drinks drinks) {
        log.info(drinks + " drink created");
        return repository.save(drinks);
    }

    public Drinks putADrink(Drinks drink, Integer id) throws RestFoodException  {
        if(repository.existsById(id)) {
            drink.setDrinkID(id);
            return repository.save(drink);
        }
        return repository.findById(id).orElseThrow(() -> new RestFoodException("ID "+ id +" not found"));
    }

    public void deleteADrink(Integer id) {
        log.info(id + " drink deleted");
        repository.deleteById(id);
    }
}
