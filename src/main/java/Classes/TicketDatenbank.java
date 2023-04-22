package Classes;

import Interfaces.TicketDatenbankIF;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

    public Ticket getTicket(String ticketID) throws NoSuchElementException {
        for (Ticket t : ticketDatenbank) {
            if (t.getID().equals(ticketID)) {
                return t;
            }
        }
        throw new NoSuchElementException(String.format("Ticket with ID: %s does not exist.", ticketID));
    }

    public boolean containsTicket(String ticketID) {
        for (Ticket t : ticketDatenbank) {
            if (t.getID().equals(ticketID)) {
                return true;
            }
        }
        return false;
    }

    public Ticket removeTicket(String ticketID) throws NoSuchElementException {
        for (int i = 0; i < ticketDatenbank.size(); i++) {
            Ticket current = ticketDatenbank.get(i);
            if (current.getID().equals(ticketID)) {
                Autozaehler.verringereAnzahl();
                return ticketDatenbank.remove(i);
            }
        }
        throw new NoSuchElementException(String.format("Ticket with ID: %s does not exist.", ticketID));
    }

    public int getTicketanzahl() {
        return ticketDatenbank.size();
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
