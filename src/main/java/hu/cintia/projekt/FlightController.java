package hu.cintia.projekt;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightRepository repository;


    public FlightController(FlightRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Flight getFlightById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Járat nem található: " + id));
    }

    @GetMapping("/filter/{airline}")
    public List<Flight> getByAirline(@PathVariable String airline) {
        return repository.findByAirline(airline);
    }

    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return repository.save(flight);
    }

    @PutMapping("/{id}")
    public Flight updateFlight(@PathVariable Long id, @RequestBody Flight flightDetails) {
        Flight flight = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Járat nem található: " + id));

        flight.setAirline(flightDetails.getAirline());
        flight.setFlightNumber(flightDetails.getFlightNumber());
        flight.setType(flightDetails.getType());
        flight.setStatus(flightDetails.getStatus());
        flight.setGate(flightDetails.getGate());

        return repository.save(flight);
    }

    @DeleteMapping("/{id}")
    public void deleteFlight(@PathVariable Long id) {
        repository.deleteById(id);
    }
}