<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="resources/css/styles.css"/>
    <title>Cross-Site Scripting (XSS)</title>
</head>
<body>
<h1>Cross-Site Scripting (XSS)</h1>

<form method="get" action="domAttackWrongPage.jsp">
 <fieldset>
        <legend>DOMBased</legend>
    Search: <input name="query"  type="text">
    <input type="submit" value="Submit"  />
</fieldset>
</form>



<script>
        function getAttackScript() {
            document.getElementById("msgContainer").innerHTML = document.getElementById('hiddenMsg').innerHTML;
        }
    </script>
<script id="hiddenMsg" language="text">
        <h2><span style="color: #CC704C"> <code>
            " &lt;img src="http://s1.dmcdn.net/C0N7k/1280x720-zCz.jpg"/>
            </code></span> </h2>
    </script>
<p id="msgContainer" onclick="getAttackScript() "><span style="color: #0066cc"> Click me to get the attacking script.</span></p>

<div>
    <form action="index.jsp" method="get">
        <input type="submit" value="Back" />
    </form>
</div>
</body>
</html>

<!--<p id="msgContainer" onclick="getAttackScript() "><span style="color: #0066cc"> Click me to get the attacking script.</span></p>-->
<script>
        function getAttackScript() {
            document.getElementById("msgContainer").innerHTML ="Hello "+name=+" !";        }
</script>
