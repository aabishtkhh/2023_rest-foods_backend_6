package ch.noseryoung.REST_Foods6.domain.restFood.pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;

import java.util.Optional;


import java.util.List;

@Service
@Log4j2
public class PizzaService {
    @Autowired
    private PizzaRepository repository;
    public List<Pizza> getAllPizzas() {
        log.info("All drink shown");
        return repository.findAll();
    }

    public Optional<Pizza> getOnePizza(Integer id) {
        log.info(id + " drink found");
        return repository.findById(id); //error bc its not connected to the db
    }

    public Pizza postAPizza(Pizza pizza) {
        log.info(pizza + " created");
        return repository.save(pizza);
    }

    public Optional<Pizza> putAPizza(Pizza pizza, Integer id)  {
        if(repository.existsById(id)) {
            pizza.setPizzaID(id);
            return Optional.of(repository.save(pizza));
        }
        return repository.findById(id); //error bc its not connected to the db

    }

    public void deleteAPizza(Integer id) {
        log.info(id + " Drink deleted");
        repository.deleteById(id);
    }

}
