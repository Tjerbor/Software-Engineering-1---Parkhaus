package Classes;

import Classes.Tickets.Ticket;

import java.time.Duration;

public class Rausfahren {

    public boolean darfraus(Ticket ticket) {
        if (ticket.getID().startsWith("110")) {
            return true;
        } else if (ticket.getID().startsWith("DP")) {
            return true;
        } else if (Duration.between(ticket.getBezahlDatum(), Parkhaus.getParkhausTime()).toMinutes() < 15) {
            return true;
        } else {
            return false;
        }
    }
}
