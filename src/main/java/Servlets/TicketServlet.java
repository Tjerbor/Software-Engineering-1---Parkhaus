package Servlets;

import Classes.Tickets.Ersatzticket;
import Classes.Parkhaus;
import Classes.Tickets.Ticket;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ticketServlet", value = "/ticket-servlet")

public class TicketServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getQueryString() != null && request.getQueryString().equals("ersatz-ticket")) {
            Ticket ticket = new Ersatzticket();
            Parkhaus.getTicketDatenbank().addticket(ticket);
            response.setContentType("text/html");

            response.getWriter().write(ticket.informationen());
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Ticket ticket = new Ticket();
        Parkhaus.getTicketDatenbank().addticket(ticket);

        response.setContentType("text/html");
        response.getWriter().write(ticket.informationen());

    }
}
