package ch.noseryoung.REST_Foods6.domain.restFood.food;

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
@RequestMapping("/food")
public class FoodWeb {
    @Autowired
    private FoodService service;

    @GetMapping //GET -- READ
    @PreAuthorize("hasAuthority('GET')")
    @Operation(summary = "Fetches all Foods", description = "When successful it fetches all foods and returns a JSON-Code with the status code 200.")
    public ResponseEntity<List<Food>> allFoods(@RequestParam(value = "name", required = false) String filterName) {
        return ResponseEntity.ok().body(service.getAllFoods(filterName));
    }

    @GetMapping(value = "/{foodID}") //GET BY ID
    @PreAuthorize("hasAuthority('GET')")
    @Operation(summary = "Fetches the desired Food", description = "When successful it fetches the wished food and returns the JSON-Code with the status code 200.")
    public ResponseEntity<Food> oneFood(@PathVariable("foodID") Integer id) throws RestFoodException {
        return ResponseEntity.ok().body(service.getOneFood(id));
    }

    @PostMapping //POST -- CREATE
    @PreAuthorize("hasAuthority('POST')")
    @Operation(summary = "Creates Food", description = "When successful it creates a food with the wished values and returns the JSON-Code of created food with the status code 200.")
    public ResponseEntity<Food> createFood(@Valid @RequestBody() Food food) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.postAFood(food));
    }

    @PutMapping(value = "/{foodID}") //PUT -- UPDATE
    @PreAuthorize("hasAuthority('PUT')")
    @Operation(summary = "Updates the wished Food", description = "When successful it updates the food with the wished values and returns the JSON-Code of the updated food with the status code 200.")
    public ResponseEntity<Food> updateFood(@Valid @PathVariable("foodID")Integer id, @RequestBody Food food) throws RestFoodException {
        return ResponseEntity.status(200).body(service.putAFood(food, id));
    }

    @DeleteMapping(value = "/{foodID}") //DELETE -- DELETE
    @PreAuthorize("hasAuthority('DELETE')")
    @Operation(summary = "Deletes the Food", description = "When successful it deletes the food with the status code 200.")
    public void deleteFood(@Valid @PathVariable("foodID") Integer id) {
        service.deleteAFood(id);
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
