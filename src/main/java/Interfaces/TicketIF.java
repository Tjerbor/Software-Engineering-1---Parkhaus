package Interfaces;

import java.time.LocalDateTime;

public interface TicketIF {
    double berechneParkdauer();
    boolean isBezahlt();
    boolean isErsatzTicket();
    LocalDateTime getErstellDatum();
    LocalDateTime getBezahlDatum();
    void setBezahlt(boolean bezahlt);
}
