package Classes.Ticketzustaende;

import Classes.Parkhaus;
import Classes.Preis;
import Classes.Tickets.Ticket;

import java.util.UUID;

import static Classes.Kassenautomat.round2Decimals;

public class Ersatzticket_Zustand extends TicketZustand{

    public Ersatzticket_Zustand(Ticket parent) {
        super(parent);
        zustand = "Ersatzticket";
        parent.setID(UUID.randomUUID().toString());
        parent.setErstellDatum(Parkhaus.getParkhausTime().minusDays(1));
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
    public String reinfahren() {
        return "<p>Sie können nicht erneut mit dem selben Ticket reinfahren.</p>";
    }

    @Override
    public String rausfahren() {
        return "<p>Sie haben Ihr Ticket noch nicht bezahlt.</p>";
    }

    @Override
    public String informationen() {
        String erstellDatum = parent.getErstellDatum().toString();
        return "<h1>Ticket: " + parent.getID() + "</h1>" +
                "<h2>Zustand: " + zustand + "</h2>";
    }
}
