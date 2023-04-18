package Classes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutozaehlerTest {

    @Test
    void erhoeheAnzahlTest() {
        Ticket ticket = new Ticket();
        assertEquals(1, Ticket.getAutoAnzahl());
        Ticket ticket1 = new Ticket();
        assertEquals(2, Ticket.getAutoAnzahl());

    }
}