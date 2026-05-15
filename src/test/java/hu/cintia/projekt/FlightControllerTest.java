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
    public void shouldReturnAllFlights() throws Exception {
        Airline company = new Airline("Lufthansa");
        Flight testflight = new Flight(company, "LH1234", "Boeing 737", "Időben", "B22");

        when(flightRepository.findAll()).thenReturn(Collections.singletonList(testflight));

        mockMvc.perform(get("/api/flights"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].number").value("LH1234"));
    }

    @Test
    public void deleteExistingFlightTest() throws Exception {
        mockMvc.perform(delete("/api/flights/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void createNewFlightTest() throws Exception {

        String ujJaratJson = "{\n" +
                "  \"Name\": \"Ryanair\",\n" +
                "  \"Number\": \"FR4567\",\n" +
                "  \"type\": \"737-800\",\n" +
                "  \"status\": \"Úton\",\n" +
                "  \"gate\": \"C10\"\n" +
                "}";

        mockMvc.perform(post("/api/flights")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ujJaratJson))
                .andExpect(status().isOk());
    }
}