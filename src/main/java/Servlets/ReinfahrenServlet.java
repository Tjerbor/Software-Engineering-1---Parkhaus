package Servlets;

import Classes.Parkhaus;
import Classes.TicketDatenbank;
import Classes.Tickets.Ticket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "reinfahrenServlet", value = "/reinfahren-servlet")
public class ReinfahrenServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");

        out.println("<h1>Hallo lieber Kunde, bitte geben Sie ihr Ticket an.</h1>");
        out.println("<form action=\"reinfahren-servlet\" method=\"post\">\n" +
                "    <label for=\"ticketID\">Ticket ID:</label>\n" +
                "    <input type=\"text\" id=\"ticketID\" name=\"ticketID\"><br><br>\n" +
                "    <input type=\"submit\" value=\"Submit\">\n" +
                "</form>");


        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Id = req.getParameter("ticketID");

        TicketDatenbank db = Parkhaus.getKompletteTicketDatenbank();
        Ticket ticket = null;
        if (Id != null && db.containsTicket(Id)) {
            ticket = db.getTicket(Id);
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Reinfahrenservlet</h1>");

        if (ticket != null) {
            resp.setContentType("text/html");

            out.println(ticket.reinfahren());

        } else {
            out.println("<h1>Ticket jibbit nicht.</h1>");
        }
        out.println("</body></html>");
    }
}
