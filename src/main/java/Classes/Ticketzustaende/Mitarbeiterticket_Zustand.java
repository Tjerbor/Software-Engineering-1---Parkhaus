package Classes.Ticketzustaende;

import Classes.Parkhaus;
import Classes.Tickets.Ticket;

import java.util.UUID;

public class Mitarbeiterticket_Zustand extends TicketZustand {
    public Mitarbeiterticket_Zustand(Ticket parent) {
        super(parent);
        zustand = "Mitarbeiterticket";
        parent.setID(UUID.randomUUID().toString());
        parent.setErstellDatum(Parkhaus.getParkhausTime());
    }

    @Override
    public String KassenautomatenText() {
        return "<p>Mitarbeitertickets sind nicht Kostenpflichtig.</p>";
    }

    @Override
    public String reinfahren() {
        if (Parkhaus.getReingefahrenTicketDatenbank().containsTicket(parent.getID())) {
            return "<p>Sie befinden sich bereits im Parkaus.</p>";
        } else {
            Parkhaus.getReingefahrenTicketDatenbank().addticket(parent);
            return "<h4>Erfolgreich reingefahren.</h4>";
        }
    }

    @Override
    public String rausfahren() {
        if (Parkhaus.getReingefahrenTicketDatenbank().containsTicket(parent.getID())) {
            Parkhaus.getReingefahrenTicketDatenbank().removeTicket(parent.getID());
            return "<h4>Erfolgreich rausgefahren.</h4>";
        } else {
            return "<h4>Sie können nicht rausfahren solange Sie vorher nicht reingefahren sind.</h4>";
        }
    }

    @Override
    public String informationen() {
        String erstellDatum = parent.getErstellDatum().toString();
        return "<h1>Ticket: " + parent.getID() + "</h1>" +
                "<h2>Zustand: " + zustand + "</h2>" +
                "<p>Erstellt am " + erstellDatum.substring(0, 10) + " um " + erstellDatum.substring(11, 16) + " Uhr.</p>";
    }
}
