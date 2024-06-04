//package proiect;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//public class Rezervare {
//    private int idRezervare;
//    private LocalDateTime dataRezervare;
//    private String statusRezervare;
//    private Zbor zbor;
//    private List<Bilet> bilete;
//    private Client client;
//
////    public Rezervare(int idRezervare, Client client, Zbor zbor, LocalDateTime dataRezervare, String statusRezervare) {
////        this.idRezervare = idRezervare;
////        this.client = client;
////        this.zbor = zbor;
////        this.dataRezervare = dataRezervare;
////        this.statusRezervare = statusRezervare;
////        this.bilete = new ArrayList<>();
////    }//aici era comentat
//
//    public Rezervare(Client client, Zbor zbor) {
//        this.client = client;
//        this.zbor = zbor;
//
//    }
//    
//    public void emiteBilet(int idBilet, String detaliiBilet, int clasaBilet, float pretBilet) {
//        Bilet bilet = new Bilet(idBilet, detaliiBilet, clasaBilet, pretBilet);
//        bilete.add(bilet);
//        System.out.println("Ticket issued for reservation ID " + idRezervare);
//    }
//
//    public void anuleazaBilet(int idBilet) {
//        bilete.removeIf(b -> b.getIdBilet() == idBilet);
//        System.out.println("Ticket canceled for reservation ID " + idRezervare);
//    }
//
//    public int getIdRezervare() {
//        return idRezervare;
//    }
//
//    public void setIdRezervare(int idRezervare) {
//        this.idRezervare = idRezervare;
//    }
//
//    public LocalDateTime getDataRezervare() {
//        return dataRezervare;
//    }
//
//    public void setDataRezervare(LocalDateTime dataRezervare) {
//        this.dataRezervare = dataRezervare;
//    }
//
//    public String getStatusRezervare() {
//        return statusRezervare;
//    }
//
//    public void setStatusRezervare(String statusRezervare) {
//        this.statusRezervare = statusRezervare;
//    }
//
//    public Zbor getZbor() {
//        return zbor;
//    }
//
//    public void setZbor(Zbor zbor) {
//        this.zbor = zbor;
//    }
//
//    public List<Bilet> getBilete() {
//        return new ArrayList<>(bilete);
//    }
//
//    public Client getClient() {
//        return client;
//    }
//
//    public void setClient(Client client) {
//        this.client = client;
//    }
//}

package proiect;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private int reservationId;
    private LocalDateTime reservationDate;
    private String reservationStatus;
    private Flight flight;
    private List<Ticket> tickets;
    private Client client;

    public Reservation(Client client, Flight flight) {
        this.client = client;
        this.flight = flight;
        this.tickets = new ArrayList<>();
    }
    
    public void issueTicket(int ticketId, String ticketDetails, int ticketClass, float ticketPrice) {
        Ticket ticket = new Ticket(ticketId, ticketDetails, ticketClass, ticketPrice);
        tickets.add(ticket);
        System.out.println("Ticket issued for reservation ID " + reservationId);
    }

    public void cancelTicket(int ticketId) {
        tickets.removeIf(ticket -> ticket.getTicketId() == ticketId);
        System.out.println("Ticket canceled for reservation ID " + reservationId);
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public List<Ticket> getTickets() {
        return new ArrayList<>(tickets);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}

