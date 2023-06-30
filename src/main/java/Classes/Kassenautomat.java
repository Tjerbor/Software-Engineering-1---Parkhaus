package Classes;


public class Kassenautomat {

private Kassenautomat(){}

    public static double round2Decimals(double input) {
        return ((double) ((int) ((input * 100) + 0.5))) / 100;
    }

}
