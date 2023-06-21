package ch.noseryoung.REST_Foods6.domain.restFood.pizza;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public class PizzaWeb {
    @Autowired
    private PizzaService service;

    @GetMapping //GET -- READ
    @PreAuthorize("hasAuthority('GET')")
    @Operation(summary = "Fetches all Drinks", description = "When successful it fetches all Pizzas and returns a JSON-Code with status code 200.")
    public ResponseEntity<List<Pizza>> allPizza(@RequestParam("name") String filterName) {
        return ResponseEntity.ok().body(service.getAllPizzas(filterName));
    }

    @GetMapping(value = "/{pizzaID}") //GET BY ID
    @PreAuthorize("hasAuthority('GET')")
    @Operation(summary = "Fetches the desired Drink", description = "When successful it fetches the wished Drink and returns the JSON-Code with status code 200.")
    public ResponseEntity<Optional<Pizza>> onePizza (@PathVariable("pizzaID") Integer id) {
        return ResponseEntity.ok().body(service.getOnePizza(id));
    }

    @PostMapping //POST -- CREATE
    @PreAuthorize("hasAuthority('POST')")
    @Operation(summary = "Creates a Drink", description = "When successful it creates a Drink with the wished values and returns the JSON-Code of created review with status code 200.")
    public ResponseEntity<Pizza> createPizza(@Valid @RequestBody() Pizza pizza) { //@RequestBody = goes in the body (RequestMapping)
        return ResponseEntity.status(HttpStatus.CREATED).body(service.postAPizza(pizza));
    }

    @PutMapping(value = "/{pizzaID}") //PUT -- UPDATE
    @PreAuthorize("hasAuthority('PUT')")
    @Operation(summary = "Updates the wished Review", description = "When successful it updates the review with the wished values and returns the JSON-Code of the updated review with status code 200.")
    public ResponseEntity<Optional<Pizza>> updatePizza(@Valid @PathVariable("pizzaID")Integer id, @RequestBody Pizza review) {
        return ResponseEntity.status(200).body(service.putAPizza(review, id));
    }

    @DeleteMapping(value = "/{pizzaID}") //DELETE -- DELETE
    @PreAuthorize("hasAuthority('DELETE')")
    @Operation(summary = "Deletes the Review", description = "When successful it deletes the review with status code 200.")
    public void deleteDrink(@Valid @PathVariable("pizzaID") Integer id) {
        service.deleteAPizza(id);
    }


}
