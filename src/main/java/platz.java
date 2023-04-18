public class platz {

    protected static final int MAX_ANZAHL_TICKET = 100;
    public static int freiplatz(){
        return MAX_ANZAHL_TICKET - Ticket.getAnzahlTicket();
    }
}
