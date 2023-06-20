package Classes.Ticketzustaende;

import Classes.Preis;
import Classes.Ticket;

import static Classes.Kassenautomat.round2Decimals;

public class Nachzahlung_Zustand extends TicketZustand {

    public Nachzahlung_Zustand(Ticket parent) {
        super(parent);
        zustand = "Nachzahlung";
        parent.setBezahlDatum(null);
    }

    @Override
    public String KassenautomatenText() {
        return informationen() +
                "<form action=\"kassenautomat\" method=\"post\">\n" +
                "    <input type=\"submit\" name=\"bezahlen\" value=\"Bezahlen\" />\n" +
                "</form>\n";
    }

    @Override
    public String bezahlen() {
        parent.setUeberwiesen(Preis.getPreis(parent));
        parent.setTicketZustand(new bezahlt_Zustand(parent));
        return "<h4>Das Ticket wurde bezahlt. Bitte verlassen Sie das Parkhaus.</h4>";
    }

    @Override
    public String rausfahren() {
        return "<p>Es ist länger 15 Minuten her, dass Sie ihr Ticket bezahlt haben. Nun wird eine nachzahlung gefordert.</p>";
    }

    @Override
    public String informationen() {
        String erstellDatum = parent.getErstellDatum().toString();
        return "<h1>Ticket: " + parent.getID() + "</h1>" +
                "<h2>Zustand: " + zustand + "</h2>" +
                "<p>Erstellt am " + erstellDatum.substring(0, 10) + " um " + erstellDatum.substring(11, 16) + " Uhr.</p>" +
                String.format("<p>Parkdauer: %.2fh</p>", parent.berechneParkdauer()) +
                String.format("<p>Überwiesene Summe: %.2f Euro</p>", round2Decimals(parent.getUeberwiesen())) +
                String.format("<p>Fehlender Restbetrag: %.2f Euro</p>", round2Decimals(Preis.getPreis(parent) - parent.getUeberwiesen()));

    }
}
