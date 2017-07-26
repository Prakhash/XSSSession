<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="resources/css/styles.css"/>
    <title>Cross-Site Scripting (XSS)</title>
</head>
<body>
<h1>Cross-Site Scripting (XSS)</h1>


<form action="unprotected" id="unprotectedForm" method="post">
    <fieldset>
        <legend>Unprotected</legend>
        <label for="unprotectedName">Name</label>
        <input type="text" id="unprotectedName" name="unprotectedName"/>
        <input type="submit" value="Send"/>
    </fieldset>
</form>
</body>
</html>

<script>
        function getAttackScript() {
            document.getElementById("msgContainer").innerHTML = document.getElementById('hiddenMsg').innerHTML;
        }
    </script>
<script id="hiddenMsg" language="text">
        <h2><span style="color: #CC704C"> <code>
            "Something with &lt;script>alert(1)&lt;/script> ;) "
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
