package Servlets;

import Classes.*;
import Exceptions.RaumZeitKontinuumException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "kassenautomatServlet", value = "/kassenautomat")
public class KassenautomatServlet extends HttpServlet {

    private String ticketID;

    public void init() {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        out.println("<h1>Hallo lieber Kunde, bitte geben Sie ihr Ticket an.</h1>");
        out.println("<form action=\"kassenautomat\" method=\"post\">\n" +
                "    <label for=\"ticketID\">Ticket ID:</label>\n" +
                "    <input type=\"text\" id=\"ticketID\" name=\"ticketID\"><br><br>\n" +
                "    <input type=\"submit\" value=\"Submit\">\n" +
                "</form>");


        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servCon = getServletContext();
        String id = request.getParameter("ticketID");
        if (id != null) {
            servCon.setAttribute("tID", id);
        }
        String geld = request.getParameter("geld");


        TicketDatenbank datenbank = Parkhaus.getTicketDatenbank();


        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        ticketID = (String) servCon.getAttribute("tID");
        if (ticketID != null && datenbank.containsTicket(ticketID)) {
            Ticket ticket = datenbank.getTicket(ticketID);
            String Zustand = ticket.getZustand();

            out.println("<h1>Ticket: " + ticketID + "</h1>");
            out.println("<h2>Zustand: " + Zustand + "</h2>");
            String erstellDatum = ticket.getErstellDatum().toString();
            out.println("<p>Erstellt am " + erstellDatum.substring(0, 10) + " um " + erstellDatum.substring(11, 16) + " Uhr.</p>");
            out.println(String.format("<p>Parkdauer: %.2fh</p>", ticket.berechneParkdauer()));


            if (Zustand.equals("bezahlt")) {
                String bezahlDatum = ticket.getBezahlDatum().toString();
                out.println("<p>Bezahlt am " + bezahlDatum.substring(0, 10) + " um " + bezahlDatum.substring(11, 16) + " Uhr.</p>");
                servCon.setAttribute("tID", null);
                out.println("<h4>Das Ticket wurde bezahlt. Bitte verlassen Sie das Parkhaus.</h4>");

            } else if (Zustand.equals("erstellt") || Zustand.equals("Nachzahlung")) {
                if (geld != null) {
                    Double Geld = Double.parseDouble(geld);
                    if (Geld != 0.0) {
                        Kassenautomat.bezahle(ticket, Geld);
                    }
                }

                double Bezahlt = ticket.getUeberwiesen();
                double preis = Preis.getPreis(ticket) - ticket.getUeberwiesen();
                out.println(String.format("<p>Zu zahlender Betrag: %.2f Euro</p>",round2Decimals(preis)));

                if (Bezahlt != 0.0) {
                    if (Bezahlt < preis) {
                        out.println(String.format("<h4>Sie haben bereits %.2f Euro bezahlt. Es fehlen noch %.2f Euro, um das Ticket zu bezahlen.</h4>", round2Decimals(Bezahlt), round2Decimals(preis - Bezahlt)));
                    } else {
                        out.println(String.format("<h4>Sie haben zu viel bezahlt. Bitte buchen Sie -%.2f Euro wieder ab.</h4>", round2Decimals(Bezahlt - preis)));
                    }
                }

                out.println("<form action=\"kassenautomat\" method=\"post\">\n" +
                        "    <label for=\"geld\">Geld:</label>\n" +
                        "    <input type=\"text\" id=\"geld\" name=\"geld\"><br><br>\n" +
                        "    <input type=\"submit\" value=\"Submit\">\n" +
                        "</form>");
            }

        } else {
            out.println("<h1>Ticket jibbit nicht.</h1>");
        }

        out.println("</body></html>");

    }

    private static double round2Decimals(double input) {
        return ((double) ((int) ((input * 100) + 0.5))) / 100;
    }

    public void destroy() {

    }
}
