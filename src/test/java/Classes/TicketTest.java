package Classes;

import Classes.Tickets.Ticket;
import Classes.TicketDatenbank;
import Classes.Ticketzustaende.Normalticket_Zustand;
import Interfaces.TicketZustandIF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    private Ticket ticket;

    @BeforeEach
    void setUp() {
        ticket = new Ticket();
        ticket.init();
    }

    @Test
    void testBezahlen() {
        ticket.bezahlen();
        assertEquals("bezahlt", ticket.getZustand());
    }

    @Test
    void testReinfahren() {
        String result = ticket.reinfahren();
        assertEquals("<p>Sie können nicht erneut mit dem selben Ticket reinfahren.</p>", result);
    }

    @Test
    void testRausfahren() {
        String result = ticket.rausfahren();
        assertEquals("<p>Sie haben Ihr Ticket noch nicht bezahlt.</p>", result);
    }

    @Test
    void testInformationen() {
        String result = ticket.informationen();

        String erstellDatum = ticket.getErstellDatum().toString();
        String expect = "<h1>Ticket: " + ticket.getID() + "</h1>" +
                "<h2>Zustand: " + ticket.getZustand() + "</h2>" +
                "<p>Erstellt am " + erstellDatum.substring(0, 10) + " um " + erstellDatum.substring(11, 16) + " Uhr.</p>" +
                String.format("<p>Parkdauer: %.2fh</p>", ticket.berechneParkdauer());
        assertEquals(expect, result);
    }

    @Test
    void testBerechneParkdauer() {
        LocalDateTime pastDateTime = LocalDateTime.now().minusHours(2);
        ticket.setErstellDatum(pastDateTime);

        double result = ticket.berechneParkdauer();
        assertEquals(2.0, result);
    }

    @Test
    void testGetErstellDatum() {
        LocalDateTime now = LocalDateTime.now();
        ticket.setErstellDatum(now);

        LocalDateTime result = ticket.getErstellDatum();
        assertEquals(now, result);
    }

    @Test
    void testGetBezahlDatum() {
        LocalDateTime now = LocalDateTime.now();
        ticket.setBezahlDatum(now);

        LocalDateTime result = ticket.getBezahlDatum();
        assertEquals(now, result);
    }

    @Test
    void testGetID() {
        ticket.setID("ABC123");

        String result = ticket.getID();
        assertEquals("ABC123", result);
    }

    @Test
    void testGetUeberwiesen() {
        ticket.setUeberwiesen(10.5);

        double result = ticket.getUeberwiesen();
        assertEquals(10.5, result);
    }

    @Test
    void testGetZustand() {
        TicketZustandIF ticketZustand = new Normalticket_Zustand(ticket);
        ticket.setTicketZustand(ticketZustand);

        String result = ticket.getZustand();
        assertEquals("Normalticket", result);
    }

    @Test
    void testSetID() {
        ticket.setID("DEF456");

        String result = ticket.getID();
        assertEquals("DEF456", result);
    }

    @Test
    void testSetTicketZustand() {
        TicketZustandIF ticketZustand = new Normalticket_Zustand(ticket);
        ticket.setTicketZustand(ticketZustand);

        assertEquals(ticketZustand.getZustand(), ticket.getZustand());
    }

    @Test
    void testSetErstellDatum() {
        LocalDateTime now = LocalDateTime.now();
        ticket.setErstellDatum(now);

        LocalDateTime result = ticket.getErstellDatum();
        assertEquals(now, result);
    }

    @Test
    void testSetBezahlDatum() {
        LocalDateTime now = LocalDateTime.now();
        ticket.setBezahlDatum(now);

        LocalDateTime result = ticket.getBezahlDatum();
        assertEquals(now, result);
    }

    @Test
    void testToString() {
        String expected = "Ticket{" +
                "ticketZustand=" + ticket.getZustand() +
                ", ID='" + ticket.getID() + '\'' +
                ", ueberwiesen=" + ticket.getUeberwiesen() +
                ", erstellDatum=" + ticket.getErstellDatum() +
                ", bezahlDatum=" + ticket.getBezahlDatum() +
                '}';

        String result = ticket.toString();
        assertEquals(expected, result);
    }
}
