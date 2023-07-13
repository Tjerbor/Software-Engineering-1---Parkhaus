package Servlets;

import Classes.Tickets.*;
import Classes.Parkhaus;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ticketServlet", value = "/ticket-servlet")
public class TicketServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title style=\"color: purple;\">Ticket Servlet</title>");
        out.println("<style>");
        out.println("body { text-align: center; font-family: Arial, sans-serif; background-color: #fff5d7; }");
        out.println("h1 { color: purple; font-size: 24px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        try {
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
            String outt = ticket.informationen();
            out.println(outt);
        } catch (Exception e) {
            out.println("<h1>" + e.getMessage() + "</h1>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}
