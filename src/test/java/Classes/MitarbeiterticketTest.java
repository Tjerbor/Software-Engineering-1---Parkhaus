package Classes;

import Classes.Tickets.Mitarbeiterticket;
import Classes.Ticketzustaende.Mitarbeiterticket_Zustand;
import Exceptions.RaumZeitKontinuumException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MitarbeiterticketTest {

    private Mitarbeiterticket mitarbeiterticket;

    @BeforeEach
    public void setUp() throws RaumZeitKontinuumException {
        Parkhaus.reset();
        mitarbeiterticket = new Mitarbeiterticket();
        Parkhaus.getKompletteTicketDatenbank().bereinigeDatenbank(); // Ticketdatenbank zurücksetzen
    }

    @Test
    public void testInit() {
        assertEquals(0, Parkhaus.getKompletteTicketDatenbank().getTicketanzahl());

        mitarbeiterticket.init();

        assertEquals(1, Parkhaus.getKompletteTicketDatenbank().getTicketanzahl());

    }
}