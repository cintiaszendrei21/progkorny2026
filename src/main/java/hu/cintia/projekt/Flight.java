package hu.cintia.projekt;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "airline_id")
    private Airline airline;

    private String flightNumber;
    private String type;
    private String status;
    private String gate;


}