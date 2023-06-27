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

        out.println("</body></html>");


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tagespreis = request.getParameter("tagespreis");
        String stundenpreis = request.getParameter("stundenpreis");
        if (tagespreis != null) {
            try {
                Preis.setTagespreis(Double.parseDouble(tagespreis));
            } catch (Exception e) {

            }
        }
        if (stundenpreis != null) {
            try {
                Preis.setStundenpreis(Double.parseDouble(stundenpreis));
            } catch (Exception e) {

            }
        }
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
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
        out.println("</body></html>");

    }


    public void destroy() {
    }


}