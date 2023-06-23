package ch.noseryoung.REST_Foods6.domain.restFood.reservation;

import ch.noseryoung.REST_Foods6.domain.restFood.RestFoodException;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class ReservationService {
    @Autowired
    private ReservationRepository repository;

    public List<Reservation> getAllReservation() {
        log.info("All reservations shown");
        return repository.findAll();
    }

    public Reservation getOneReservation(Integer id) throws RestFoodException {
        log.info(id + " reservation found");
        return repository.findById(id).orElseThrow(() -> new RestFoodException("ID " + id + " not found"));
    }

    public Reservation postAReservation(Reservation reservation) {
        log.info(reservation + " reservation created");
        return repository.save(reservation);
    }

    public Reservation putAReservation(Reservation reservation, Integer id) throws RestFoodException {
        if (repository.existsById(id)) {
            reservation.setReservationID(id);
            return repository.save(reservation);
        }
        return repository.findById(id).orElseThrow(() -> new RestFoodException("ID " + id + " not found"));
    }

    public void deleteAReservation(Integer id) {
        log.info(id + " reservation deleted");
        repository.deleteById(id);
    }
}