package Classes.Ticketzustaende;

import Classes.Parkhaus;
import Classes.Tickets.Ticket;

import java.time.Duration;
import java.util.UUID;

public class Dauerparker_Zustand extends TicketZustand {
    public Dauerparker_Zustand(Ticket parent) {
        super(parent);
        zustand = "Dauerparker";
        parent.setID(UUID.randomUUID().toString());
        parent.setErstellDatum(Parkhaus.getParkhausTime());
        Parkhaus.erhoeheDauerparkerAnzahl();
    }

    @Override
    public String KassenautomatenText() {
        return "<p>Dauerparkertickets sind bereits bezahlt.\nSie können ohne Bedenken das Parkhaus verlassen</p>";
    }

    @Override
    public String reinfahren() {
        if (Parkhaus.getReingefahrenTicketDatenbank().containsTicket(parent.getID())) {
            return "<p>Sie befinden sich bereits im Parkaus.</p>";
        } else {
            if (Duration.between(parent.getErstellDatum(), Parkhaus.getParkhausTime()).toDays() > Parkhaus.getGueltigKeitsLaengeDauerparker()) {
                Parkhaus.getKompletteTicketDatenbank().removeTicket(parent.getID());
                return "<p>Ihr Ticket ist abgelaufen.</p>";
            } else {
                Parkhaus.getReingefahrenTicketDatenbank().addticket(parent);
                return "<p>Erfolgreich reingefahren.</p>";
            }
        }
    }

    @Override
    public String rausfahren() {
        if (Parkhaus.getReingefahrenTicketDatenbank().containsTicket(parent.getID())) {
            Parkhaus.getReingefahrenTicketDatenbank().removeTicket(parent.getID());
            return "<p>Erfolgreich rausgefahren.</p>";
        } else {
            return "<p>Sie können nicht rausfahren solange Sie vorher nicht reingefahren sind.</p>";
        }
    }

    @Override
    public String informationen() {
        String erstellDatum = parent.getErstellDatum().toString();
        String gueltigkeitsDatum = parent.getErstellDatum().plusDays(Parkhaus.getGueltigKeitsLaengeDauerparker()).toString();
        return "<h1>Ticket: " + parent.getID() + "</h1>" +
                "<h2>Zustand: " + zustand + "</h2>" +
                "<p>Erstellt am " + erstellDatum.substring(0, 10) + " um " + erstellDatum.substring(11, 16) + " Uhr.</p>" +
                "<p>Gültig bis " + erstellDatum.substring(0, 10) + " " + erstellDatum.substring(11, 16) + " Uhr.</p>";
    }
}
