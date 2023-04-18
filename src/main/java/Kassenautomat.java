public class Kassenautomat {

    public void bezahle(Ticket ticket, double geld) throws IllegalArgumentException {
        double preis = Preis.getPreis(ticket);
        if (geld < preis) {
            throw new IllegalArgumentException("Der Betrag wurde nicht vollständig abbezahlt.");
        }
        ticket.setBezahlt(true);
    }

}
