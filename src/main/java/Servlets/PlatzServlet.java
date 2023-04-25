package Servlets;

import Classes.Autozaehler;

import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "platzServlet", value = "/platz-servlet")
public class PlatzServlet extends HttpServlet  {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Platz</h1>");
        out.println("<p>The current number of cars = " + Autozaehler.getAutoanzahl());
        out.println("</body></html>");


    }

    public void destroy() {
    }



}
