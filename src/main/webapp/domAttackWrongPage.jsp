<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String name = request.getParameter( "query" );
%>
<script>
    function displayPosts(msg) {
        document.getElementById("msg-container").innerHTML="Hello "+msg+" !";
    }
    window.onload = function() {
        displayPosts('<%=(name)%>');
    }
</script>
<html>
<body>
<div id="msg-container"></div>
<div>
    <form action="index.jsp" method="get">
        <input type="submit" value="Home" />
    </form>
</div>
</body>
</html>
