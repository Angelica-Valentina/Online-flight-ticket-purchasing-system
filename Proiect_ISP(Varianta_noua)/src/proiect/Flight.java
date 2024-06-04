
package proiect;

import java.time.LocalDateTime;

public class Flight {
    private int flightId;
    private String origin;
    private String destination;
    private LocalDateTime flightDate;

    public Flight(int flightId, String origin, String destination, LocalDateTime flightDate) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.flightDate = flightDate;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(LocalDateTime flightDate) {
        this.flightDate = flightDate;
    }

    @Override
    public String toString() {
        return "Flight{" +
               "flightId=" + flightId +
               ", origin='" + origin + '\'' +
               ", destination='" + destination + '\'' +
               ", flightDate=" + flightDate +
               '}';
    }
}

