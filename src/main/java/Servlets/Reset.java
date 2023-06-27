package Servlets;

import Classes.Autozaehler;
import Classes.Parkhaus;
import Classes.Preis;
import Classes.TicketDatenbank;
import Classes.Tickets.Ticket;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<form action=\"Reset\" method=\"post\">\n" +
                "    <input type=\"submit\" value=\"Reset\">\n" +
                "</form>");

        out.println("</body></html>");



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


            Parkhaus.removeAllTickets() ;
            Parkhaus.addTime_offset(-Parkhaus.time_offset);
        Preis.setStundenpreis(Preis.standart_stundenpreis);
        Preis.setTagespreis (Preis.standart_Tagespreis);
        Autozaehler.verringereAnzahl( Autozaehler.getAutoanzahl());
        Parkhaus.setDauerparkerAnzahl(0);
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Das Parkhaus wurde erfolgreich zurückgesetzt.</h1>");

        out.println("</body></html>");
    }



}
