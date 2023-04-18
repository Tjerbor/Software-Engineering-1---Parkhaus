package Classes;

import Interfaces.TicketDatenbankIF;

import java.util.ArrayList;
import java.util.List;

public class TicketDatenbank implements TicketDatenbankIF {

    private List<Ticket> ticketDatenbank;

    public TicketDatenbank(List<Ticket> ticketdatenbank) {
        this.ticketDatenbank = new ArrayList<Ticket>();
    }

    public TicketDatenbank() {
        this(new ArrayList<Ticket>());
    }

    @Override
    public void addticket(Ticket ticket) {
        ticketDatenbank.add(ticket);
    }

    @Override
    public void addErsatzTicket() {
        ticketDatenbank.add(new Ticket(true));
    }

    /**
     * Löscht Tickets die älter als 6 Monate sind.
     */
    @Override
    public void bereinigeDatenbank() {
        int index = 0;
        while (index < ticketDatenbank.size()) {
            Ticket current = ticketDatenbank.get(index);
            if (current.berechneParkdauer() >= 4392) { //6 Monate sind 4392 Stunden
                ticketDatenbank.remove(index);
            } else {
                index++;
            }
        }
    }


}
