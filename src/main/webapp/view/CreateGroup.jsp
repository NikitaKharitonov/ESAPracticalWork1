<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create group</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
</head>
<body>
<div class="container w-50">
    <form method="post" action="${pageContext.request.contextPath}/create-group">
        <h1>Create group</h1>
        <div class="form-group">
            <label for="year">Year: </label>
            <input class="form-control" id="year" name="year" type="number" min="1" max="6" required/>
        </div>
        <br>
        <input type="submit" value="Create" class="btn btn-primary"/>
    </form>
</div>
</body>
</html>
