package Servlets;

import Classes.Parkhaus;
import Classes.Tickets.Ticket;
import Classes.TicketDatenbank;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

    @WebServlet(name = "verlassenServlet", value = "/verlassen-servlet")
    public class VerlassenServlet extends HttpServlet {
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();

            out.println("<html>");
            out.println("<head>");
            out.println("<title style=\"color: purple;\">Verlassen Servlet</title>");
            out.println("<style>");
            out.println("body { background-color: #fff5d7; text-align: center; font-family: Arial, sans-serif; }");
            out.println("h1 { color: purple; font-size: 24px; }");
            out.println("form { display: flex; flex-direction: column; align-items: center; margin-top: 20px; }");
            out.println("input[type='text'] { margin-bottom: 10px; font-size: 16px; }");
            out.println("input[type='submit'] { font-size: 16px; }");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");

            out.println("<h1>Hallo lieber Kunde, bitte geben Sie Ihr Ticket ab.</h1>");
            out.println("<form action=\"verlassen-servlet\" method=\"post\">\n" +
                    "    <label for=\"TicketID\">TicketID: \n" +
                    "    <input type=\"text\" id=\"TicketID\" name=\"TicketID\"><br><br>\n" +
                    "    <input type=\"submit\" value=\"Submit\">\n" +
                    "</form>");

            out.println("</body>");
            out.println("</html>");
        }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Id = request.getParameter("TicketID");

        TicketDatenbank db = Parkhaus.getKompletteTicketDatenbank();
        Ticket ticket = null;
        if (Id != null && db.containsTicket(Id)) {
            ticket = db.getTicket(Id);
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>verlassenServlet</h1>");

        if (ticket != null) {
            String outt = ticket.rausfahren();
            System.out.println(outt);
            out.println(outt);

        } else {
            out.println("<h1>Ticket jibbit nicht.</h1>");
        }
        out.println("</body></html>");

    }

}