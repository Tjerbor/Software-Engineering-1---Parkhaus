package Servlets;

import Classes.Autozaehler;
import Classes.Parkhaus;
import Classes.Preis;
import Classes.TicketDatenbank;

import javax.naming.directory.BasicAttribute;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ticketerstelServelt", value = "/Ticketerstel-Servelt")
public class TicketerstellServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Create a ticket" + "</h1>");
        out.println("<form action=\"Ticket-Servelt\" method=\"post\">\n" +
                "    <label for=\"id\">New ticket  :</label>" +
                "    <input type=\"submit\" value=\"Submit\">\n" +
                "</form>");
        TicketDatenbank ticketdatenbank = Parkhaus.getTicketDatenbank();

        // Preise werden ausgegeben
        out.println("<p>The current number of cars = " + Autozaehler.getAutoanzahl());
        out.println("<p>The price per hour = " + Preis.getStundenpreis() + "<p/><p>The price per day = " + Preis.getTagespreis());


        out.println("</body></html>");


        out.println("</body></html>");
    }


    public void destroy() {
    }
}