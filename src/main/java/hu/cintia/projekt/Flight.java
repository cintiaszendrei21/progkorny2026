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

    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;
    private String number;
    private String type;
    private String status;
    private String gate;


    public Flight(Airline airline, String number, String type, String status, String gate) {
        this.airline = airline;
        this.number =number;
        this.type = type;
        this.status = status;
        this.gate = gate;
    }
}