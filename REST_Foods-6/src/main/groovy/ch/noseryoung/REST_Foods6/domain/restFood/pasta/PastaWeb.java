package ch.noseryoung.REST_Foods6.domain.restFood.pasta;

import ch.noseryoung.REST_Foods6.domain.restFood.RestFoodException;
import ch.noseryoung.REST_Foods6.domain.restFood.drinks.Drinks;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * problem: doesnt have a corresponding table
 */

@RestController
@Log4j2
@RequestMapping("/pasta")
public class PastaWeb {
    @Autowired
    private PastaService service;

    @GetMapping //GET -- READ
    @PreAuthorize("hasAuthority('GET')")
    @Operation(summary = "Fetches all Pastas", description = "When successful it fetches all pastas and returns a JSON-Code with the status code 200.")
    public ResponseEntity<List<Pasta>> allPasta() {
        return ResponseEntity.ok().body(service.getAllPastas());
    }

    @GetMapping(value = "/{pastaID}") //GET BY ID
    @PreAuthorize("hasAuthority('GET')")
    @Operation(summary = "Fetches the desired Pasta", description = "When successful it fetches the wished pasta and returns the JSON-Code with the status code 200.")
    public ResponseEntity<Pasta> onePasta(@PathVariable("pastaID") Integer id) throws RestFoodException {
        return ResponseEntity.ok().body(service.getOnePasta(id));
    }

    @PostMapping //POST -- CREATE
    @PreAuthorize("hasAuthority('POST')")
    @Operation(summary = "Creates a Pasta", description = "When successful it creates a pasta with the wished values and returns the JSON-Code of created pasta with the status code 200.")
    public ResponseEntity<Pasta> createPasta(@Valid @RequestBody() Pasta pasta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.postAPasta(pasta));
    }

    @PutMapping(value = "/{pastaID}") //PUT -- UPDATE
    @PreAuthorize("hasAuthority('PUT')")
    @Operation(summary = "Updates the wished Pasta", description = "When successful it updates the pasta with the wished values and returns the JSON-Code of the updated pasta with the status code 200.")
    public ResponseEntity<Pasta> updatePasta(@Valid @PathVariable("pastaID") Integer id, @RequestBody Pasta pasta) throws RestFoodException {
        return ResponseEntity.status(200).body(service.putAPasta(pasta, id));
    }

    @DeleteMapping(value = "/{pastaID}") //DELETE -- DELETE
    @PreAuthorize("hasAuthority('DELETE')")
    @Operation(summary = "Deletes the Pasta", description = "When successful it deletes the pasta with the status code 200.")
    public void deletePasta(@Valid @PathVariable("pastaID") Integer id) {
        service.deleteAPasta(id);
    }
}