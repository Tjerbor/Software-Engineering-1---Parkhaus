package Servlets;

import Classes.*;
import Classes.Tickets.Ersatzticket;
import Classes.Tickets.Ticket;

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
        out.println("<h1>" + "Ein Ticket ziehen" + "</h1>");
        out.println("<form action=\"ticket-servlet\" method=\"post\">\n" +
                "    <label for=\"id\">Neues Ticket  :</label>" +
                "    <input type=\"submit\" value=\"Ziehen\">\n" +
                "</form>");
        //TicketDatenbank ticketdatenbank = Parkhaus.getTicketDatenbank();

        // Preise werden ausgegeben
        out.println("<p>Zurzeitige Anzahl von Autos: " + Autozaehler.getAutoanzahl() + "</p>");
        out.println("<p>Frei verfügbare Parkplätze: " + Parkhaus.getOffizielFreieParkplaetze() + "</p>");
        out.println("<p>Preis pro Stunde: " + Preis.getStundenpreis() + " Euro</p>");
        out.println("<p>Preis pro Tag: " + Preis.getTagespreis() + " Euro</p>");

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

            Ticket ersatzTicket = ticketdatenbank.getTicket(new Ersatzticket().getID());

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