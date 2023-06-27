package Classes;

public class Parkhaus {
    private static TicketDatenbank ticketDatenbank = new TicketDatenbank();

    public static TicketDatenbank getTicketDatenbank() {
        return ticketDatenbank;
    }

    public static void setTicketDatenbank(TicketDatenbank ticketDatenbank) {
        Parkhaus.ticketDatenbank = ticketDatenbank;
    }
    public static void removeAllTickets() {
        ticketDatenbank = new TicketDatenbank();
    }
}
