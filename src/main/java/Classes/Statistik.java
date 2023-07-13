package Classes;

import Classes.Tickets.Ticket;

import java.time.LocalDateTime;

public class Statistik {

    private Statistik(){}
    public static double berechneEinnahmen(LocalDateTime start, LocalDateTime end) {
        double einnahmen = 0.0;
        //TicketDatenbank datenbank = Parkhaus.getKompletteTicketDatenbank();

        for (Ticket ticket : Parkhaus.getUmsatzTicketDatenbank().getAllTickets() ) {
            LocalDateTime bezahlDatum = ticket.getBezahlDatum();
            if (bezahlDatum != null && bezahlDatum.isAfter(start) && bezahlDatum.isBefore(end)) {
                if (ticket.getZustand().equals("bezahlt")) {
                    double parkdauer = ticket.berechneParkdauer();
                    double stundenpreis = Preis.getStundenpreis(); // Ersetzen Sie dies durch Ihren tatsächlichen Stundenpreis
                    double ticketEinnahmen = parkdauer * stundenpreis;
                    einnahmen += ticketEinnahmen;
                }
            }
        }

        return einnahmen;
    }
}
