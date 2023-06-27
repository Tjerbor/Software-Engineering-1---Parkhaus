package Servlets;

import Classes.Parkhaus;
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
        out.println("<html><body>");

        out.println("<h1>Parkhaus reset </h1>");
        out.println("<form action=\"/Reset\" method=\"post\">\n" +

                "    <input type=\"submit\" value=\"Reset\">\n" +
                "</form>");


        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext servCon = getServletContext();

            Parkhaus.removeAllTickets() ;
            TicketDatenbank.addTime_offset(-TicketDatenbank.time_offset);
    }

    public void destroy() {

    }
}
