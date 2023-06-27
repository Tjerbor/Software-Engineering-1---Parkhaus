package Servlets;

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

@WebServlet(name = "statistikServlet", value = "/statistik")
public class StatistikServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Statistik des Parkhauses</h1>");
        out.println("<form action=\"statistik\" method=\"post\">");
        out.println("<label for=\"start\">Startzeitpunkt:</label>");
        out.println("<input type=\"datetime-local\" id=\"start\" name=\"start\"><br><br>");
        out.println("<label for=\"end\">Endzeitpunkt:</label>");
        out.println("<input type=\"datetime-local\" id=\"end\" name=\"end\"><br><br>");
        out.println("<input type=\"submit\" value=\"Statistik anzeigen\">");
        out.println("</form>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String startString = request.getParameter("start");
        String endString = request.getParameter("end");

        LocalDateTime start = LocalDateTime.parse(startString.replace("T", " "));
        LocalDateTime end = LocalDateTime.parse(endString.replace("T", " "));

        int auslastung = Parkhaus.getKompletteTicketDatenbank().getTicketanzahl();
        double einnahmen;
        einnahmen = Statistik.berechneEinnahmen(start, end);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h1>Statistik des Parkhauses</h1>");
        out.println("<h3>Auslastung von " + startString + " bis " + endString + "</h3>");
        out.println("<p>Anzahl der belegten Parkplätze: " + auslastung + "</p>");
        out.println("<h3>Einnahmen von " + startString + " bis " + endString + "</h3>");
        out.println("<p>Gesamteinnahmen: " + einnahmen + " Euro</p>");
        out.println("</body></html>");
    }
}