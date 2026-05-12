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

    @PostMapping
    public Flight addFlight(@RequestBody Flight flight) {
        return repository.save(flight);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        repository.deleteById(id);
    }
}