package Classes.Ticketzustaende;

import Classes.Autozaehler;
import Classes.Parkhaus;
import Classes.Preis;
import Classes.Tickets.Ticket;

import java.util.UUID;

import static Classes.Kassenautomat.round2Decimals;

public class Normalticket_Zustand extends TicketZustand {
    public Normalticket_Zustand(Ticket parent) {
        super(parent);
        zustand = "Normalticket";
        parent.setID(UUID.randomUUID().toString());
        parent.setErstellDatum(Parkhaus.getTicketDatenbank().getParkhausTime());
        Autozaehler.erhoeheAnzahl();
    }

    @Override
    public String bezahlen() {
        parent.setUeberwiesen(Preis.getPreis(parent));
        parent.setTicketZustand(new bezahlt_Zustand(parent));
        return "<h4>Das Ticket wurde bezahlt. Bitte verlassen Sie das Parkhaus.</h4>";
    }

    @Override
    public String KassenautomatenText() {
        return informationen() +
                String.format("<p>Zu zahlender Betrag: %.2f Euro</p>", round2Decimals(Preis.getPreis(parent))) +
                "<form action=\"kassenautomat\" method=\"post\">\n" +
                "    <input type=\"submit\" name=\"bezahlen\" value=\"Bezahlen\" />\n" +
                "</form>\n";
    }

    @Override
    public String rausfahren() {
        return "<p>Sie haben Ihr Ticket noch nicht bezahlt.</p>";
    }

    @Override
    public String informationen() {
        String erstellDatum = parent.getErstellDatum().toString();
        return "<h1>Ticket: " + parent.getID() + "</h1>" +
                "<h2>Zustand: " + zustand + "</h2>" +
                "<p>Erstellt am " + erstellDatum.substring(0, 10) + " um " + erstellDatum.substring(11, 16) + " Uhr.</p>" +
                String.format("<p>Parkdauer: %.2fh</p>", parent.berechneParkdauer());
    }
}
