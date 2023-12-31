package ch.noseryoung.REST_Foods6.domain.restFood.drinks;

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
@RequestMapping("/drinks")
@CrossOrigin(origins = "http://localhost:3000/")
public class DrinkWeb {
    @Autowired
    private DrinkService service;

    /**
     * Removed the @PreAuthorize for GET, because everyone has permission to see all data
     */

    @GetMapping //GET -- READ
    @Operation(summary = "Fetches all Drinks", description = "When successful it fetches all drinks and returns a JSON-Code with the status code 200.")
    public ResponseEntity<List<Drinks>> allDrinks(@RequestParam(value = "name", required = false) String filterName) {
        return ResponseEntity.ok().body(service.getAllDrinks(filterName));
    }

    @GetMapping(value = "/{drinkID}") //GET BY ID
    @Operation(summary = "Fetches the desired Drink", description = "When successful it fetches the wished drink and returns the JSON-Code with the status code 200.")
    public ResponseEntity<Drinks> oneDrink (@PathVariable("drinkID") Integer id) throws RestFoodException {
        return ResponseEntity.ok().body(service.getOneDrink(id));
    }

    @PostMapping //POST -- CREATE
    @PreAuthorize("hasAuthority('POST')")
    @Operation(summary = "Creates a Drink", description = "When successful it creates a drink with the wished values and returns the JSON-Code of created review with the status code 200.")
    public ResponseEntity<Drinks> createDrink(@Valid @RequestBody() Drinks drink) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.postADrink(drink));
    }

    @PutMapping(value = "/{drinkID}") //PUT -- UPDATE
    @PreAuthorize("hasAuthority('PUT')")
    @Operation(summary = "Updates the wished Drink", description = "When successful it updates the drink with the wished values and returns the JSON-Code of the updated drink with the status code 200.")
    public ResponseEntity<Drinks> updateDrink(@Valid @PathVariable("drinkID")Integer id, @RequestBody Drinks drink) throws RestFoodException {
        return ResponseEntity.status(200).body(service.putADrink(drink, id));
    }

    @DeleteMapping(value = "/{drinkID}") //DELETE -- DELETE
    @PreAuthorize("hasAuthority('DELETE')")
    @Operation(summary = "Deletes the Drink", description = "When successful it deletes the drink with the status code 200.")
    public void deleteDrink(@Valid @PathVariable("drinkID") Integer id) {
        service.deleteADrink(id);
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
