package Classes;

public class Kassenautomat{


    public static void bezahle(Ticket ticket, double geld) throws IllegalArgumentException {
        double preis = Preis.getPreis(ticket);

        if (Math.abs(geld - preis) > 0.01) {
            if (geld < preis) {
                throw new IllegalArgumentException("Der Betrag wurde nicht vollständig abbezahlt.");
            } else {
                throw new IllegalArgumentException("Es wurde zu viel Geld überwiesen");
            }
        }
        ticket.setBezahlt(true);
    }

}
