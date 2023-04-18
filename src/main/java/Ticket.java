import java.time.LocalDateTime;

public class Ticket {
   private boolean status ;
   private LocalDateTime eingangsdatum ;
   private LocalDateTime bezahldatum ;

   protected static final int MAX_ANZAHL_TICKET = 100;

   private static int anzahlTicket;

    private int count = 0;

//    Ticket[] array = new Ticket[MAX_ANZAHL_TICKET]

    public Ticket (){
       this.eingangsdatum = LocalDateTime.now();
       // Setzt die Eingangszeit auf die aktuelle Datum und Uhrzeit;
       this.status = false ;
       setAnzahlTicket(count++);
   }

    public boolean isStatus() {
        return status;
    }

    public LocalDateTime getEingangsdatum() {
        return eingangsdatum;
    }

    public LocalDateTime getBezahldatum() {
        return bezahldatum;
    }


    public static int getAnzahlTicket(){
       return anzahlTicket;

    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setBezahldatum(LocalDateTime bezahldatum) {
        this.bezahldatum = bezahldatum;
    }

    public void setEingangsdatum(LocalDateTime eingangsdatum) {
        this.eingangsdatum = eingangsdatum;
    }

    public void setAnzahlTicket(int ticket){
       anzahlTicket = ticket;
    }

}
