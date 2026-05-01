package hu.cintia.projekt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clothes")
public class FlightController {

    @Autowired
    private FlightRepository repository;

    @GetMapping
    public List<Flight> getAllClothes() {
        return repository.findAll();
    }

    @PostMapping
    public Flight addClothing(@RequestBody Flight item) {
        return repository.save(item);
    }
    @GetMapping("/filter/{category}")
    public List<Flight> getByCategory(@PathVariable String category) {
        return repository.findByCategory(category);
    }
}
