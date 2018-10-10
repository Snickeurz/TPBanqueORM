<%-- 
    Document   : processBank
    Created on : 10 oct. 2018, 11:13:03
    Author     : Nicol
--%>

<%@page import="DAO.DAO_BankBranch" %>
<jsp:useBean id="objBank" class="Models.BankBranch" />
<jsp:setProperty property="*" name="objBank"/>
<%
   out.print("Welcome to processBank.. Purpose : insert into DB a bank object");
   DAO_BankBranch dao_bank = new DAO_BankBranch();
   boolean b = dao_bank.insert(objBank);  
   if(b)
   {   
    out.print("Bank successfully registered");
   }else
   {   
    out.print("Bank IS NOT successfully registered");
   }
%>

