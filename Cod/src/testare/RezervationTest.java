package testare;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import proiect.Client;
import proiect.Flight;
import proiect.Reservation;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTest {
    
    private Client client;
    private Flight flight1;
    private Flight flight2;
    private Reservation reservation1;
    private Reservation reservation2;

    @BeforeEach
    void setUp() {
        client = new Client(1, "John Doe", "john.doe@example.com", "0725366879");

        flight1 = new Flight(101, "CityA", "CityB", LocalDateTime.of(2023, 6, 20, 10, 0));
        flight2 = new Flight(102, "CityA", "CityC", LocalDateTime.of(2023, 7, 15, 15, 0));

        reservation1 = new Reservation(client, flight1);
        reservation1.setReservationId(1);
        reservation1.setReservationDate(LocalDateTime.now());
        reservation1.setReservationStatus("Confirmed");

        reservation2 = new Reservation(client, flight2);
        reservation2.setReservationId(2);
        reservation2.setReservationDate(LocalDateTime.now());
        reservation2.setReservationStatus("Confirmed");

        client.bookTicket(reservation1);
        client.bookTicket(reservation2);
    }

    @Test
    void testCancelReservation_Success() {
        client.cancelReservationByFlightId(101);
        List<Reservation> reservations = client.getReservations();
        assertEquals(1, reservations.size(), "The reservation list should contain one reservation after cancellation.");
        assertFalse(reservations.contains(reservation1), "The canceled reservation should not be in the reservation list.");
    }

    @Test
    void testCancelReservation_NonExistingReservation() {
        client.cancelReservationByFlightId(999);
        List<Reservation> reservations = client.getReservations();
        assertEquals(2, reservations.size(), "The reservation list should contain two reservations after attempting to cancel a non-existing reservation.");
    }

    @Test
    void testCancelReservation_MultipleCancellations() {
        client.cancelReservationByFlightId(101);
        client.cancelReservationByFlightId(102);
        List<Reservation> reservations = client.getReservations();
        assertEquals(0, reservations.size(), "The reservation list should be empty after canceling all reservations.");
    }

    @Test
    void testCancelReservation_AlreadyCanceledReservation() {
        client.cancelReservationByFlightId(101);
        client.cancelReservationByFlightId(101);
        List<Reservation> reservations = client.getReservations();
        assertEquals(1, reservations.size(), "The reservation list should contain one reservation after attempting to cancel an already canceled reservation.");
        assertFalse(reservations.contains(reservation1), "The canceled reservation should not be in the reservation list.");
    }

    @Test
    void testCancelReservation_EdgeCase_NoReservations() {
        Client newClient = new Client(2, "Jane Doe", "jane.doe@example.com", "0725366880");
        newClient.cancelReservationByFlightId(101);
        List<Reservation> reservations = newClient.getReservations();
        assertEquals(0, reservations.size(), "The reservation list should be empty for a new client with no reservations.");
    }
}
