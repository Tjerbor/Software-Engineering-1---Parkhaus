package Classes;

import Classes.TicketDatenbank;
import Classes.Tickets.Ticket;
import Exceptions.RaumZeitKontinuumException;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TicketDatenbankTest {

    @Test
    public void testAddTicket() {
        TicketDatenbank ticketDatenbank = new TicketDatenbank();
        Ticket ticket = new Ticket();
        ticket.init();
        ticketDatenbank.addticket(ticket);
        assertTrue(ticketDatenbank.containsTicket(ticket.getID()));
    }

    @Test
    public void testGetTicket() {
        TicketDatenbank ticketDatenbank = new TicketDatenbank();
        Ticket ticket = new Ticket();
        ticket.init();
        ticketDatenbank.addticket(ticket);
        assertEquals(ticket, ticketDatenbank.getTicket(ticket.getID()));
    }

    @Test
    public void testRemoveTicket() {
        TicketDatenbank ticketDatenbank = new TicketDatenbank();
        Ticket ticket = new Ticket();
        ticket.init();
        ticketDatenbank.addticket(ticket);
        ticketDatenbank.removeTicket(ticket.getID());
        assertFalse(ticketDatenbank.containsTicket(ticket.getID()));
    }

    @Test
    public void testGetTicketanzahl() {
        TicketDatenbank ticketDatenbank = new TicketDatenbank();
        assertEquals(0, ticketDatenbank.getTicketanzahl());
        Ticket ticket1 = new Ticket();
        ticketDatenbank.addticket(ticket1);
        assertEquals(1, ticketDatenbank.getTicketanzahl());
        Ticket ticket2 = new Ticket();
        ticketDatenbank.addticket(ticket2);
        assertEquals(2, ticketDatenbank.getTicketanzahl());
    }

    @Test
    public void testBereinigeDatenbank() {
        TicketDatenbank ticketDatenbank = new TicketDatenbank();
        Ticket ticket1 = new Ticket();
        ticketDatenbank.addticket(ticket1);
        Ticket ticket2 = new Ticket();
        ticketDatenbank.addticket(ticket2);
        assertEquals(2, ticketDatenbank.getTicketanzahl());
        try {
            ticketDatenbank.bereinigeDatenbank();
        } catch (RaumZeitKontinuumException e) {
            fail("Should not throw an exception.");
        }
        assertEquals(2, ticketDatenbank.getTicketanzahl()); // Die Methode soll keine Tickets entfernen, wenn sie weniger als 6 Monate alt sind
    }

    @Test
    public void testGetAllTickets() {
        TicketDatenbank ticketDatenbank = new TicketDatenbank();
        Ticket ticket1 = new Ticket();
        ticketDatenbank.addticket(ticket1);
        Ticket ticket2 = new Ticket();
        ticketDatenbank.addticket(ticket2);
        List<Ticket> tickets = ticketDatenbank.getAllTickets();
        assertEquals(2, tickets.size());
        assertTrue(tickets.contains(ticket1));
        assertTrue(tickets.contains(ticket2));
    }
}
