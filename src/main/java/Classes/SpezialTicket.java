package Classes;

import Classes.Ticket;
import Classes.TicketDatenbank;

import java.time.LocalDateTime;
public class SpezialTicket {
    private TicketDatenbank ticketdatenbank;

    private static int autoCount = 0;

    public SpezialTicket() {
        autoCount++;

    }

    public static int  getAutoCount(){
        return autoCount;

    }

    public static void setAutoCount(int autoCount){

    }

    public Ticket lostTicket(){

        return new Ticket(true);
    }

    public void addticketDatabase (Ticket ticket){
        ticketdatenbank.addticket(ticket);

    }


}

