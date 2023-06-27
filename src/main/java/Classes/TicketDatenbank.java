package Classes;

import Classes.Tickets.Ticket;
import Exceptions.RaumZeitKontinuumException;
import Interfaces.TicketDatenbankIF;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class TicketDatenbank implements TicketDatenbankIF {
    private List<Ticket> ticketDatenbank;

    public TicketDatenbank(List<Ticket> ticketdatenbank) {
        this.ticketDatenbank = ticketdatenbank;
    }

    public TicketDatenbank() {
        this(new ArrayList<Ticket>());
    }

    @Override
    public void addticket(Ticket ticket) {
        ticketDatenbank.add(ticket);
    }

    public Ticket getTicket(String ticketID) throws NoSuchElementException {
        Ticket result = ticketDatenbank
                .stream()
                .filter(p -> p.getID().equals(ticketID))
                .findFirst()
                .orElse(null);

        if (result != null) {
            return result;
        }
        throw new NoSuchElementException(String.format("Ticket with ID: %s does not exist.", ticketID));
    }

    public boolean containsTicket(String ticketID) {
        Ticket result = ticketDatenbank
                .stream()
                .filter(p -> p.getID().equals(ticketID))
                .findFirst()
                .orElse(null);
        return result != null;
    }

    public Ticket removeTicket(String ticketID) throws NoSuchElementException {
        Ticket[] removed = new Ticket[1];
        ticketDatenbank = ticketDatenbank
                .stream()
                .filter(t -> {
                    if (t.getID().equals(ticketID)) {
                        removed[0] = t;
                        return false;
                    } else {
                        return true;
                    }
                })
                .collect(Collectors.toList());

        if (removed[0] == null) {
            throw new NoSuchElementException(String.format("Ticket with ID: %s does not exist.", ticketID));
        }
        return removed[0];
    }

    public int getTicketanzahl() {
        return ticketDatenbank.size();
    }

    /**
     * Löscht Tickets die älter als 6 Monate sind.
     */

    public void bereinigeDatenbank() throws RaumZeitKontinuumException {
        ticketDatenbank = ticketDatenbank
                .stream()
                .filter(p -> p.berechneParkdauer() < 4392) //6 Monate sind 4392 Stunden
                .collect(Collectors.toList());
    }

    public List<Ticket> getAllTickets() {
        return new ArrayList<>(ticketDatenbank);
    }

}
