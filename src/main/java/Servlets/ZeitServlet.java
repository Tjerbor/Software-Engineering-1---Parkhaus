package Servlets;

import Classes.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "ZeitServlet", value = "/Zeit-servlet")
public class ZeitServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<h1>Zeit Servlet</h1>");

        out.println("<form action=\"Zeit-servlet\" method=\"post\">\n" +
                "    <input type=\"submit\" name=\"button\" value=\"+5 Minuten\">\n" +
                "    <input type=\"submit\" name=\"button\" value=\"+10 Minuten\">\n" +
                "    <input type=\"submit\" name=\"button\" value=\"+1 Stunde\">\n" +
                "</form>");
        out.println("<form action=\"Zeit-servlet\" method=\"post\">\n" +
                "    <label for=\"Reset\">Parkhaus zurücksetzen \n" +
                "    <input type=\"submit\" name=\"button\"value=\"Reset\">\n" +
                "</form>");


        LocalDateTime parkhausTime = TicketDatenbank.getParkhausTime();
        String formattedTime = parkhausTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        out.println("<p>Aktuelle Zeit im Parkhaus = " + formattedTime + "</p>");
        out.println("</body></html>");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String buttonValue = request.getParameter("button"); // Get the clicked button value


            LocalDateTime T = TicketDatenbank.time_offset;
            // Adjust delta based on the clicked button value
            if (buttonValue.equals("+5 Minuten")) {
                T = T.plusMinutes(5);
            }
            if (buttonValue.equals("+10 Minuten")) {
                T = T.plusMinutes(10);
            }
            if (buttonValue.equals("+1 Stunde")) {
                T = T.plusHours(1);
            }
        if (buttonValue.equals("Reset") ) {
            T = LocalDateTime.now();
        }
            TicketDatenbank.time_offset = T;

        // Redirect back to the doGet method to display the updated time
        response.sendRedirect("Zeit-servlet");
    }


}