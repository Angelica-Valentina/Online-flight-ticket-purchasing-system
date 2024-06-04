package testare;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import java.time.LocalDateTime;
import proiect.Client;
import proiect.Reservation;
import proiect.Flight;
import org.junit.jupiter.api.Test;

class TestClient {

    private Client client;
    private Reservation reservation;
    private Flight flight;

    @BeforeEach
    public void setUp() {
        client = new Client(1, "John Doe", "john@example.com", "0756234345");

        flight = new Flight(1, "New York", "Los Angeles", LocalDateTime.now());

        reservation = new Reservation(client, flight);
        client.bookTicket(reservation);

        client.displayReservations();
    }

    @Test
    public void testModifyReservationByFlightId() {

        Flight newFlight = new Flight(2, "Chicago", "Dallas", LocalDateTime.now());

        client.modifyReservationByFlightId(1, newFlight);

        client.displayReservations();

        Reservation modifiedReservation = client.getReservations().get(0);

        assertEquals(newFlight, modifiedReservation.getFlight());
    }
}
