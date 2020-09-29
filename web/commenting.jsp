<%-- 
    Document   : commenting
    Created on : Aug 19, 2020, 11:50:27 AM
    Author     : Ayeshmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
                 <form action="NewServlet" Method="GET" >
<input type="hidden" name="command" value="ADDCOMMENT"/>
<label for="name"><b>NAME:</b></label><br>
      <input type="text" placeholder="Enter Name" name="name" required><br>
        <label for="message">Message:</label><br>

<textarea id="message" name="message" rows="4" cols="50">
Ayeshmi Samaradivakara
</textarea>
            <button type="submit" class="btn">COMMENT</button>

                 </form>
    </body>
</html>
