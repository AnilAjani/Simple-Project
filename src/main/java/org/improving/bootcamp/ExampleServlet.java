package org.improving.bootcamp;

import org.springframework.stereotype.Controller;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ExampleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<body bgcolor=lightgray>");
        out.println("<h1 align=\"center\" style=\"font-family: 'Comic Sans Ms', Times, Arial; color: #ff3300; font-size: 45px;\">Hello World</h1>");
        out.println("<img src=\"C:\\source\\Simple-project\\src\\main\\resources\\static\" align=\"left\"></img>");
        out.println("<p align=\"center\">Building this is harder than it looks</p>");
        out.println("<ul><li>Link One</li></ul>");
        out.println("<ul><li>Link Two</li></ul>");
        out.println("<ul><li>Link Three</li></ul>");
        out.println("<ul><li>Link Four</li></ul>");
        out.println("</body>");
        out.println("</html>");

    }
}
