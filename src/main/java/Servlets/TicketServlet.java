package Servlets;

import Classes.Tickets.*;
import Classes.Parkhaus;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ticketServlet", value = "/ticket-servlet")

public class TicketServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Ticket ticket = null;
        if (request.getQueryString() != null && request.getQueryString().equals("normal-ticket")) {
            ticket = new Ticket();
        } else if (request.getQueryString() != null && request.getQueryString().equals("ersatz-ticket")) {
            ticket = new Ersatzticket();
        } else if (request.getQueryString() != null && request.getQueryString().equals("behoerden-ticket")) {
            ticket = new Behoerdenticket();
        } else if (request.getQueryString() != null && request.getQueryString().equals("dauerparker-ticket")) {
            ticket = new Dauerparkerticket();
        } else if (request.getQueryString() != null && request.getQueryString().equals("mitarbeiter-ticket")) {
            ticket = new Mitarbeiterticket();
        }
        ticket.init();
        response.setContentType("text/html");
        response.getWriter().write(ticket.informationen());

    }
}
