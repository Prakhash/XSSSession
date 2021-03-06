<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="resources/css/styles.css"/>
    <title>Cross-Site Scripting (XSS)</title>
</head>
<body>
<h1>Cross-Site Scripting (XSS)</h1>

<form action="escaped" id="escapedForm" method="post">
    <fieldset>
        <legend>With Output Escaping</legend>
        <label for="outputEscapedName">Name</label>
        <input type="text" id="outputEscapedName" name="outputEscapedName"/>
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
