<%-- 
    Document   : AnswerContact
    Created on : Aug 10, 2020, 10:56:08 AM
    Author     : Ayeshmi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="contactCSS.css" rel="styleSheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="bg-img">
        <div class="topnav">
 <p style="  color:white;   font-size:30px; font-family: brush script mt;">MY RECIPES.</p>
  <a class="active" href="#home">Home</a>
<a href="">Contact</a>
            <a href="">About</a>
            <a href="">Login</a>
            <a href="">Logout</a>
</div>
         
         <h1>RESPOND TO PROBLEMS.</h1>
      
                <form   action="NewServlet"  Method="GET" style="width: 400px; height: 575px;background-color: lightgrey;
  
  padding: 50px;
  margin: 20px;position: relative;margin: 6% auto;">
                <input type="hidden" name="command" value="ANSWERCONTACT2"/>
                
                 <c:forEach var="tempUser" items="${Contact_List}">
               
                     <label for="fname" style="font-family:helvetica;"><b>Name:</b></label>
<input type="text" id="fname" name="name"  value="${tempUser.getName()}" ><br><br>

<label for="fname" style="font-family:helvetica;"><b>Email:</b></label><br>
<input type="text" id="fname" name="email"  value="${tempUser.getEmail()}" ><br><br>

<label for="fname" style="font-family:helvetica;"><b>Date:</b></label><br>
<input type="text" id="fname" name="date"  value="${tempUser.getDate()}" ><br><br>

<label for="fname" style="font-family:helvetica;"><b>Description:</b></label><br>
<input type="text" id="fname" name="description"  value="${tempUser.getDescription()}" ><br><br>

<label for="fname" style="font-family:helvetica;"><b>Answer:</b></label><br>
<input type="text" id="fname" name="answer" ><br><br>

<input  type="submit" value="SUBMIT" style=" background-color: #4CAF50; border: 2px solid #008CBA;  font-size: 15px; padding: 10px 32px; font-family:helvetica;">
 <button  onclick="location.href='updateUserDetails1.jsp';" style=" background-color: #4CAF50; border: 2px solid #008CBA;  font-size: 15px; padding: 10px 32px; font-family:helvetica;"> CANCEL</button>

                 </c:forEach>               
</form>          
        </div>
    </body>
</html>
