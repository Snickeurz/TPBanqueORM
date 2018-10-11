<%-- 
    Document   : displayData
    Created on : 10 oct. 2018, 18:45:21
    Author     : Nicolas
--%>

<%@page import="Models.Account"%>
<%@page import="Models.Client"%>
<%@page import="Models.BankBranch"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <title>Data details page</title>
    </head>
    <body>
        <!-- AFFICHAGE DES ACCOUNTS  -->
            <%
            if(request.getAttribute("listAccount") != null)
            {
                List<Account> listAccount = (List<Account>) request.getAttribute("listAccount"); 
            %>
            <div class="bg-info"><h3 class="text-center">LISTE ACCOUNT <span class="fas fa-users"></span></h3></div>
                <table class="table table-dark">
                <thead>
                  <tr>
                    <th scope="col">ID <span class="fas fa-user-tie"></span></th>
                    <th scope="col">Libelle <span class="fas fa-signature"></span></th>
                    <th scope="col">IBAN <span class="fas fa-money-check-alt"></span></th>
                    <th scope="col">Solde <span class="fas fa-dollar-sign"></span></th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                <%
                for (Account account: listAccount)
                {
                %>
                  <tr>
                    <th scope="row"><%=account.getNum_compte()%></th>
                    <td><%=account.getLibelle()%></td>
                    <td><%=account.getIBAN()%></td>
                    <td><%=account.getSolde()%></td>
                    <td><a href="${pageContext.request.contextPath}/servletAccount?delete=<%=account.getNum_compte()%>"><span class="fa fa-trash" style="color:red;"></span></a></td>
                  </tr>
                  <%
                }
                 %>
            </tbody>
        </table>
                 <%
            }
              %>
              
              
     <!-- AFFICHAGE DES CLIENTS -->
       <%
            if(request.getAttribute("listClient") != null)
            {
                List<Client> listClient = (List<Client>) request.getAttribute("listClient"); 
            %>
            <div class="bg-info"><h3 class="text-center">LISTE CLIENTS</h3></div>
                <table class="table table-dark">
                <thead>
                  <tr>
                    <th scope="col">ID client <span class="fas fa-users"></span></th>
                    <th scope="col">NOM <span class="fas fa-user-tag"></span></th>
                    <th scope="col">PRENOM <span class="fas fa-user-tag"></span></th>
                    <th scope="col">DATE NAISS <span class="fas fa-calendar-alt"></span></th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                <%
                for (Client client: listClient)
                {
                %>
                  <tr>
                    <th scope="row"><%=client.getNumClient()%></th>
                    <td><%=client.getNomClient()%></td>
                    <td><%=client.getPrenomClient()%></td>
                    <td><%=client.getDateNaiss()%></td>
                    <td><a href="${pageContext.request.contextPath}/servletClient?delete=<%=client.getNumClient()%>"><span class="fa fa-trash" style="color:red;"></span></a></td>
                  </tr>
                  <%
                }
                 %>
            </tbody>
        </table>
                 <%
            }
              %>
              
              
     <!-- AFFICHAGE DES BANKBRANCH -->
       <%
            if(request.getAttribute("listBank") != null)
            {
                List<BankBranch> listBank = (List<BankBranch>) request.getAttribute("listBank"); 
            %>
            <div class="bg-info"><h3 class="text-center">LISTE DES BANKS <span class="fas fa-university"></span></h3></div>
                <table class="table table-dark">
                <thead>
                  <tr>
                    <th scope="col">ID BANK <span class="fas fa-id-badge"></span></th>
                    <th scope="col">ADRESSE BANK <span class="fas fa-map"></span></th>
                    <th scope="col"></th>
                  </tr>
                </thead>
                <tbody>
                <%
                for (BankBranch bank: listBank)
                {
                %>
                  <tr>
                    <th scope="row"><%=bank.getCodeAgence()%></th>
                    <td><%=bank.getAdresse()%></td>
                    <td><a href="${pageContext.request.contextPath}/servletBank?delete=<%=bank.getCodeAgence()%>"><span class="fa fa-trash" style="color:red;"></span></a></td>
                  </tr>
                  <%
                }
                 %>
            </tbody>
        </table>
                 <%
            }
              %>
    </body>
</html>
