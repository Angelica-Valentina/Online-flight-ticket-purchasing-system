
package proiect;

import java.util.ArrayList;
import java.util.List;

public class FlightManager {
    private static List<Flight> flights = new ArrayList<>();

    public static void addFlight(Flight flight) {
        flights.add(flight);
    }

    public static List<Flight> getFlights() {
        return flights;
    }

    public static boolean hasFlights() {
        return !flights.isEmpty();
    }

    public static void updateFlight(int flightId, String newOrigin, String newDestination) {
        for (Flight flight : flights) {
            if (flight.getFlightId() == flightId) {
                flight.setOrigin(newOrigin);
                flight.setDestination(newDestination);
                break;
            }
        }
    }

    public static void cancelFlight(int flightId) {
        flights.removeIf(flight -> flight.getFlightId() == flightId);
    }

    public static List<Flight> searchFlightsByDestination(String destination) {
        List<Flight> foundFlights = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getDestination().equalsIgnoreCase(destination)) {
                foundFlights.add(flight);
            }
        }
        return foundFlights;
    }
}
