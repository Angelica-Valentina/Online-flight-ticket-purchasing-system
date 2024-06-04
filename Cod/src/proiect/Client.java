
package proiect;

import java.util.ArrayList;
import java.util.List;

public class Client {

	private int clientId;
	private String name;
	private String email;
	private String phone;
	private List<Reservation> reservations = new ArrayList<>();

	public Client(int clientId, String name, String email, String phone) {
		this.clientId = clientId;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public void bookTicket(Reservation reservation) {
        reservations.add(reservation);
        System.out.println("Reservation added for flight to " + reservation.getFlight().getDestination() + ".");
    }

	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public void cancelReservationByFlightId(int flightId) {
		Reservation reservationToCancel = null;
		for (Reservation reservation : reservations) {
			if (reservation.getFlight().getFlightId() == flightId) {
				reservationToCancel = reservation;
				break;
			}
		}

		if (reservationToCancel != null) {
			reservations.remove(reservationToCancel);
			System.out.println("Reservation for flight ID " + flightId + " has been canceled.");
		} else {
			System.out.println("No reservation found for flight ID " + flightId + ".");
		}
	}
	
	public void modifyReservationByFlightId(int oldId, Flight newFlight) {
		int notFound = 0;
	    // Find the reservation with the old flight ID and update it
	    for (Reservation reservation : reservations) {
	        if (reservation.getFlight().getFlightId() == oldId) {
	            reservation.setFlight(newFlight);
	            System.out.println("Reservation updated to new flight from " + newFlight.getOrigin() + " to " + newFlight.getDestination());
	            notFound = 1;
	            return;
	        }
	    }
	    if (notFound == 1) {
	    	System.out.println("No reservation found");
	    }
	    	// with ID " + oldId);
	}
	
	
	public List<Flight> searchFlight(String destination) {
		List<Flight> foundFlights = new ArrayList<>();
		for (Flight flight : FlightManager.getFlights()) {
			if (flight.getDestination().equals(destination)) {
				foundFlights.add(flight);
			}
		}
		return foundFlights;
	}

	public void viewFlightDetails(int flightId) {
		for (Reservation reservation : reservations) {
			if (reservation.getFlight().getFlightId() == flightId) {
				Flight flight = reservation.getFlight();
				System.out.println("Flight details: ID - " + flight.getFlightId() + ", Origin - " + flight.getOrigin() + ", Destination - " + flight.getDestination());
				return;
			}
		}
		System.out.println("No flight found with ID: " + flightId);
	}

	public void displayReservations() {
		if (reservations.isEmpty()) {
			System.out.println("No reservations made by client: " + name);
			return;
		}

		System.out.println("Reservations made by client " + name + " are:");
		for (Reservation reservation : reservations) {
			Flight flight = reservation.getFlight();
			System.out.println("Reservation Flight ID: " + flight.getFlightId() + ", Destination: " + flight.getDestination() + ", Origin: " + flight.getOrigin() + ", Data: " + flight.getFlightDate());
		}
	}
}
