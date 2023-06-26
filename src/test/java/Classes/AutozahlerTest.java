package Classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutozahlerTest {

    private Autozaehler autozaehler;

    @BeforeEach
    void setUp() {
        autozaehler = new Autozaehler();
    }

    @Test
    void testGetAutoanzahl() {
        assertEquals(0, autozaehler.getAutoanzahl());
    }

    @Test
    void testVeraendereAnzahl() {
        autozaehler.veraendereAnzahl(5);
        assertEquals(5, autozaehler.getAutoanzahl());
    }

    @Test
    void testVeraendereAnzahlWithNegativeDelta() {
        assertThrows(IllegalArgumentException.class, () -> autozaehler.veraendereAnzahl(-5));
    }

    @Test
    void testErhoeheAnzahl() {
        autozaehler.erhoeheAnzahl();
        assertEquals(1, autozaehler.getAutoanzahl());
    }

    @Test
    void testVerringereAnzahl() {
        autozaehler.veraendereAnzahl(5); // Setzt die Autoanzahl auf 5
        autozaehler.verringereAnzahl();
        assertEquals(4, autozaehler.getAutoanzahl());
    }

    @Test
    void testVerringereAnzahlWhenZero() {
        assertThrows(IllegalStateException.class, Autozaehler::verringereAnzahl);
    }
}
