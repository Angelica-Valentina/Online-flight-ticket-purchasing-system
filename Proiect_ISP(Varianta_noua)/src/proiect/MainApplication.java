
package proiect;

import java.util.List;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MainApplication {

    static Client client = new Client(1, "John Doe", "john.doe@example.com", "0725366879");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("Are you a 'Client' or a 'Technician'? Type 'Exit' to close the application.");
            String role = scanner.nextLine().trim().toLowerCase();

            switch (role) {
                case "client":
                    handleClient(scanner);
                    break;

                case "technician":
                    handleTechnician(scanner);
                    break;

                case "exit":
                    run = false;
                    break;

                default:
                    System.out.println("Invalid input, please try again.\n");
            }
        }

        scanner.close();
        System.out.println("Application closed.");
    }

    private static void handleClient(Scanner scanner) {
        System.out.println("Client Actions: \n" +
                "1 - View Available Flights\n" +
                "2 - Reserve Ticket\n" +
                "3 - Cancel Reservation\n" +
                "4 - Modify Reservation\n" +
                "5 - Search Flights by Destination\n" +
                "6 - View Flight Details\n" +
                "7 - View Reservations\n");

        int action = scanner.nextInt();
        scanner.nextLine();

        switch (action) {
            case 1:
                if (FlightManager.hasFlights()) {
                    System.out.println("Available flights:");
                    for (Flight flight : FlightManager.getFlights()) {
                        System.out.println("Flight from " + flight.getOrigin() + " to " + flight.getDestination() + ", on date: " + flight.getFlightDate() + " with ID: " + flight.getFlightId());
                    }
                } else {
                    System.out.println("No available flights yet. Come back later.");
                }
                System.out.println();
                break;

            case 2:
                System.out.println("Enter Flight ID:");
                int id = scanner.nextInt();
                scanner.nextLine();
                Flight flight = FlightManager.getFlights().stream().filter(f -> f.getFlightId() == id).findFirst().orElse(null);
                if (flight != null) {
                    Reservation reservation = new Reservation(client, flight);
                    client.bookTicket(reservation);
                    System.out.println("Ticket reserved for " + flight.getDestination());

                    float paymentAmount = 100.0f;
                    LocalDateTime paymentDate = LocalDateTime.now();
                    String paymentMethod = "Credit Card";
                    Payment payment = new Payment(1, paymentAmount, paymentDate, paymentMethod);
                    System.out.println("Processing payment...");
                    payment.processPayment("Payment details are confidential.");
                } else {
                    System.out.println("Flight not found. Please enter a valid flight ID.");
                }
                System.out.println();
                break;

            case 3:
                System.out.println("Enter Flight ID to cancel reservation:");
                int cancelId = scanner.nextInt();
                scanner.nextLine();
                client.cancelReservationByFlightId(cancelId);
                System.out.println();
                break;

            case 4:
                System.out.println("Enter the Flight ID of the reservation to modify and the new Flight ID:");
                int oldFlightId = scanner.nextInt();
                int newFlightId = scanner.nextInt();
                scanner.nextLine();
                Flight newFlight = FlightManager.getFlights().stream().filter(f -> f.getFlightId() == newFlightId).findFirst().orElse(null);
                if (newFlight != null) {
                    client.modifyReservationByFlightId(oldFlightId, newFlight);
                } else {
                    System.out.println("New flight ID not found.");
                }
                System.out.println();
                break;

            case 5:
                System.out.println("Enter destination to search for flights:");
                String destination = scanner.nextLine();
                List<Flight> foundFlights = FlightManager.searchFlightsByDestination(destination);
                if (!foundFlights.isEmpty()) {
                    System.out.println("Flights to " + destination + ":");
                    for (Flight foundFlight : foundFlights) {
                        System.out.println("Flight ID: " + foundFlight.getFlightId() + ", from " + foundFlight.getOrigin() + " to " + foundFlight.getDestination());
                    }
                } else {
                    System.out.println("No flights found to " + destination);
                }
                System.out.println();
                break;

            case 6:
                System.out.println("Enter Flight ID to view details:");
                int flightIdForDetails = scanner.nextInt();
                scanner.nextLine();
                client.viewFlightDetails(flightIdForDetails);
                System.out.println();
                break;

            case 7:
                client.displayReservations();
                System.out.println();
                break;

            default:
                System.out.println("Invalid action. Please choose a correct number.\n");
        }
    }

    private static void handleTechnician(Scanner scanner) {
        System.out.println("Technician Actions: \n" +
                "1 - Add Flight\n" +
                "2 - Update Flight\n" +
                "3 - Cancel Flight\n" +
                "4 - Show All Flights\n");

        int action = scanner.nextInt();
        scanner.nextLine(); // consume newline left-over

        switch (action) {
            case 1:
                System.out.println("Enter new Flight ID, Origin, Destination, Year, Month, Day, Hour, Minute:");
                int newId = scanner.nextInt();
                String newOrigin = scanner.next();
                String newDestination = scanner.next();
                int year = scanner.nextInt();
                int month = scanner.nextInt();
                int day = scanner.nextInt();
                int hour = scanner.nextInt();
                int minute = scanner.nextInt();
                scanner.nextLine();

                LocalDateTime newDateTime = LocalDateTime.of(year, month, day, hour, minute);
                Flight newFlight = new Flight(newId, newOrigin, newDestination, newDateTime);
                FlightManager.addFlight(newFlight);
                System.out.println("New flight added.");
                break;

            case 2:
                System.out.println("Enter Flight ID to update, new Origin, and new Destination:");
                break;

            case 3:
                System.out.println("Enter Flight ID to cancel:");
                int cancelId = scanner.nextInt();
                scanner.nextLine();

                FlightManager.cancelFlight(cancelId);
                System.out.println("Flight canceled.");
                break;

            case 4:
                showAllFlights();
                break;

            default:
                System.out.println("Invalid action or action not yet implemented\n");
                break;
        }
    }

    private static void showAllFlights() {
        List<Flight> flights = FlightManager.getFlights();
        if (flights.isEmpty()) {
            System.out.println("There are currently no flights available.");
        } else {
            System.out.println("Available Flights:");
            for (Flight flight : flights) {
                System.out.println("Flight ID: " + flight.getFlightId() + ", from " + flight.getOrigin() + " to " + flight.getDestination() + ", " + flight.getFlightDate());
            }
        }
    }
}
