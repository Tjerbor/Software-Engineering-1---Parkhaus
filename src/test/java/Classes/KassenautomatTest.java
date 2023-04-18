package Classes;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class KassenautomatTest {

    @Test
    void isBezahleTest() {

        Ticket ticket = new Ticket();
        ticket.setBezahlt(false);
        ticket.berechneParkdauer();
        Kassenautomat kassenautomat = new Kassenautomat();
        kassenautomat.bezahle(ticket, 27);
        assertTrue(ticket.isBezahlt());
    }
    @Test
    void isNotBezahleTest() {

        Ticket ticket = new Ticket();
        ticket.setBezahlt(false);
        ticket.setErstellDatum(LocalDateTime.of(2023, 4,17,12,4));
        ticket.berechneParkdauer();
        Kassenautomat kassenautomat = new Kassenautomat();
        assertThrows(IllegalArgumentException.class, () -> kassenautomat.bezahle(ticket, 20));

    }
}