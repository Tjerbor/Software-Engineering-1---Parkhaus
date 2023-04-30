package Servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "verlassenServlet", value = "/verlassen-servlet")


public class VerlassenServlet  extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>verlassenServlet</h1>");
        out.println("<form action=\"verlassen-servlet\" method=\"post\">\n" +
                "    <label for=\"TicketID\">TicketID \n" +
                "    <input type=\"text\" id=\"TicketID\" name=\"TicketID\"><br><br>\n" +
                "    <input type=\"submit\" value=\"Submit\">\n" +
                "</form>");

        out.println("</body></html>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Id = request.getParameter("TicketID");
        response.setContentType("text/html");

    }

}