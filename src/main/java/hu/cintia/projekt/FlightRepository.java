package hu.cintia.projekt;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    // Ez a "mágikus" sor: a Spring Boot ebből tudni fogja, mit kell tennie!
    List<Flight> findByCategory(String category);
}
