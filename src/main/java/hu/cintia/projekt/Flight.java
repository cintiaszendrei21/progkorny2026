package hu.cintia.projekt;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne // Összekötjük az Airline táblával
    @JoinColumn(name = "airline_id")
    private Airline airline;

    private String flightNumber;
    private String type;
    private String status;
    private String gate;

    // Kézi konstruktor, ha nem akarod mindig az ID-t megadni
    public Flight(Airline airline, String flightNumber, String type, String status, String gate) {
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.type = type;
        this.status = status;
        this.gate = gate;
    }
}