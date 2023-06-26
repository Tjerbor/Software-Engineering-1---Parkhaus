package Classes;


import Classes.Tickets.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PreisTest {
    @Test
    public void testGetPreis_UnderTagespreis() {
        double Stundenpreis = 2.3;
        Ticket ticket = new Ticket();
        double parkdauer = ticket.berechneParkdauer();
        double preis = parkdauer * Stundenpreis;
        assertEquals(preis, Preis.getPreis(ticket));
    }


    private TicketDatenbank ticketDatenbank;

    @BeforeEach
    public void setup() {
        ticketDatenbank = new TicketDatenbank();
    }


    @Test
    public void testSetStundenpreis() {
        Preis.setStundenpreis(3.0);
        assertEquals(3.0, Preis.getStundenpreis());
    }

    @Test
    public void testSetTagespreis() {
        Preis.setTagespreis(30.0);
        assertEquals(30.0, Preis.getTagespreis());
    }
}
