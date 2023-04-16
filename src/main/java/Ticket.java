import java.time.LocalDateTime;

public class Ticket {
   private boolean status ;
   private LocalDateTime eingangsdatum ;
   private LocalDateTime bezahldatum ;

   public Ticket (){
       this.eingangsdatum = LocalDateTime.now();
       // Setzt die Eingangszeit auf die aktuelle Datum und Uhrzeit;
       this.status = false ;
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

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setBezahldatum(LocalDateTime bezahldatum) {
        this.bezahldatum = bezahldatum;
    }

    public void setEingangsdatum(LocalDateTime eingangsdatum) {
        this.eingangsdatum = eingangsdatum;
    }
}
