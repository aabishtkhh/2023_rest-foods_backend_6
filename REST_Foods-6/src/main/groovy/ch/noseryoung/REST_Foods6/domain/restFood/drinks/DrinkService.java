package ch.noseryoung.REST_Foods6.domain.restFood.drinks;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class DrinkService {
    @Autowired
    private DrinkRepository repository;

    public List<Drinks> getAllDrinks() {
        log.info("All drink shown");
        return repository.findAll();
    }

    public Drinks getOneDrink(Integer id) {
        log.info(id + " drink found");
        return repository.findById(id); //error bc its not connected to the db
    }

    public Drinks postADrink(Drinks drinks) {
        log.info(drinks + " created");
        return repository.save(drinks);
    }

    public Drinks putADrink(Drinks drink, Integer id)  {
        if(repository.existsById(id)) {
            drink.setId(id);
            return repository.save(drink);
        }
        return repository.findById(id); //error bc its not connected to the db

    }

    public void deleteADrink(Integer id) {
        log.info(id + " Drink deleted");
        repository.deleteById(id);
    }

}
