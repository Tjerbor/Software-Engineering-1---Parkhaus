package Classes.Tickets;

import Classes.Parkhaus;
import Classes.Ticketzustaende.Behoerdenticket_Zustand;

public class Behoerdenticket extends Ticket {

    @Override
    public void init() {
        Parkhaus.getKompletteTicketDatenbank().addticket(this);
        ticketZustand = new Behoerdenticket_Zustand(this);
    }
}