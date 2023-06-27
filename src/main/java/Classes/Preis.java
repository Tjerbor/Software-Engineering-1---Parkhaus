package Classes;

import Classes.Tickets.Ticket;

public class Preis {
     public static double standart_stundenpreis =2.3;
     public static double standart_Tagespreis =27.0;
    private static double Stundenpreis = 2.3;
    private static double Tagespreis = 27.0;

    public static double getPreis(Ticket ticket) {
        double parkdauer = ticket.berechneParkdauer(); //in Stunden
        double preis = parkdauer * Stundenpreis;
        return preis > Tagespreis ? Tagespreis : preis;
    }

    public static double getStundenpreis() {
        return Stundenpreis;
    }

    public static double getTagespreis() {
        return Tagespreis;
    }

    public static void setStundenpreis(double stundenpreis) {
        Stundenpreis = stundenpreis;
    }

    public static void setTagespreis(double tagespreis) {
        Tagespreis = tagespreis;
    }
}
