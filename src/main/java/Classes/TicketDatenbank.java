package Classes;

import Interfaces.TicketDatenbankIF;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class TicketDatenbank implements TicketDatenbankIF {


    public static int time_offset = 0;


    private List<Ticket> ticketDatenbank;

    public TicketDatenbank(List<Ticket> ticketdatenbank) {
        this.ticketDatenbank = new ArrayList<Ticket>();
    }

    public TicketDatenbank() {
        this(new ArrayList<Ticket>());
    }

    @Override
    public void addticket(Ticket ticket) {
        ticketDatenbank.add(ticket);
    }

    @Override
    public void addErsatzTicket() {
        ticketDatenbank.add(new Ticket(true));
    }

    public Ticket getTicket(String ticketID) throws NoSuchElementException {
        for (Ticket t : ticketDatenbank) {
            if (t.getID().equals(ticketID)) {
                return t;
            }
        }
        throw new NoSuchElementException(String.format("Ticket with ID: %s does not exist.", ticketID));
    }

    public boolean containsTicket(String ticketID) {
        for (Ticket t : ticketDatenbank) {
            if (t.getID().equals(ticketID)) {
                return true;
            }
        }
        return false;
    }

    public Ticket removeTicket(String ticketID) throws NoSuchElementException {
        for (int i = 0; i < ticketDatenbank.size(); i++) {
            Ticket current = ticketDatenbank.get(i);
            if (current.getID().equals(ticketID)) {
                Autozaehler.verringereAnzahl();
                return ticketDatenbank.remove(i);
            }
        }
        throw new NoSuchElementException(String.format("Ticket with ID: %s does not exist.", ticketID));
    }

    public int getTicketanzahl() {
        return ticketDatenbank.size();
    }

    /**
     * Löscht Tickets die älter als 6 Monate sind.
     */
    @Override
    public void bereinigeDatenbank() {
        int index = 0;
        while (index < ticketDatenbank.size()) {
            Ticket current = ticketDatenbank.get(index);
            if (current.berechneParkdauer() >= 4392) { //6 Monate sind 4392 Stunden
                ticketDatenbank.remove(index);
            } else {
                index++;
            }
        }
    }
    private static LocalDateTime addTime(LocalDateTime original, int delta) {
        LocalDateTime result = original;


       //*** if (delta.getYear() != 0) {
        //  result = result.plusYears(delta.getYear());
        //  }
    //if (delta.getDayOfYear() != 0) {
        //  result = result.plusDays(delta.getDayOfYear());
        //  }
    //if (delta.getMonthValue() != 0) {
        //  result = result.plusMonths(delta.getMonthValue());
        //  }
    //if (delta.getHour() != 0) {
        //  result = result.plusHours(delta.getHour());
        //  }
    //if (delta.getMinute() != 0) {
        //  result = result.plusMinutes(delta.getMinute());
        //  }
    //if (delta.getSecond() != 0) {
        //  result = result.plusSeconds(delta.getSecond());
        //  }
    //return result;
        return result.plusMinutes(delta);
    }

    public static void addTime_offset(int delta) {
        time_offset =time_offset+delta;
    }

    public static LocalDateTime getParkhausTime(){
        return addTime(LocalDateTime.now(),time_offset);
    }



}
