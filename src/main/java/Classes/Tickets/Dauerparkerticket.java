package Classes.Tickets;

import Classes.Parkhaus;
import Classes.Ticketzustaende.Dauerparker_Zustand;

public class Dauerparkerticket extends Ticket {

    @Override
    public void init() {
        Parkhaus.getKompletteTicketDatenbank().addticket(this);
        ticketZustand =  new Dauerparker_Zustand(this);
    }
}