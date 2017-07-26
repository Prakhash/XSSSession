
package org.wso2.pk.xss;

import org.owasp.encoder.Encode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "OutputEscapedServlet", urlPatterns = {"/escaped"})
public class OutputEscapedServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(OutputEscapedServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String name = request.getParameter("outputEscapedName");

        log.info("Received {} as data", name);

        response.setContentType("text/html");

        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head>");
            out.println("<title>Cross-Site Scripting (XSS) - Output Escaping</title>");
            out.println("<link rel='stylesheet' type='text/css' href='resources/css/styles.css' />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cross-Site Scripting (XSS) - Output Escaping</h1>");
            out.println("<p title='Hello " + Encode.forHtmlAttribute(name) + "'><strong>Hello </strong>");
            Encode.forHtml(out, name);
            out.println("</p>");
            out.println("<p><a href='index.jsp'>Home</a></p>");
            out.println("</body></html>");
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        }
    }
}
