<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="resources/css/styles.css"/>
    <title>Cross-Site Scripting (XSS)</title>
</head>
<body>
<h1>Cross-Site Scripting (XSS)</h1>


<form action="csp" id="cspForm" method="post">
    <fieldset>
        <legend>With Content Security Policy (CSP)</legend>
        <label for="cspName">Name</label>
        <input type="text" id="cspName" name="cspName"/>
        <input type="submit" value="Send"/>
    </fieldset>
</form>

<div>
    <form action="index.jsp" method="get">
        <input type="submit" value="Back" />
    </form>
</div>

</body>
</html>