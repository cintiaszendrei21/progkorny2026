package hu.cintia.projekt;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    // Itt ne legyen semmi más, csak ez az üres interfész!
}