<%--
  Created by IntelliJ IDEA.
  User: sbinf
  Date: 26-10-2017
  Time: 10:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1>Upload File</h1>
  <form action="rest/test/upload" method="post" enctype="multipart/form-data">
    <p>Select a file : <input type="file" name="file"/></p>
    <input type="submit" value="Upload File" />
  </form>
  </body>
</html>
