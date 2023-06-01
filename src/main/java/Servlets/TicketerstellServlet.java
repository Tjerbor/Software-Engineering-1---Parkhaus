package Servlets;

import Classes.*;

import javax.naming.directory.BasicAttribute;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ticketerstellServlet", value = "/ticketerstell-servlet")
public class TicketerstellServlet extends HttpServlet {
    TicketDatenbank ticketdatenbank = Parkhaus.getTicketDatenbank();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Create a ticket" + "</h1>");
        out.println("<form action=\"ticket-servlet\" method=\"post\">\n" +
                "    <label for=\"id\">New ticket  :</label>" +
                "    <input type=\"submit\" value=\"Submit\">\n" +
                "</form>");
        //TicketDatenbank ticketdatenbank = Parkhaus.getTicketDatenbank();

        // Preise werden ausgegeben
        out.println("<p>The current number of cars = " + Autozaehler.getAutoanzahl());
        out.println("<p>The price per hour = " + Preis.getStundenpreis() + "<p>The price per day = " + Preis.getTagespreis());

        //Parameter für Benutzernamen und Passwort abrufen
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //Überprüfung, ob Benutzername und Passwort korrekt sind
        if (username.equals("admin") && password.equals("admin7")) {
            //Admin eingeloggt
            response.setContentType("text/html");
            out.println("<html>");
            out.println("<head><title>Admin Console</title></head>");
            out.println("<body>");
            out.println("<h1>Admin Console</h1>");
            out.println("<p>You are logged in as admin.</p>");
            out.println("<a href=\"ticket-servlet?ersatz-ticket\">Erstelle Ersatzticket<a>");
            out.println("</body></html>");

        } else {
            //Falsche Zugangsdaten
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "ungültige username oder passwort");
        }

        out.println("</body></html>");
    }


    //post methode zur Erstellung eines Ersatztickets
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //Parameter für Ticket-ID und Erstellungsdatum abrufen
        //String ticketId = request.getParameter("ticketId");
        //String creationDate = request.getParameter("creationDate");

        //Überprüfung, ob Ersatzticket in Datenbank verfügbar ist, maxAutoAnzahl im Parkhaus = 1000 voraussichtlich
        if (ticketdatenbank.getTicketanzahl() < 1000) {
            //Ersatzticket erstellen und in Datenbank einfügen  & Ersatzticket aus Datenbank entnehmen

            Ticket ersatzTicket = ticketdatenbank.getTicket(new Ticket(true).getID());

            // Antwort zurücksenden
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head><title>Replacement Ticket Created</title></head>");
            out.println("<body>");
            out.println("<h1>Replacement Ticket Created</h1>");
            out.println("<p>Your replacement ticket has been created with the following details:</p>");
            out.println("<ul>");
            out.println("<li>Ticket ID: " + ersatzTicket.getID() + "</li>");
            out.println("<li>Creation Date: " + ersatzTicket.getErstellDatum() + "</li>");
            out.println("</ul>");
            out.println("</body></html>");
        } else {
            // Kein Ticket verfügbar
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "No tickets available.");
        }


    }


    public void destroy() {
    }
}