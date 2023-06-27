package Servlets;

import Classes.Autozaehler;
import Classes.Parkhaus;

import java.io.*;

import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "platzServlet", value = "/platz-servlet")
public class PlatzServlet extends HttpServlet {

    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Platz</h1>");
        out.println("<p>Zurzeitige Anzahl von Autos: " + Autozaehler.getAutoanzahl() + "</p>");
        out.println("<p>Offiziel frei verfügbare Parkplätze: " + Parkhaus.getOffizielFreieParkplaetze() + "</p>");
        out.println("<p>Inoffiziel frei verfügbare Parkplätze: " + Parkhaus.getInoffizielFreieParkplaetze() + "</p>");
        out.println("<p>Größe der Parkhauses: " + Parkhaus.getParkplaetze() + "</p>");
        out.println("</body></html>");


    }

    public void destroy() {
    }


}
