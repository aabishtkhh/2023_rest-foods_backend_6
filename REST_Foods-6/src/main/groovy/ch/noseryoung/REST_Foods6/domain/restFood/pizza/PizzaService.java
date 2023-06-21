package ch.noseryoung.REST_Foods6.domain.restFood.pizza;

import ch.noseryoung.REST_Foods6.domain.restFood.drinks.DrinkRepository;
import ch.noseryoung.REST_Foods6.domain.restFood.drinks.Drinks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    @Autowired
    private PizzaRepository repository;
    public List<Pizza> getAllPizzas() {
        log.info("All drink shown");
        return repository.findAll();
    }

    public Pizza getOnePizza(Integer id) {
        log.info(id + " drink found");
        return repository.findById(id); //error bc its not connected to the db
    }

    public Pizza postADrink(Pizza pizza) {
        log.info(pizza + " created");
        return repository.save(pizza);
    }

    public Drinks putAPizza(Pizza pizza, Integer id)  {
        if(repository.existsById(id)) {
            pizza.setId(id);
            return repository.save(pizza);
        }
        return repository.findById(id); //error bc its not connected to the db

    }

    public void deleteADrink(Integer id) {
        log.info(id + " Drink deleted");
        repository.deleteById(id);
    }

}
