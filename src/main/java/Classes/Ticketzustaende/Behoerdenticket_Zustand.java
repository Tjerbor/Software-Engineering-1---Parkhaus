package Classes.Ticketzustaende;

import Classes.Autozaehler;
import Classes.Parkhaus;
import Classes.Tickets.Ticket;

import java.util.UUID;

public class Behoerdenticket_Zustand extends TicketZustand {

    public Behoerdenticket_Zustand(Ticket parent) {
        super(parent);
        zustand = "Behoerdenticket";
        parent.setID("110|" + UUID.randomUUID().toString());
        parent.setErstellDatum(Parkhaus.getParkhausTime());
    }

    @Override
    public String KassenautomatenText() {
        return "<h1>Behördentickets sind nicht kostenpflichtig.</h1>";
    }

    @Override
    public String reinfahren() {
        Parkhaus.getReingefahrenTicketDatenbank().addticket(parent);
        return "<h4>Erfolgreich reingefahren.</h4>";
    }

    @Override
    public String rausfahren() {
        Parkhaus.getReingefahrenTicketDatenbank().removeTicket(parent.getID());
        return "<h4>Erfolgreich rausgefahren.</h4>";
    }

    @Override
    public String informationen() {
        String erstellDatum = parent.getErstellDatum().toString();
        return "<h1>Ticket: " + parent.getID() + "</h1>" +
                "<h2>Zustand: " + zustand + "</h2>" +
                "<p>Erstellt am " + erstellDatum.substring(0, 10) + " um " + erstellDatum.substring(11, 16) + " Uhr.</p>";
    }
}
