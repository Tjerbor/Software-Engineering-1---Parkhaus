package Classes;

import Classes.Tickets.Behoerdenticket;
import Exceptions.RaumZeitKontinuumException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BehoerdenTicketTest {

    private Behoerdenticket behoerdenticket;

    @BeforeEach
    void setUp() throws RaumZeitKontinuumException {
        behoerdenticket = new Behoerdenticket();
        Parkhaus.getKompletteTicketDatenbank().bereinigeDatenbank();
    }

    @Test
    void testInit() {
        behoerdenticket.init();

        // Test if the ticket is added to the complete ticket database
        assertTrue(Parkhaus.getKompletteTicketDatenbank().containsTicket(behoerdenticket.getID()));

    }
}