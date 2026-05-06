package hu.cintia.projekt;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    // A Spring ebből tudja, hogy a Flight -> Airline -> name mezőben kell keresnie
    List<Flight> findByAirlineName(String name);
}