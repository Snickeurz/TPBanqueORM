<%-- 
    Document   : processAccount
    Created on : 10 oct. 2018, 11:21:57
    Author     : Nicol
--%>

<%@page import="DAO.DAO_Account" %>
<jsp:useBean id="objAccount" class="Models.Account" />
<jsp:setProperty property="*" name="objAccount"/>
<%
   DAO_Account a = new DAO_Account();
   boolean b = a.insert(objAccount);  
   if(b)
   {   
    out.print("Account successfully registered");
   }else
   {   
    out.print("Account IS NOT successfully registered");
   }
%>