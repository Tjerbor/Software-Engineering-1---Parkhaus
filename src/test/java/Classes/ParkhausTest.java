package Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkhausTest {

    private Parkhaus parkhaus;

    @BeforeEach
    void setUp() {
        parkhaus = new Parkhaus();
    }

    @Test
    void testGetTicketDatenbank() {
        TicketDatenbank ticketDatenbank = parkhaus.getTicketDatenbank();
        assertNotNull(ticketDatenbank);
    }

    @Test
    void testSetTicketDatenbank() {
        TicketDatenbank ticketDatenbank = new TicketDatenbank();
        parkhaus.setTicketDatenbank(ticketDatenbank);
        assertEquals(ticketDatenbank, parkhaus.getTicketDatenbank());
    }
}
