package ch.noseryoung.REST_Foods6.domain.restFood.reservation;

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
@RequestMapping("/reservation")
public class ReservationWeb {
    @Autowired
    private ReservationService service;

    @GetMapping //GET -- READ
    @PreAuthorize("hasAuthority('GET')")
    @Operation(summary = "Fetches all Reservation", description = "When successful it fetches all reservation and returns a JSON-Code with the status code 200.")
    public ResponseEntity<List<Reservation>> allReservation() {
        return ResponseEntity.ok().body(service.getAllReservation());
    }

    @GetMapping(value = "/{reservationID}") //GET BY ID
    @PreAuthorize("hasAuthority('GET')")
    @Operation(summary = "Fetches the desired Reservation", description = "When successful it fetches the wished reservation and returns the JSON-Code with the status code 200.")
    public ResponseEntity<Reservation> oneReservation(@PathVariable("reservationID") Integer id) throws RestFoodException {
        return ResponseEntity.ok().body(service.getOneReservation(id));
    }

    @PostMapping //POST -- CREATE
    @PreAuthorize("hasAuthority('POST')")
    @Operation(summary = "Creates a Reservation", description = "When successful it creates a reservation with the wished values and returns the JSON-Code of created reservation with the status code 200.")
    public ResponseEntity<Reservation> createReservation(@Valid @RequestBody() Reservation reservation) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.postAReservation(reservation));
    }

    @PutMapping(value = "/{reservationID}") //PUT -- UPDATE
    @PreAuthorize("hasAuthority('PUT')")
    @Operation(summary = "Updates the wished Reservation", description = "When successful it updates the reservation with the wished values and returns the JSON-Code of the updated reservation with the status code 200.")
    public ResponseEntity<Reservation> updateReservation(@Valid @PathVariable("reservationID") Integer id, @RequestBody Reservation reservation) throws RestFoodException {
        return ResponseEntity.status(200).body(service.putAReservation(reservation, id));
    }

    @DeleteMapping(value = "/{reservationID}") //DELETE -- DELETE
    @PreAuthorize("hasAuthority('DELETE')")
    @Operation(summary = "Deletes the Reservation", description = "When successful it deletes the reservation with the status code 200.")
    public void deleteReservation(@Valid @PathVariable("reservationID") Integer id) {
        service.deleteAReservation(id);
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
