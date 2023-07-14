package Servlets;

import Classes.Autozaehler;
import Classes.Parkhaus;
import Classes.Preis;
import Classes.TicketDatenbank;
import Classes.Tickets.Ticket;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResetServlet", value = "/Reset")
public class Reset extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title style=\"color: purple;\">Reset Servlet</title>");
        out.println("<style>");
        out.println("body { text-align: center; font-family: Arial, sans-serif; background-color: #fff5d7; }");
        out.println("h1 { color: purple; font-size: 24px; }");
        out.println("form { display: flex; justify-content: center; margin-top: 20px; }");
        out.println("input[type='submit'] { font-size: 16px; padding: 10px 20px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<form action=\"Reset\" method=\"post\">\n" +
                "    <input type=\"submit\" value=\"Reset\">\n" +
                "</form>");

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Parkhaus.reset();
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title style=\"color: purple;\">Reset Servlet</title>");
        out.println("<style>");
        out.println("body { text-align: center; font-family: Arial, sans-serif; background-color: #fff5d7; }");
        out.println("h1 { color: purple; font-size: 24px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Das Parkhaus wurde erfolgreich zurückgesetzt.</h1>");
        out.println("<h1><a href=\"http://localhost:8080/Team_6_sose23_war_exploded/\"><button class=\"button-medium\">Zum Hauptmenu</button></a></h1>");

        out.println("</body>");
        out.println("</html>");
    }

}
