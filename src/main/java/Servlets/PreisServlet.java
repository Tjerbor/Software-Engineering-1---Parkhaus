package Servlets;



import java.io.*;

import javax.servlet.ServletContext;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "preisServlet", value = "/preis-servlet")
public class PreisServlet extends HttpServlet  {
    private String message;
    String requestParamString="";

    public void init() {
        message = "Preis";

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        String requestParamString = request.getQueryString();
        ServletContext context = getServletContext();
        if (!(requestParamString ==null)){
            message = "Preis "+ requestParamString;

            context.setAttribute( message,message);
        }

        //
        PrintWriter out = response.getWriter();
        out.println("<html>Die Preis kostet<body>");
        out.println("<h1>" +message+ "</h1>");
        out.println("<form action=\"Add-servlet\" method=\"post\">\n" +
                "    <label for=\"preis\">First number:</label>\n" +
                "    <input type=\"number\" id=\"preis\" name=\"preis\"><br><br>\n" +

                "</form>");
        out.println("</body></html>");


    }

    public void destroy() {
    }


}