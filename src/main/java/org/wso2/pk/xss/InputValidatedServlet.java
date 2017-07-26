

package org.wso2.pk.xss;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "InputValidatedServlet", urlPatterns = {"/validated"})
public class InputValidatedServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(InputValidatedServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String name = request.getParameter("inputValidatedName");

        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();

        }

        log.info("\nUser "+ ipAddress+ " is trying to access the server with data"+name);


        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head>");
            out.println("<title>Cross-Site Scripting (XSS) - Input Validation</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/styles.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cross-Site Scripting (XSS) - Input Validation</h1>");
            out.println("<p>[" + name + "]</p>");
            out.println("<p><a href=\"index.jsp\">Home</a></p>");
            out.println("</body></html>");
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        }
    }
}
