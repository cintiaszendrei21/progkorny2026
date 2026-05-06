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
    CommandLineRunner initDatabase(FlightRepository repository, AirlineRepository airlineRepository)  {
        return args -> {

            // Hozzárendeljük a járatot


            System.out.println("Siker! Az adatok az adatbázisban vannak.");
        };
    }
}