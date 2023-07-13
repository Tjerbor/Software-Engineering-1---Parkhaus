package Servlets;

import Classes.Kassenautomat;
import Classes.Parkhaus;
import Classes.Statistik;
import Classes.TicketDatenbank;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@WebServlet(name = "statistikServlet", value = "/statistik")
public class StatistikServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title style=\"color: purple;\">Statistik des Parkhauses</title>");
        out.println("<style>");
        out.println("body { text-align: center; font-family: Arial, sans-serif; background-color: #fff5d7; }");
        out.println("h1 { color: purple; font-size: 24px; }");
        out.println("form { display: flex; flex-direction: column; align-items: center; margin-top: 20px; }");
        out.println("label { font-size: 18px; }");
        out.println("input[type='datetime-local'] { margin-bottom: 10px; }");
        out.println("input[type='submit'] { font-size: 16px; padding: 5px 10px; }");
        out.println("h3 { color: purple; font-size: 20px; }");
        out.println("p { font-size: 18px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Statistik des Parkhauses</h1>");
        out.println("<form action=\"statistik\" method=\"post\">");
        out.println("<label for=\"start\">Startzeitpunkt:</label>");
        out.println("<input type=\"datetime-local\" id=\"start\" name=\"start\"><br><br>");
        out.println("<label for=\"end\">Endzeitpunkt:</label>");
        out.println("<input type=\"datetime-local\" id=\"end\" name=\"end\"><br><br>");
        out.println("<input type=\"submit\" value=\"Statistik anzeigen\">");
        out.println("</form>");

        out.println("</body>");
        out.println("</html>");
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startString = request.getParameter("start");
        String endString = request.getParameter("end");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime start = LocalDateTime.parse(startString.replace("T", " "),formatter);
        LocalDateTime end = LocalDateTime.parse(endString.replace("T", " "),formatter);

        int auslastung = Parkhaus.getUmsatzTicketDatenbank().getTicketanzahl();
        double einnahmen;
        einnahmen = Statistik.berechneEinnahmen(start, end);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Statistik des Parkhauses</h1>");
        out.println("<h3>Auslastung von " + startString + " bis " + endString + "</h3>");
        out.println("<p>Anzahl der belegten Parkplätze: " + auslastung + "</p>");
        out.println("<h3>Einnahmen von " + startString + " bis " + endString + "</h3>");
        out.println("<p>Gesamteinnahmen: " + Kassenautomat.round2Decimals(einnahmen) + " Euro</p>");
        out.println("</body></html>");
    }
}