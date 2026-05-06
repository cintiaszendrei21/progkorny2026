package hu.cintia.projekt;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
@CrossOrigin(origins = "*")

public class FlightController {

    private final FlightRepository repository;

    public FlightController(FlightRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return repository.findAll();
    }
    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        repository.deleteById(id);
    }

    @GetMapping("/filter/{airlineName}")
    public List<Flight> getByAirline(@PathVariable String airlineName) {
        return repository.findByAirlineName(airlineName);
    }

}
