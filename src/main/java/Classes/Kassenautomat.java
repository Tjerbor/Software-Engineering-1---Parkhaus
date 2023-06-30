package Classes;

import Classes.Tickets.Ticket;

public class Kassenautomat {

private Kassenautomat(){}
    //public static void bezahle(Ticket ticket, double geld) {
     //   double diff = geld + ticket.getUeberwiesen();

     //   ticket.setUeberwiesen(diff);
   // }

    public static double round2Decimals(double input) {
        return ((double) ((int) ((input * 100) + 0.5))) / 100;
    }

}
