package Servlets;

import Classes.*;
import Classes.Tickets.Ticket;

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title style=\"color: purple;\">Zum Kassenautomaten</title>");
        out.println("<style>");
        out.println("body { background-color: #fff5d7; text-align: center; font-family: Arial, sans-serif; }");
        out.println("h1 { color: purple; font-size: 24px; }");
        out.println("form { display: flex; flex-direction: column; align-items: center; }");
        out.println("label { font-size: 18px; }");
        out.println("input[type='text'] { margin-bottom: 10px; padding: 5px; font-size: 16px; }");
        out.println("input[type='submit'] { padding: 5px 15px; font-size: 16px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
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
        String action = request.getParameter("bezahlen");

        if (id != null) {
            servCon.setAttribute("ticketID", id);
        }

        TicketDatenbank datenbank = Parkhaus.getKompletteTicketDatenbank();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        String ticketID = (String) servCon.getAttribute("ticketID");

        if (ticketID != null && datenbank.containsTicket(ticketID)) {
            Ticket ticket = datenbank.getTicket(ticketID);

            if (action == null) {
                String outt = ticket.kassenautomatenText();
                out.println(outt);
            } else {
                servCon.setAttribute("ticketID", null);
                String outt = ticket.bezahlen();
                out.println(outt);
            }

        } else {
            out.println("<h1>Ticket jibbit nicht.</h1>");
        }

        out.println("</body></html>");
    }

    public void destroy() {

    }
}
