package Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkhausTest {

    private Parkhaus parkhaus = new Parkhaus();

    @BeforeEach
    void setUp() {
    }

    @Test
    void testGetTicketDatenbank() {
        TicketDatenbank ticketDatenbank = parkhaus.getKompletteTicketDatenbank();
        assertNotNull(ticketDatenbank);
    }

    @Test
    void testSetTicketDatenbank() {
        TicketDatenbank ticketDatenbank = new TicketDatenbank();
        parkhaus.setKompletteTicketDatenbank(ticketDatenbank);
        assertEquals(ticketDatenbank, parkhaus.getKompletteTicketDatenbank());
    }
}
