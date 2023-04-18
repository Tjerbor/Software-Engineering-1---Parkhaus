import java.util.ArrayList;
import java.util.List;

public class TicketDatenbank {

    private List<Ticket> ticketdatenbank ;

    public TicketDatenbank(List<Ticket> ticketdatenbank) {
        this.ticketdatenbank = new ArrayList<Ticket>();;
    }

    public void addticket (Ticket ticket){
        ticketdatenbank.add(ticket);
    }
}
