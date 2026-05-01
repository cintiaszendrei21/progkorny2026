package hu.cintia.projekt;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FlightCatalogApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightCatalogApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(FlightRepository repository) {
        return args -> {
            // Most már minden paraméter String az id után!
            repository.save(new Flight(null, "WizzAir", "W62341", "On Time", "A12", "Airbus A320"));
            repository.save(new Flight(null, "Lufthansa", "LH1670", "Delayed", "B05", "Boeing 737"));

            System.out.println("Járatok rögzítve (ár nélkül)!");
        };
    }
}