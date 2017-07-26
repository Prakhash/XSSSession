
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

@WebServlet(name = "Persistance", urlPatterns = {"/persistance"})
public class WriteToFileServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UnprotectedServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String name = request.getParameter("unprotectedName");

        log.info("Received {} as data", name);

        String currentWorkingDirectory = System.getProperty("user.dir") + System.getProperty("file.separator");

        try {
            PrintWriter writer = new PrintWriter(currentWorkingDirectory + "details.txt", "UTF-8");
            writer.println(name);
            writer.close();
        } catch (IOException e) {
            // do something
        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head>");
            out.println("<title>Cross-Site Scripting (XSS) - Input Validation</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/styles.css\" />");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cross-Site Scripting (XSS) - Input Validation</h1>");
            out.println("<p>input is saved in to the directory</p>");
            out.println("<p><a href=\"showDataStored.jsp\">Show stored data</a></p></br>");
            out.println("<p><a href=\"index.jsp\">Home</a></p>");
            out.println("</body></html>");
        } catch (IOException ex) {
            log.error(ex.getMessage(), ex);
        }
    }
}
