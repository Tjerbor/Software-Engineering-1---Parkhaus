package Classes;

public class Kassenautomat {


   // public static void bezahle(Ticket ticket, double geld) {
        //double preis = Preis.getPreis(ticket);
       // double diff = geld + ticket.getUeberwiesen();

       // ticket.setUeberwiesen(diff);
    //}

    public static double round2Decimals(double input) {
        return ((double) ((int) ((input * 100) + 0.5))) / 100;
    }

}
