<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.BufferedReader"%>
<%


        String currentWorkingDirectory = System.getProperty("user.dir") + System.getProperty("file.separator");
        String filename=currentWorkingDirectory+"details.txt";
        BufferedReader reader= new BufferedReader(new FileReader(filename));

        String sCurrentLine;

        			if((sCurrentLine = reader.readLine()) != null) {
        				out.println("<p>[" + sCurrentLine + "]</p>");
        			}


%>



<div>
    <form action="index.jsp" method="get">
        <input type="submit" value="Home" />
    </form>
</div>




