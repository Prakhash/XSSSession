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
 
 
 @WebServlet(name = "StoreCookieServlet", urlPatterns = {"/storecookie"})
 public class StoreCookie extends HttpServlet {
     private static final Logger log = LoggerFactory.getLogger(CSPServlet.class);
 
     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
         String name = request.getParameter("cookievalues");
 
         log.info("Received {} as data", name);
 
         response.setContentType("text/html");
         response.setHeader("Content-Security-Policy", "default-src 'self'");
 
         try (PrintWriter out = response.getWriter()) {
             out.println("<html><head>");
             out.println("<title>Cross-Site Scripting (XSS) - Content Security Policy</title>");
             out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"resources/css/styles.css\" />");
             out.println("</head>");
             out.println("<body>");
             out.println("<h1>Cross-Site Scripting (XSS) - Content Security Policy</h1>");
             out.println("<p title='Hello " + name + "'><strong>Hello </strong>");
             out.println("</body></html>");
         } catch (IOException ex) {
             log.error(ex.getMessage(), ex);
         }
     }
 }
