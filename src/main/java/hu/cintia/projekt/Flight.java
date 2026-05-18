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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "airline_id")
    private Airline airline;
    private String type;
    private String number;
    private String fromcity;
    private String tocity;
    private String status;
    private String gate;


    public Flight(Airline airline, String number, String type, String fromcity, String tocity, String status, String gate) {
        this.airline = airline;
        this.number = number;
        this.type = type;
        this.fromcity = fromcity;
        this.tocity = tocity;
        this.status = status;
        this.gate = gate;
    }
}