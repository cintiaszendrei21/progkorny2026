package hu.cintia.projekt;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List; // Ez az import nagyon fontos!

public interface FlightRepository extends JpaRepository<Flight, Long> {

    // Ezt a sort kell hozzáadnod:
    List<Flight> findByAirline(String airline);
}