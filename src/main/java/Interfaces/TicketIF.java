package Interfaces;

import java.time.LocalDateTime;

public interface TicketIF {
    double berechneParkdauer();

    boolean isErsatzTicket();

    LocalDateTime getErstellDatum();

    LocalDateTime getBezahlDatum();
}
