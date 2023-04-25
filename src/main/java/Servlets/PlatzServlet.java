package Servlets;

import Classes.Autozaehler;

import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "platzServlet", value = "/platz-servlet")
public class PlatzServlet extends HttpServlet  {
    private String message;
    String requestParamString="";

    public void init() {
        message = "Platz";

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        String requestParamString = request.getQueryString();
        ServletContext context = getServletContext();
        if (!(requestParamString ==null)){
            message = "Autoanzahl im Parkhaus "+ requestParamString;

            context.setAttribute( message,message);
        }

        //
        PrintWriter out = response.getWriter();
        out.println("<html>Freier Platz<body>");
        out.println("<h1>" +message+ "</h1>");
        out.println("<p>The current number of cars = " + Autozaehler.getAutoanzahl());
        out.println("</body></html>");


    }

    public void destroy() {
    }



}
