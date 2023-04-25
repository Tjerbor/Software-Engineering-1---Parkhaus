package Servlets;

import Classes.Parkhaus;
import Classes.Ticket;
import Classes.TicketDatenbank;

import javax.naming.directory.BasicAttribute;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ticketServlet", value = "/ticket-servlet")

public class TicketServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getQueryString() != null && request.getQueryString().equals("ersatz-ticket")) {
            Ticket ticket = new Ticket(true);
            Parkhaus.getTicketDatenbank().addticket(ticket);
            response.setContentType("text/html");

            response.getWriter().write("<h1>Ticket informations</h1>");
            response.getWriter().write("<p>Typ: Ersatzticket</p>");
            response.getWriter().write("<p>Ticket ID : " + ticket.getID() + "</p><p>Entry date : " + ticket.getErstellDatum());
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Ticket ticket = new Ticket();
        Parkhaus.getTicketDatenbank().addticket(ticket);


        response.setContentType("text/html");

        response.getWriter().write("<h1>Ticket informations</h1>");
        response.getWriter().write("<p>Ticket ID : " + ticket.getID() + "</p><p>Entry date : " + ticket.getErstellDatum());

    }
}
