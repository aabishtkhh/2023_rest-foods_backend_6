package ch.noseryoung.REST_Foods6.domain.restFood.pizza;
import ch.noseryoung.REST_Foods6.domain.restFood.RestFoodException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;


/**
 * can't use optional
 *   -> id may never be found.
 *
 *  that's why we need exception
 * */

@Service
@Log4j2
public class PizzaService {
    @Autowired
    private PizzaRepository repository;

    public List<Pizza> getAllPizzas(String filterName) {
        log.info("All pizzas shown");
        List<Pizza> pizzas;
        List<Pizza> filteredPizzas = new ArrayList<>();
        pizzas = repository.findAll();
        if (filterName != null){
            for (Pizza pizza: pizzas) {
                if (pizza.getPizzaName().equals(filterName)){
                    filteredPizzas.add(pizza);
                }
            }
            return filteredPizzas;
        }else {
            return pizzas;
        }

    }

    public Pizza getOnePizza(Integer id) throws RestFoodException {
        log.info(id + " pizza found");
        return repository.findById(id).orElseThrow(() -> new RestFoodException("ID "+ id +" not found"));
    }

    public Pizza postAPizza(Pizza pizza) {
        log.info(pizza + " pizza created");
        return repository.save(pizza);
    }

    public Pizza putAPizza(Pizza pizza, Integer id) throws RestFoodException {
        if(repository.existsById(id)) {
            pizza.setPizzaID(id);
            return repository.save(pizza);
        }
        return repository.findById(id).orElseThrow(() -> new RestFoodException("ID "+ id +" not found"));
    }

    public void deleteAPizza(Integer id) {
        log.info(id + " pizza deleted");
        repository.deleteById(id);
    }

}
