import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class platzTest {

    @Test
    void freiplatz() {

        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket();
        Ticket t3 = new Ticket();

        int frei = platz.freiplatz();

        System.out.println("Frei Plätze Nummer" + frei);


    }
}