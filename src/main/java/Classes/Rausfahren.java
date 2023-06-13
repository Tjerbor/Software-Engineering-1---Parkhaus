package Classes;

import java.time.Duration;
import java.time.LocalDateTime;

public class Rausfahren {

    public boolean darfraus(Ticket ticket) {


        if (ticket.getID().startsWith("110")) {
            return true;
        } else if (ticket.getID().startsWith("DP") && ticket.getBezahlDatum() != null) {
            return true;
        } else if (Duration.between(ticket.getBezahlDatum(), TicketDatenbank.getParkhausTime()).toMinutes() < 15) {
            return true;
        } else {
            return false;
        }
    }
}
