package hu.cintia.projekt;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(FlightController.class)
public class FlightControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightRepository flightRepository;

    @MockBean
    private AirlineRepository airlineRepository;

    @Test
    public void testGetAllFlights() throws Exception {
        Airline wizz = new Airline("WizzAir");
        Flight f1 = new Flight(wizz, "W6556", "Airbus A320", "Delayed", "5");

        when(flightRepository.findAll()).thenReturn(Collections.singletonList(f1));

        mockMvc.perform(get("/api/flights"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].flightNumber").value("W6556"))
                .andExpect(jsonPath("$[0].airline.name").value("WizzAir"));
    }

    @Test
    public void testDeleteFlight() throws Exception {
        mockMvc.perform(delete("/api/flights/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testAddFlight() throws Exception {
        String json = "{\"airlineName\":\"WizzAir\",\"flightNumber\":\"W6556\",\"type\":\"A320\",\"status\":\"OK\",\"gate\":\"1\"}";

        mockMvc.perform(post("/api/flights")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk());
    }
}