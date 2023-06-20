package Classes.Ticketzustaende;

import Classes.Ticket;
import Interfaces.TicketZustandIF;

public abstract class TicketZustand implements TicketZustandIF {

    protected String zustand;
    protected Ticket parent;

    public TicketZustand(Ticket parent) {
        this.parent = parent;
    }

    @Override
    public String KassenautomatenText() {
        throw new IllegalStateException();
    }

    @Override
    public String bezahlen() {
        throw new IllegalStateException();
    }

    @Override
    public String rausfahren() {
        throw new IllegalStateException();
    }

    @Override
    public String informationen() {
        throw new IllegalStateException();
    }

    @Override
    public Ticket getParent() {
        return parent;
    }

    @Override
    public String getZustand() {
        return zustand;
    }
}
