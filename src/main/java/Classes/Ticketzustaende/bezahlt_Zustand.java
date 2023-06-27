package Classes.Ticketzustaende;

import Classes.Autozaehler;
import Classes.Parkhaus;
import Classes.Tickets.Ticket;

import java.time.Duration;

import static Classes.Kassenautomat.round2Decimals;

public class bezahlt_Zustand extends TicketZustand {
    public bezahlt_Zustand(Ticket parent) {
        super(parent);
        zustand = "bezahlt";
        parent.setBezahlDatum(Parkhaus.getParkhausTime());
    }

    @Override
    public String KassenautomatenText() {
        if (Duration.between(parent.getBezahlDatum(), Parkhaus.getParkhausTime()).toMinutes() > 15L) {
            parent.setTicketZustand(new Nachzahlung_Zustand(parent));
            return parent.kassenautomatenText();
        } else {
            return "<p>Das Ticket wurde bereits bezahlt.</p>";
        }
    }

    @Override
    public String bezahlen() {
        return "<p>Sie können nicht erneut mit dem selben Ticket reinfahren.</p>";
    }

    @Override
    public String rausfahren() {
        if (Duration.between(parent.getBezahlDatum(), Parkhaus.getParkhausTime()).toMinutes() < 15L) {
            Parkhaus.getKompletteTicketDatenbank().removeTicket(parent.getID());
            Parkhaus.getUmsatzTicketDatenbank().addticket(
                    Parkhaus.getReingefahrenTicketDatenbank().removeTicket(parent.getID())
            );
            Autozaehler.verringereAnzahl();
            return "<p>Sie haben das Parkhaus verlassen.</p><p>Ihr Ticket wurde gelöscht.</p>";
        } else {
            parent.setTicketZustand(new Nachzahlung_Zustand(parent));
            return "<p>Sie haben ihr Ticket vor länger als 15 Minuten bezahlt und nun wird eine Nachzahlung gefordert.</p>";
        }
    }

    @Override
    public String informationen() {
        String erstellDatum = parent.getErstellDatum().toString();
        String bezahlDatum = parent.getBezahlDatum().toString();
        return "<h1>Ticket: " + parent.getID() + "</h1>" +
                "<h2>Zustand: " + zustand + "</h2>" +
                "<p>Erstellt am " + erstellDatum.substring(0, 10) + " um " + erstellDatum.substring(11, 16) + " Uhr.</p>" +
                String.format("<p>Parkdauer: %.2fh</p>", parent.berechneParkdauer()) +
                "<p>Bezahlt am " + bezahlDatum.substring(0, 10) + " um " + bezahlDatum.substring(11, 16) + " Uhr.</p>" +
                String.format("<p>Überwiesene Summe: %.2f Euro</p>", round2Decimals(parent.getUeberwiesen()));
    }
}
