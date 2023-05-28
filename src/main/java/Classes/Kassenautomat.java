package Classes;

public class Kassenautomat {


    public static void bezahle(Ticket ticket, double geld) {
        double preis = Preis.getPreis(ticket);
        double diff = geld + ticket.getUeberwiesen();

        ticket.setUeberwiesen(diff);

        if (Math.abs(diff - preis) > 0.01) {
            ticket.changeZustand("Nachzahlung");
        } else {
            ticket.changeZustand("bezahlt");
        }
    }

}
