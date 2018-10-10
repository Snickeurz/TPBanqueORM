<%-- 
    Document   : processClient
    Created on : 10 oct. 2018, 11:22:59
    Author     : Nicol
--%>

<%@page import="tp1.IDAO" %>
<jsp:useBean id="objClient" class="tp1.Client" />
<jsp:setProperty property="*" name="objClient"/>
<%
   boolean b = IDAO.insert(objClient);  
   if(b)
   {   
    out.print("Client successfully registered");
   }else
   {   
    out.print("Client IS NOT successfully registered");
   }
%>