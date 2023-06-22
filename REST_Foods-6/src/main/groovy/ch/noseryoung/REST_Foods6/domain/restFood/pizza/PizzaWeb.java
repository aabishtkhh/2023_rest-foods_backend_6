package ch.noseryoung.REST_Foods6.domain.restFood.pizza;

import ch.noseryoung.REST_Foods6.domain.restFood.RestFoodException;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@Log4j2
@RequestMapping("/pizza")
public class PizzaWeb {
    @Autowired
    private PizzaService service;

    @GetMapping //GET -- READ
    @PreAuthorize("hasAuthority('GET')")
    @Operation(summary = "Fetches all Pizzas", description = "When successful it fetches all pizzas and returns a JSON-Code with the status code 200.")
    public ResponseEntity<List<Pizza>> allPizza(@RequestParam("name") String filterName) {
        return ResponseEntity.ok().body(service.getAllPizzas(filterName));
    }

    @GetMapping(value = "/{pizzaID}") //GET BY ID
    @PreAuthorize("hasAuthority('GET')")
    @Operation(summary = "Fetches the desired Pizza", description = "When successful it fetches the wished pizza and returns the JSON-Code with the status code 200.")
    public ResponseEntity<Pizza> onePizza (@PathVariable("pizzaID") Integer id) throws RestFoodException {
        return ResponseEntity.ok().body(service.getOnePizza(id));
    }

    @PostMapping //POST -- CREATE
    @PreAuthorize("hasAuthority('POST')")
    @Operation(summary = "Creates Pizza", description = "When successful it creates a pizza with the wished values and returns the JSON-Code of created Pizza with the status code 200.")
    public ResponseEntity<Pizza> createPizza(@Valid @RequestBody() Pizza pizza) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.postAPizza(pizza));
    }

    @PutMapping(value = "/{pizzaID}") //PUT -- UPDATE
    @PreAuthorize("hasAuthority('PUT')")
    @Operation(summary = "Updates the wished Pizza", description = "When successful it updates the pizza with the wished values and returns the JSON-Code of the updated pizza with the status code 200.")
    public ResponseEntity<Pizza> updatePizza(@Valid @PathVariable("pizzaID")Integer id, @RequestBody Pizza review) throws RestFoodException {
        return ResponseEntity.status(200).body(service.putAPizza(review, id));
    }

    @DeleteMapping(value = "/{pizzaID}") //DELETE -- DELETE
    @PreAuthorize("hasAuthority('DELETE')")
    @Operation(summary = "Deletes the Pizza", description = "When successful it deletes the pizza with the status code 200.")
    public void deleteDrink(@Valid @PathVariable("pizzaID") Integer id) {
        service.deleteAPizza(id);
    }


    /**
     * Exceptions:
     */

    //When ID doesn't exist
    @ExceptionHandler(RestFoodException.class)
    public ResponseEntity<String> handlerNoSuchReviewException(RestFoodException re) {
        log.error("ID not found");
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(re.getMessage());
    }

    //When updating / creating everything has to be filled out
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handlerNoNullReviewException(MethodArgumentNotValidException manve) {
        log.warn("Fill everything out");
        return ResponseEntity.status(400).body(Objects.requireNonNull(manve.getFieldError()).getDefaultMessage());
    }
}
