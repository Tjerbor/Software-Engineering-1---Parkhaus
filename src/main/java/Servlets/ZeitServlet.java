package Servlets;

import Classes.Parkhaus;
import Exceptions.RaumZeitKontinuumException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import static Classes.Parkhaus.addTime_offset;
import static Classes.Parkhaus.getParkhausTime;

@WebServlet(name = "ZeitServlet", value = "/Zeit-servlet")
public class ZeitServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title style=\"color: purple;\">Zeit Servlet</title>");
        out.println("<style>");
        out.println("body {background-color: #fff5d7; text-align: center; font-family: Arial, sans-serif; }");
        out.println("h1 { color: purple; font-size: 24px; }");
        out.println("form { display: flex; justify-content: center; margin-bottom: 10px; }");
        out.println("input[type='submit'] { margin: 5px; font-size: 16px; }");
        out.println("p { font-size: 18px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Zeit Servlet</h1>");

        out.println("<form action=\"Zeit-servlet\" method=\"post\">\n" +
                "    <input type=\"submit\" name=\"button\" value=\"+5 Minuten\">\n" +
                "    <input type=\"submit\" name=\"button\" value=\"+10 Minuten\">\n" +
                "    <input type=\"submit\" name=\"button\" value=\"+1 Stunde\">\n" +
                "</form>");
        out.println("<form action=\"Zeit-servlet\" method=\"post\">\n" +
                "    <label for=\"Reset\">Parkhauszeit zurücksetzen: \n" +
                "    <input type=\"submit\" name=\"button\" value=\"Reset\">\n" +
                "</form>");

        LocalDateTime parkhausTime = getParkhausTime();
        String Datum = parkhausTime.toString();
        out.println("<p>Aktuelle Parkhauszeit: " + Datum.substring(0, 10) + " " + Datum.substring(11, 16) + " Uhr.</p>");
        out.println("</body>");
        out.println("</html>");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Code for doPost method remains the same
    }


}