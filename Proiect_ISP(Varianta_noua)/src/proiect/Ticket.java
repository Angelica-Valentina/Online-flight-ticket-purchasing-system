//package proiect;
//
//public class Bilet {
//    private int idBilet;
//    private String detaliiBilet;
//    private int clasaBilet;
//    private float pretBilet;
//
//    public Bilet(int idBilet, String detaliiBilet, int clasaBilet, float pretBilet) {
//        this.idBilet = idBilet;
//        this.detaliiBilet = detaliiBilet;
//        this.clasaBilet = clasaBilet;
//        this.pretBilet = pretBilet;
//    }
//
//    public void emiteBilet() {
//        System.out.println("Biletul a fost emis.");
//    }
//
//    public void anuleazaBilet() {
//        System.out.println("Biletul a fost anulat.");
//    }
//
//    public int getIdBilet() {
//        return idBilet;
//    }
//
//    public void setIdBilet(int idBilet) {
//        this.idBilet = idBilet;
//    }
//
//    public String getDetaliiBilet() {
//        return detaliiBilet;
//    }
//
//    public void setDetaliiBilet(String detaliiBilet) {
//        this.detaliiBilet = detaliiBilet;
//    }
//
//    public int getClasaBilet() {
//        return clasaBilet;
//    }
//
//    public void setClasaBilet(int clasaBilet) {
//        this.clasaBilet = clasaBilet;
//    }
//
//    public float getPretBilet() {
//        return pretBilet;
//    }
//
//    public void setPretBilet(float pretBilet) {
//        this.pretBilet = pretBilet;
//    }
//}

package proiect;

public class Ticket {
    private int ticketId;
    private String ticketDetails;
    private int ticketClass;
    private float ticketPrice;

    public Ticket(int ticketId, String ticketDetails, int ticketClass, float ticketPrice) {
        this.ticketId = ticketId;
        this.ticketDetails = ticketDetails;
        this.ticketClass = ticketClass;
        this.ticketPrice = ticketPrice;
    }

    public void issueTicket() {
        System.out.println("Ticket has been issued.");
    }

    public void cancelTicket() {
        System.out.println("Ticket has been canceled.");
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketDetails() {
        return ticketDetails;
    }

    public void setTicketDetails(String ticketDetails) {
        this.ticketDetails = ticketDetails;
    }

    public int getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(int ticketClass) {
        this.ticketClass = ticketClass;
    }

    public float getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(float ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
