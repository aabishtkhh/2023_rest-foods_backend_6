package ch.noseryoung.REST_Foods6.domain.restFood.pasta;

import ch.noseryoung.REST_Foods6.domain.restFood.RestFoodException;
import ch.noseryoung.REST_Foods6.domain.restFood.drinks.Drinks;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j2
public class PastaService {
    @Autowired
    private PastaRepository repository;

    public List<Pasta> getAllPastas(String filterName) {
        log.info("All pastas shown");
        List<Pasta> pasta;
        List<Pasta> filteredPastas = new ArrayList<>();
        pasta = repository.findAll();
        if (filterName != null){
            for (Pasta pastas: pasta) {
                if (pastas.getName().equals(filterName)){
                    filteredPastas.add(pastas);
                }
            }
            return filteredPastas;
        }else {
            return pasta;
        }
    }

    public Pasta getOnePasta(Integer id) throws RestFoodException {
        log.info(id + " pasta found");
        return repository.findById(id).orElseThrow(() -> new RestFoodException("ID " + id + " not found"));
    }

    public Pasta postAPasta(Pasta pasta) {
        log.info(pasta + " pasta created");
        return repository.save(pasta);
    }

    public Pasta putAPasta(Pasta pasta, Integer id) throws RestFoodException {
        if (repository.existsById(id)) {
            pasta.setPastaID(id);
            return repository.save(pasta);
        }
        return repository.findById(id).orElseThrow(() -> new RestFoodException("ID " + id + " not found"));
    }

    public void deleteAPasta(Integer id) {
        log.info(id + " pasta deleted");
        repository.deleteById(id);
    }
}

