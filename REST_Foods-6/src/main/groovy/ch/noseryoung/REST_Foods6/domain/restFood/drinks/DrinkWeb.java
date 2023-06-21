package ch.noseryoung.REST_Foods6.domain.restFood.drinks;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Log4j2 //class that should use logging
@RequestMapping("/RestFoods/drinks")
public class DrinkWeb {

    @Autowired
    private DrinkService service;

    @GetMapping //GET -- READ
    @PreAuthorize("hasAuthority('GET')")
    @Operation(summary = "Fetches all Drinks", description = "When successful it fetches all Pizzas and returns a JSON-Code with status code 200.")
    public ResponseEntity<List<Drinks>> allDrinks() {
        return ResponseEntity.ok().body(service.getAllDrinks());
    }

    @GetMapping(value = "/{drinkID}") //GET BY ID
    @PreAuthorize("hasAuthority('GET')")
    @Operation(summary = "Fetches the desired Drink", description = "When successful it fetches the wished Drink and returns the JSON-Code with status code 200.")
    public ResponseEntity<Drinks> oneDrink (@PathVariable("drinkID") Integer id) {
        return ResponseEntity.ok().body(service.getOneDrink(id));
    }

    @PostMapping //POST -- CREATE
    @PreAuthorize("hasAuthority('POST')")
    @Operation(summary = "Creates a Drink", description = "When successful it creates a Drink with the wished values and returns the JSON-Code of created review with status code 200.")
    public ResponseEntity<Drinks> createDrink(@Valid @RequestBody() Drinks drink) { //@RequestBody = goes in the body (RequestMapping)
        return ResponseEntity.status(HttpStatus.CREATED).body(service.postADrink(drink));
    }

    @PutMapping(value = "/{drinkID}") //PUT -- UPDATE
    @PreAuthorize("hasAuthority('PUT')")
    @Operation(summary = "Updates the wished Review", description = "When successful it updates the review with the wished values and returns the JSON-Code of the updated review with status code 200.")
    public ResponseEntity<Drinks> updateDrink(@Valid @PathVariable("reviewId")Integer id, @RequestBody Drinks review) {
        return ResponseEntity.status(200).body(service.putADrink(review, id));
    }

    @DeleteMapping(value = "/{drinkID}") //DELETE -- DELETE
    @PreAuthorize("hasAuthority('DELETE')")
    @Operation(summary = "Deletes the Review", description = "When successful it deletes the review with status code 200.")
    public void deleteDrink(@Valid @PathVariable("reviewId") Integer id) {
        service.deleteADrink(id);
    }


}
