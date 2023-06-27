package Classes;

public class Parkhaus {
    private static TicketDatenbank ticketDatenbank = new TicketDatenbank();
    private static int Parkplaetze = 50;

    public static TicketDatenbank getTicketDatenbank() {
        return ticketDatenbank;
    }

    public static void setTicketDatenbank(TicketDatenbank ticketDatenbank) {
        Parkhaus.ticketDatenbank = ticketDatenbank;
    }

    public static void reset() {
        ticketDatenbank = new TicketDatenbank();
    }

    public static int getParkplaetze() {
        return Parkplaetze;
    }

    public static int getOffizielFreieParkplaetze() {
        return Parkplaetze - ticketDatenbank.getDauerparkerAnzahl() - Autozaehler.getAutoanzahl();
    }

    public static int getInoffizielFreieParkplaetze() {
        return Parkplaetze - Autozaehler.getAutoanzahl();
    }

    public static void setParkplaetze(int parkplaetze) {
        Parkplaetze = parkplaetze;
    }
}
