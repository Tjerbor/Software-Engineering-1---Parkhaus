package Classes.Tickets;

import Classes.Parkhaus;
import Classes.Ticketzustaende.Mitarbeiterticket_Zustand;

public class Mitarbeiterticket extends Ticket{

    @Override
    public void init() {
        Parkhaus.getKompletteTicketDatenbank().addticket(this);
        ticketZustand = new Mitarbeiterticket_Zustand(this);
    }
}
