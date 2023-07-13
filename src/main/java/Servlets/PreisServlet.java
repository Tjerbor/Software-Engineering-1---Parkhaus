package Servlets;


import Classes.Preis;

import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "preisServlet", value = "/preis-servlet")
public class PreisServlet extends HttpServlet {

    public void init() {

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title style=\"color: purple;\">Preisservlet</title>");
        out.println("<style>");
        out.println("body { background-color: #fff5d7; text-align: center; font-family: Arial, sans-serif; }");
        out.println("h1 { color: purple; font-size: 24px; }");
        out.println("p { font-size: 18px; }");
        out.println("form { display: flex; flex-direction: column; align-items: center; margin-top: 20px; }");
        out.println("input[type='text'] { width: 200px; padding: 5px; margin-bottom: 10px; }");
        out.println("input[type='submit'] { padding: 10px 20px; font-size: 16px; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");

        out.println("<h1>Preisservlet</h1>");

        out.println("<p>Preis pro Stunde: " + Preis.getStundenpreis() + " Euro</p>");
        out.println("<p>Preis pro Tag: " + Preis.getTagespreis() + " Euro</p>");

        out.println("<form action=\"preis-servlet\" method=\"post\">\n" +
                "    <label for=\"stundenPreis\">Verändere Stundenpreis:</label>\n" +
                "    <input type=\"text\" id=\"stundenpreis\" name=\"stundenpreis\"><br><br>\n" +
                "    <label for=\"tagespreis\">Verändere Tagespreis:</label>\n" +
                "    <input type=\"text\" id=\"tagespreis\" name=\"tagespreis\"><br><br>\n" +
                "    <input type=\"submit\" value=\"Submit\">\n" +
                "</form>");

        out.println("</body>");
        out.println("</html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Code for doPost method remains the same
    }

    public void destroy() {
    }


}